package com.smart.dao;

import com.smart.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository //通过spring注解定义一个DAO
public class UserDao {
    private JdbcTemplate jdbcTemplate;

    private final static String MATCH_COUNT_SQL =
            "SELECT COUNT(*) FROM t_user WHERE user_name = ? AND password = ?";
    private final static String QUERY_BY_USERNAME =
            "SELECT user_id,credits FROM t_user WHERE user_name = ? ";
    private final static String UPDATE_LOGIN_INFO_SQL =
            "UPDATE t_user SET  last_visit = ? ,last_ip = ? , credits = ? WHERE user_id = ? ";

    @Autowired //自动注入 JdbcTemplate 的 Bean
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int getMatchCount(String userName,String password){
        //2019年9月11日 queryForInt 方法已过时，使用下面这个 传入 需要的类
        return jdbcTemplate.queryForObject(MATCH_COUNT_SQL,new Object[]{userName,password},Integer.class);
    }


    public User findUserByUserName(final String userName){
        final User user = new User();
        jdbcTemplate.query(QUERY_BY_USERNAME, new Object[]{userName}, new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                user.setUserId(resultSet.getInt("user_id"));
                user.setUserName(userName);
                user.setCredits(resultSet.getInt("credits"));
            }
        });

        return user;
    }

    public void updateLoginInfo(User user){
        // UPDATE t_user SET  last_visit = ? ,last_ip = ? , credits = ? WHERE user_id = ?


        jdbcTemplate.update(UPDATE_LOGIN_INFO_SQL,
                user.getLastVisit(), user.getLastIp(), user.getCredits(), user.getUserId());
    }


}
