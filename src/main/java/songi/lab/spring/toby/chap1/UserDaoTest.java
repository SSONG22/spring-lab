package songi.lab.spring.toby.chap1;

import songi.lab.spring.toby.chap1.dao.UserDao;
import songi.lab.spring.toby.chap1.db.ConnectionMaker;
import songi.lab.spring.toby.chap1.db.NConnectionMaker;

public class UserDaoTest {
    public static void main(String[] args) {
        UserDao dao = new DaoFactory().userDao();
//        ...
    }
}
