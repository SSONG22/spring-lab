package songi.lab.spring.toby.chap1;

import songi.lab.spring.toby.chap1.dao.UserDao;
import songi.lab.spring.toby.chap1.db.ConnectionMaker;
import songi.lab.spring.toby.chap1.db.DConnectionMaker;

public class DaoFactory {
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
