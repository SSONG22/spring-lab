package songi.lab.spring.toby.chap1.db;

import java.sql.Connection;
import java.sql.SQLException;

public interface ConnectionMaker {
    public Connection makeConnection() throws ClassNotFoundException,SQLException;
}
