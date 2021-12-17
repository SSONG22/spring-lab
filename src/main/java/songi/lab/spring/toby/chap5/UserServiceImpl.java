package songi.lab.spring.toby.chap5;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.jta.JtaTransactionManager;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionSynchronizationManager;
import songi.lab.spring.toby.chap1.User;
import songi.lab.spring.toby.chap1.dao.UserDao;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl {

    private UserDao userDao;
    private PlatformTransactionManager transactionManager;

    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
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

}
