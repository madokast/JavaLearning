package com.smart.dao;

import com.smart.domain.LoginLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class LoginLogDao {
    private JdbcTemplate jdbcTemplate;

    private static final String INSERT_LOGIN_LOG_SQL =
            "INSERT INTO t_login_log(USER_ID, IP, LOGIN_DATETIME) VALUES(?, ?, ?) ";

    @Autowired //自动注入 JdbcTemplate 的 Bean
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void insertLoginLog(LoginLog loginLog) {
        //    login_log_id INT PRIMARY KEY AUTO_INCREMENT,
        //    user_id INT,
        //    ip VARCHAR(23),
        //    login_datetime DATETIME

        jdbcTemplate.update(INSERT_LOGIN_LOG_SQL,loginLog.getUserId(),loginLog.getIp(),loginLog.getLoginDate());
    }

}
