package com.smart.JdbcTemplateTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component("jdbcTest")
public class Test {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void test(){
        String sql = "SELECT user_name FROM t_user";
        jdbcTemplate.query(sql, new RowCallbackHandler() {//回调
            public void processRow(ResultSet resultSet) throws SQLException {
                if(true){
                    final String user_name = resultSet.getString("user_name");
                    System.out.println(user_name);
                }
            }
        });
    }

    public void test2(){
        String sql = "SELECT user_name FROM t_user";
        final List<String> query = jdbcTemplate.query(sql, new RowMapper<String>() {
            public String mapRow(ResultSet resultSet, int i) throws SQLException {
                return null;
            }
        });
    }
}
