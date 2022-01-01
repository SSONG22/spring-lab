package songi.lab.spring.toby.chap7;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public abstract class AbstractUpdatableSqlRegistryTest {
    // UpdatableSqlRegistry인터페이스를 구현한 모든 클래스에 대한 테스트를 만들때 사용할 수 있다.
    UpdatableSqlRegistry sqlRegistry;

    @BeforeAll
    void setUp(){
        sqlRegistry = createUpdatableRegistry();
        sqlRegistry.registerSql("KEY1", "SQL1");
        sqlRegistry.registerSql("KEY2", "SQL2");
        sqlRegistry.registerSql("KEY3", "SQL3");
    }

    // 테스트 픽스처를 생성하는 부분만 추상 메서드로 만들어두고 서브 클래스에서 이를 구현하도록 한다.
    abstract protected UpdatableSqlRegistry createUpdatableRegistry();

    @Test
    void find(){
        checkFindResult("SQL1", "SQL2", "SQL3");
    }

    private void checkFindResult(String sql1, String sql2, String sql3) {
        assertThat(sqlRegistry.findSql("KEY1")).isEqualTo(sql1);
        assertThat(sqlRegistry.findSql("KEY2")).isEqualTo(sql2);
        assertThat(sqlRegistry.findSql("KEY3")).isEqualTo(sql3);
    }
}
