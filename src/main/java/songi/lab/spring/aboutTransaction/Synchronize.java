package songi.lab.spring.aboutTransaction;

import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.sql.DataSource;
import java.sql.Connection;

public class Synchronize {
    DataSource dataSource;

    // 작업 단위를 하나로 만들기 위해 ? -> 트랜잭션의 두 경계를 묶어준다.
    // 커넥션에서 커밋설정을 꺼두면 커밋은 발생하지 않을 것이고,
    // 트랜잭션의 경계설정의 종료 작업의 순간이 발생하지 않는다.
    /*
        Connection conn = dataSource.getConnection();
        conn.setAutoCommit(false);
     */

    // Connection을 사용하지 않고 jdbcTemplate을 사용할 때
    void transactionSynchronization() {
        // 동기화 시작
        TransactionSynchronizationManager.initSynchronization();
        Connection conn = DataSourceUtils.getConnection(dataSource);

        // 작업 진행 ...
//        try{
//            conn.commit();
//        }catch (Exception e){
//            conn.rollback();
//        }finally {
        // 동기화 종료
        DataSourceUtils.releaseConnection(conn, dataSource); // DB 커넥션 닫기
        TransactionSynchronizationManager.unbindResource(dataSource); // 리소스 해제
        TransactionSynchronizationManager.clearSynchronization();
//        }
    }

    void platformTransactionManager() {
        PlatformTransactionManager transactionManager = new DataSourceTransactionManager(dataSource);
        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
        try {
            // 작업
            transactionManager.commit(status);
        } catch (Exception e) {
            transactionManager.rollback(status);
        } finally {
            transactionManager.rollback(status);
        }
    }

}
