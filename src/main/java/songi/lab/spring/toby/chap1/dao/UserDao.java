package songi.lab.spring.toby.chap1.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import songi.lab.spring.toby.chap1.User;
import songi.lab.spring.toby.chap1.db.ConnectionMaker;
import songi.lab.spring.toby.chap1.pattern.StatementStrategy;
import songi.lab.spring.toby.chap3.JdbcContext;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

public class UserDao {
    private ConnectionMaker connectionMaker;

    private JdbcContext jdbcContext;

    private JdbcTemplate jdbcTemplate;

    public void setJdbcContext(JdbcContext jdbcContext) {
        this.jdbcContext = jdbcContext; //
    }

    public UserDao(ConnectionMaker connectionMaker) {
        // 상태를 관리하는 것이 아니니 한번만 만들어 인스턴스 변수에 저장해두고 메소드에서 사용하게 한다.
//        dConnectionMaker = new DConnectionMaker();
        this.connectionMaker = connectionMaker;
    }

    public void add(User user) throws ClassNotFoundException, SQLException { // throws 코드 생략
        // jdbc 드라이버 조회
        // DB connection 객체 획득 w/db_url/_name/_password
        // (Prepared)Statement 객체 활용해 SQL문 작성
        // 쿼리 실행
        // (Prepared)Statement 객체 close
        // DB connection 객체 close
    }

    public User get(String id) throws ClassNotFoundException, SQLException {
        // SQL 작성까지는 동일
        // 쿼리 실행 후 값을 ResultSet 객체에 저장
        // 새 User 객체 만들기
        // setter들 이용해서 ResultSet 객체 속 값들을 User 객체 속으로 복사
        // (Prepared)Statement 객체 close
        // DB connection 객체 close
        // ResultSet 객체 close
        // 유저 리턴
        return new User();
    }

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public void deleteAll() {
//        this.jdbcTemplate.update(
//                new PreparedStatementCreator() {
//                    @Override
//                    public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
//                        return con.prepareStatement("delete from users");
//                    }
//                }
//        );
        this.jdbcTemplate.update("delete from users");
    }

    public int getCount() {
        return this.jdbcTemplate.query(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                return con.prepareStatement("select count(*) from users");
            }
        }, new ResultSetExtractor<Integer>() {
            @Override
            public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
                rs.next();
                return rs.getInt(1);
            }
        });
    }

    public User get2(String id) {
        return this.jdbcTemplate.queryForObject("select * from users where id = ?",
                new Object[]{id},
                new RowMapper<User>() {
                    @Override
                    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                        User user = new User();
                        user.setId(rs.getString("id"));
                        user.setPw(rs.getString("password"));
                        return user;
                    }
                });
    }

    public List<User> getAll() {
        return this.jdbcTemplate.query("select * from users order by id",
                new RowMapper<User>() {
                    @Override
                    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                        User user = new User();
                        user.setId(rs.getString("id"));
                        user.setPw(rs.getString("password"));
                        return user;
                    }
                });
    }

    private RowMapper<User> userRowMapper =
            new RowMapper<User>() {
                @Override
                public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                    User user = new User();
                    user.setId(rs.getString("id"));
                    user.setPw(rs.getString("password"));
                    return user;
                }
            }; // 재사용 가능하도록

}
