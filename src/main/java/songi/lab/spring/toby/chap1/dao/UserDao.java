package songi.lab.spring.toby.chap1.dao;

import songi.lab.spring.toby.chap1.User;
import songi.lab.spring.toby.chap1.db.ConnectionMaker;

import java.sql.SQLException;

public class UserDao {
    private ConnectionMaker connectionMaker;

    public UserDao(ConnectionMaker connectionMaker) {
        // 상태를 관리하는 것이 아니니 한번만 만들어 인스턴스 변수에 저장해두고 메소드에서 사용하게 한다.
//        dConnectionMaker = new DConnectionMaker();
        connectionMaker = connectionMaker;
    }

    public void add(User user) throws ClassNotFoundException, SQLException { // throws 코드 생략
        // jdbc 드라이버 조회
        // DB connection 객체 획득 w/db_url/_name/_password
        // (Prepared)Statement 객체 활용해 SQL문 작성
        // 쿼리 실행
        // (Prepared)Statement 객체 close
        // DB connection 객체 close
    }

    public User get(String id) throws ClassNotFoundException, SQLException {
        // SQL 작성까지는 동일
        // 쿼리 실행 후 값을 ResultSet 객체에 저장
        // 새 User 객체 만들기
        // setter들 이용해서 ResultSet 객체 속 값들을 User 객체 속으로 복사
        // (Prepared)Statement 객체 close
        // DB connection 객체 close
        // ResultSet 객체 close
        // 유저 리턴
        return new User();
    }
}
