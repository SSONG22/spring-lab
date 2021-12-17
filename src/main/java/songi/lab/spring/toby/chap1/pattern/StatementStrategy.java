package songi.lab.spring.toby.chap1.pattern;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public interface StatementStrategy {
    Statement makePreparedStatement(Connection c) throws SQLException;
}
