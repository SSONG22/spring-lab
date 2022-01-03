package songi.lab.spring.toby.chap5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import songi.lab.spring.toby.chap1.User;
import songi.lab.spring.toby.chap7.UserDao;

import java.sql.SQLException;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    private PlatformTransactionManager transactionManager;

    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    @Override
    public void add(User user) {

    }

    public void upgradeLevels() throws SQLException {
        // DI 받은 트랜잭션 매니저를 공유해서 사용한다. 멀티 스레드 환경에서도 안전하다.
        TransactionStatus status = this.transactionManager.getTransaction(new DefaultTransactionDefinition());
        try {
            List<User> users = userDao.getAll();

            for (User user : users) {
                if (canUpgradeLevel(user)) {
                    upgradeLevel(user);
                }
            }
            this.transactionManager.commit(status); // 트랜잭션 커밋
        } catch (Exception e) {
            this.transactionManager.rollback(status); // 트랜잭션 롤백
            throw e;
        }
    }

    public void upgradeLevel(User user) {
//        user.upgradeLevel();
//        userDao.update(user);
    }

    private boolean canUpgradeLevel(User user) {
        return user.getLevel() != Level.COLD;
    }

    public void setUserDao(songi.lab.spring.toby.chap7.UserDao userDao) {
        this.userDao = userDao;
    }
}
