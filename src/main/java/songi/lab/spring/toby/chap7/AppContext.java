package songi.lab.spring.toby.chap7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.validation.annotation.Validated;
import songi.lab.spring.toby.chap5.UserService;
import songi.lab.spring.toby.chap5.UserServiceImpl;

import javax.sql.DataSource;
import java.sql.Driver;

@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "songi.lab.spring.toby.chap7")
@EnableSqlService
@PropertySource("/database.properties")
public class AppContext implements SqlMapConfig{

    @Value("${db.drivcerClass}") Class<? extends Driver> driverClass;
    @Value("${db.url}") String url;
    @Value("${db.username}")String username;
    @Value("${db.password}")String password;

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer(){
        return new PropertySourcesPlaceholderConfigurer();
    }

    /**
     * DB 연결과 트랜잭션
     */
    @Bean
    public DataSource dataSource() {
        SimpleDriverDataSource dataSource = new SimpleDriverDataSource();
//        try {
//            dataSource.setDriverClass((Class<? extends java.sql.Driver>)
//                    Class.forName(env.getProperty("db.driverClass")));
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException();
//        }
//        dataSource.setUrl(env.getProperty("db.url"));
//        dataSource.setUsername(env.getProperty("db.username"));
//        dataSource.setPassword(env.getProperty("db.password"));

        dataSource.setDriverClass(driverClass);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);

        return dataSource;
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        DataSourceTransactionManager tm = new DataSourceTransactionManager();
        tm.setDataSource(dataSource());
        return tm;
    }

    /**
     * 애플리케이션 로직 & 테스트
     */

    @Autowired
    SqlService sqlService;

    //    @Bean
//    public UserDao userDao() {
//        return new UserDaoJdbc();
//    }
    @Autowired
    UserDao userDao;

    @Bean
    public UserService userService() {
        UserServiceImpl service = new UserServiceImpl();
        service.setUserDao(userDao);
        return service;
    }

    @Bean
    public SqlMapConfig sqlMapConfig(){
        return new UserSqlMapConfig();
    }

    @Override
    public Resource getSqlMapResource() {
        return new ClassPathResource("sqlmap.xml", UserDao.class);
    }

    @Configuration
    @Profile("production")
    public static class ProductionAppContext {

    }

    @Configuration
    @Profile("test")
    public static class TestAppContext {
        @Autowired
        UserDao userDao;

        @Bean
        public UserService testUserService() {
            return new TestUserService();
        }
    }
}
