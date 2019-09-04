package ichiwan.dao;

import ichiwan.domain.Entry;
import ichiwan.domain.EntryForm;
import ichiwan.util.JDBCUtils;
import org.apache.catalina.User;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class EntryDaoImpl implements EntryDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Entry> findAll() {
        String sql = "select id,dateDone,name,lengthMinute,describing from entries WHERE deleteBool = 0 order by id asc ";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Entry>(Entry.class));
    }

//    @Override
//    public List<Entry> findPage(int start, int number) {
//        String sql = "select id,dateDone,name,lengthMinute,describing from entries WHERE deleteBool = 0 order by id asc LIMIT ? ,? ";
//        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<Entry>(Entry.class), start, number);
//    }

    @Override
    public void addEntry(EntryForm entryForm) {
        String sql = "INSERT INTO entries(dateDone, name, lengthMinute, describing) values(?,?,?,?) ;";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            jdbcTemplate.update(sql,
                    simpleDateFormat.parse(entryForm.getDateDone()),
                    entryForm.getName(),
                    Integer.valueOf(entryForm.getLengthMinute()),
                    entryForm.getDescribing());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteEntry(int id) {
//        String sql = "DELETE FROM entries WHERE id = ? ";
        //修改于 2019年9月4日
        String sql = "UPDATE entries SET deleteBool = 1 WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    public Entry queryEntryById(int id) {
        //    private int id;
        //    private Date dateDone;
        //    private String name;
        //    private int lengthMinute;
        //    private String describing;
        String sql = "SELECT id,dateDone,name,lengthMinute,describing FROM entries WHERE id= ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Entry>(Entry.class), id);
    }

    @Override
    public int totalEntry() {
        //        String sql = "SELECT COUNT(id) AS total FROM entries ;";
        //        final SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        //        rowSet.next();
        //        return rowSet.getInt("total");
        String sql = "SELECT COUNT(id) AS total FROM entries ";
        final SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        rowSet.next();
        return rowSet.getInt("total");
    }

    @Override
    public int totalEntryExcludingDeleted() {
        String sql = "SELECT COUNT(id) AS total FROM entries WHERE deleteBool=0";
        final SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        rowSet.next();
        return rowSet.getInt("total");
    }

    @Override
    public int lastId() {
        String sql = "SELECT MAX(id) AS last FROM entries WHERE deleteBool=0";
        final SqlRowSet sqlRowSet = jdbcTemplate.queryForRowSet(sql);
        if (sqlRowSet.next()) {
            return sqlRowSet.getInt("last");
        } else {
            return 0;
        }
    }
}
