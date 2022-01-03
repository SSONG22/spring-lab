package songi.lab.spring.toby.chap7;

import org.springframework.beans.factory.annotation.Autowired;
import songi.lab.spring.toby.chap1.User;
import songi.lab.spring.toby.chap5.UserService;

import java.sql.SQLException;

public class TestUserService implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void add(User user) {

    }

    @Override
    public void upgradeLevels() throws SQLException {

    }
}
