package songi.lab.spring.toby.chap3;

import org.springframework.format.annotation.DateTimeFormat;
import songi.lab.spring.toby.chap1.pattern.StatementStrategy;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcContext {
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource; // DataSource 타입 빈을 DI 받을 수 있게 준비
    }

    public void workWithStatementStrategy(StatementStrategy stmt) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;

        try {
            c = this.dataSource.getConnection();
            ps = (PreparedStatement) stmt.makePreparedStatement(c);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            if(ps!=null) {
                try {
                    ps.close();
                }catch (SQLException e) {}
            }
            if(c!=null) {
                try {
                    c.close();
                }catch (SQLException e) {}
            }
        }
    }

}
