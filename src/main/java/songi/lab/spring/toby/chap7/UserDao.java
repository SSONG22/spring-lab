package songi.lab.spring.toby.chap7;

import songi.lab.spring.toby.chap1.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    User get(String id);
    List<User> getAll();
    void deleteAll();
    int getCount();
    void update(User user);
}
