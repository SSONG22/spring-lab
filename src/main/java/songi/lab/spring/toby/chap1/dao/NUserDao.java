package songi.lab.spring.toby.chap1.dao;

import songi.lab.spring.toby.chap1.db.ConnectionMaker;

import java.sql.Connection;
import java.sql.SQLException;

public class NUserDao extends UserDao {

    public NUserDao(ConnectionMaker connectionMaker) {
        super(connectionMaker);
    }
}
