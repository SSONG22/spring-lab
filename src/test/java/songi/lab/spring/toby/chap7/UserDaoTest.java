package songi.lab.spring.toby.chap7;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ActiveProfiles("test")
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = AppContext.class)
public class UserDaoTest {
    @Autowired
    DefaultListableBeanFactory bf;

    @Test
    void beans() {
        for (String n : bf.getBeanDefinitionNames()) {
            System.out.println(n + " \t " + bf.getBean(n).getClass().getName());
        }
    }
}
