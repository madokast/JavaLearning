package zrx.dao;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import zrx.domain.User;
import zrx.util.JDBCUtils;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<User> findAll() {
        //sql
        String sql = "select * from user";

        final List<User> userList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<User>(User.class));

        return userList;
    }
}
