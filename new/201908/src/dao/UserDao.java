package dao;

import domain.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.sql.Connection;

/**
 * 提供login方法
 * 操作数据库得类，对应实体类User
 */

public class UserDao {
    /**
     * 现在还不懂 但我一定要成功
     * Spring对数据库的操作在jdbc上面做了深层次的封装，
     * 使用spring的注入功能，可以把DataSource注册到JdbcTemplate之中。
     */
    private JdbcTemplate template  = new JdbcTemplate(JDBCUtils.getDataSource());


    /**
     * 登陆 由相关的servlet调用
     * @param loginUser 外部创建的，只有username 和 password 的user对象
     * @return 如果该对象在user表中存在，则返回完整的user对象，否则返回null
     */
    public User login(User loginUser){
        try {
            //sql statement
            String sql = "select * from user where username = ? and password = ?";

            //query of jdbc template
            final User user = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class),
                    loginUser.getUsername(), loginUser.getPassword());

            return user;
        }catch (Exception e){
            e.printStackTrace();//以后会记录日志~~~
            return null;
        }
    }
}
