package songi.lab.spring.toby.chap7;

public class ConcurrentHashMapSqlRegistryTest extends AbstractUpdatableSqlRegistryTest {
    @Override
    protected UpdatableSqlRegistry createUpdatableRegistry() {
        return new ConcurrentHashMapSqlRegistry();
    }
}
