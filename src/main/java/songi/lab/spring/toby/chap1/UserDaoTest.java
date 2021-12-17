package songi.lab.spring.toby.chap1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import songi.lab.spring.toby.chap1.dao.UserDao;

import java.sql.SQLException;

public class UserDaoTest {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        UserDao dao = new DaoFactory().userDao();
        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(DaoFactory.class);
        UserDao userDao = applicationContext.getBean("userDao", UserDao.class);
        // userDao 라는 이름을 가진 빈을 가져온다
        User user = userDao.get("user1");
        System.out.println(user.getId());
        System.out.println(user.getPw());
        System.out.println(user.getId()+" 조회 성공");


    }
}
