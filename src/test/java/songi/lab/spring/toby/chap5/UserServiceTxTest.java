package songi.lab.spring.toby.chap5;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;
import songi.lab.spring.toby.chap1.User;
import songi.lab.spring.toby.chap1.dao.UserDao;

import javax.swing.tree.ExpandVetoException;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@Transactional
class UserServiceTxTest {


}