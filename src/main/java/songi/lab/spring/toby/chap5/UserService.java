package songi.lab.spring.toby.chap5;

import songi.lab.spring.toby.chap1.User;

import java.sql.SQLException;

public interface UserService {
    void add(User user);
    void upgradeLevels() throws SQLException;
}
