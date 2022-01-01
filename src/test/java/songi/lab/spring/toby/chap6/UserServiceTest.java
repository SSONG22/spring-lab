package songi.lab.spring.toby.chap6;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import songi.lab.spring.toby.chap1.User;
import songi.lab.spring.toby.chap5.UserService;
import songi.lab.spring.toby.chap5.UserServiceImpl;

import static org.assertj.core.api.Assertions.assertThat;

public class UserServiceTest {

    @Autowired
    UserService userService;

    @Autowired
    UserService testUserService;

    static class TestUserServiceImpl extends UserServiceImpl {
        private String id = "madnite1";

        public void upgradeLevel(User user) {
            if (user.getId().equals(this.id)) {
                throw new TestUserServiceException();
            }
            super.upgradeLevel(user);
        }
    }

    @Test
    void upgradeAllOrNothing(){

    }

    @Test
    void advisorAutoProxyCreator(){
        assertThat(testUserService).isEqualTo(java.lang.reflect.Proxy.class);
    }


    PlatformTransactionManager transactionManager;
    @Test
    void transactionSync(){
        DefaultTransactionDefinition txDefinition = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(txDefinition);
    }
}
