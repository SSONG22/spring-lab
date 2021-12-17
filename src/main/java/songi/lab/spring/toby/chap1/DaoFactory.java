package songi.lab.spring.toby.chap1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import songi.lab.spring.toby.chap1.dao.UserDao;
import songi.lab.spring.toby.chap1.db.ConnectionMaker;
import songi.lab.spring.toby.chap1.db.DConnectionMaker;

@Configuration // 애플리 케이션 컨텍스트 또는 빈 팩토리가 사용할 설정 정보라는 표시
public class DaoFactory {

    @Bean // 오브젝트 생성을 담당하는 IoC용 메서드라는 표시
    public UserDao userDao(){
        // 팩토리의 메소드는 UserDao 타입의 오브젝트를 어떻게 만들고, 어떻게 준비시킬지 결정한다.
//        ConnectionMaker connectionMaker = new DConnectionMaker();
//        UserDao userDao = new UserDao(connectionMaker);
//        return userDao;
        return new UserDao(connectionMaker());
    }

//    public AcountDao accountDao(){
//        return new AccountDao(new DConnectionMaker());
//    }

    public ConnectionMaker connectionMaker(){
        return new DConnectionMaker(); // 분리해서 중복을 제거한 ConnectionMaker 타입 오브젝트 생성 코드
    }
}
