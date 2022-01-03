package songi.lab.spring.toby.chap7;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import songi.lab.spring.toby.chap1.User;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class UserDaoJdbc implements UserDao {
    @Autowired
    private SqlService sqlService;
    private DataSource dataSource;

    public void setSqlService(SqlService sqlService) {
        this.sqlService = sqlService;
    }

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void add(User user) {

    }

    @Override
    public User get(String id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public void deleteAll() {

    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public void update(User user) {

    }

}
