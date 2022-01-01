package songi.lab.spring.toby.chap7;

public interface SqlRegistry {
    void registerSql(String key, String sql);
    String findSql(String key) throws SqlNotFoundExcpeion;
}
