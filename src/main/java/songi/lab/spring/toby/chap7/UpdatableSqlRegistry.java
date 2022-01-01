package songi.lab.spring.toby.chap7;

import java.util.Map;

public interface UpdatableSqlRegistry {
    String findSql(String key) throws SqlNotFoundExcpeion;

    void registerSql(String key, String sql);

    void updateSql(String key, String sql) throws SqlNotFoundExcpeion;

    void updateSql(Map<String, String> sqlmap) throws SqlNotFoundExcpeion;
}
