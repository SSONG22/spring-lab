package songi.lab.spring.toby.chap7;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import javax.sql.DataSource;
import java.util.Map;

public class EmbeddedDbSqlRegistry implements UpdatableSqlRegistry {
    //        SimpleJdbcTemplate jdbc;
    TransactionTemplate transactionTemplate;

    void setDataSource(DataSource dataSource) {
//        jdbc = new SimpleJdbcTemplate(dataSource);
        transactionTemplate = new TransactionTemplate(
                new DataSourceTransactionManager(dataSource));
    }

    @Override
    public String findSql(String key) throws SqlNotFoundExcpeion {
        return null;
    }

    @Override
    public void registerSql(String key, String sql) {
//        jdbc.update("insert info sqlmap(key_, sql_) values(?,?)", key, sql);
    }

    @Override
    public void updateSql(String key, String sql) throws SqlNotFoundExcpeion {

    }

    @Override
    public void updateSql(final Map<String, String> sqlmap) throws SqlNotFoundExcpeion {
        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            // 트랜잭션 템플릿이 만드는 트랜잭션 경계 안에서 동작할 코드를 콜백 형태로 만들고 TransactionTemplate 의 execute() 메소드에 전달한다.
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus status) {
                for (Map.Entry<String, String> entry : sqlmap.entrySet()) {
                    updateSql(entry.getKey(), entry.getValue());
                }
            }
        });
    }
}
