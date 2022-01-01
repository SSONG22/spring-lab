package songi.lab.spring.toby.chap7;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentHashMapSqlRegistry implements UpdatableSqlRegistry {
    private Map<String, String> sqlMap = new ConcurrentHashMap<>();

    public String findSql(String key) throws SqlNotFoundExcpeion {
        String sql = sqlMap.get(key);
        if (sql == null) {
            throw new SqlNotFoundExcpeion();
        }
        return sql;
    }

    public void registerSql(String key, String sql) {
        sqlMap.put(key, sql);
    }

    public void updateSql(String key, String sql) throws SqlNotFoundExcpeion {
        if (sqlMap.get(key) == null) {
            throw new SqlNotFoundExcpeion();
        }
        sqlMap.put(key, sql);
    }

    public void updateSql(Map<String, String> sqlmap) throws SqlNotFoundExcpeion {
        for (Map.Entry<String, String> entry : sqlmap.entrySet()) {
            updateSql(entry.getKey(), entry.getValue());
        }
    }
}
