package com.smart.dao;

import com.smart.domain.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class InfoDao {
    private JdbcTemplate jdbcTemplate;

    private final String INFO_SQL = "SELECT info FROM info";

    @Autowired
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Info getInfo(){
        final Info info = new Info();
        jdbcTemplate.query(INFO_SQL, new RowCallbackHandler() {
            public void processRow(ResultSet resultSet) throws SQLException {
                info.setInfo(resultSet.getString("info"));
            }
        });

        return info;
    }


}
