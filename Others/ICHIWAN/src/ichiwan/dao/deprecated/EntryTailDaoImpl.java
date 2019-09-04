package ichiwan.dao.deprecated;

import ichiwan.domain.EntryTail;
import ichiwan.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.List;

public class EntryTailDaoImpl implements EntryTailDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    @Deprecated
    public List<EntryTail> findAll() {
        //private int relativeDate;
        //    private int totalMinute;
        //    private double averageMinute;
        String sql = "SELECT id,dateDone,name,lengthMinute,describing,relativeDate,totalMinute,averageMinute from entries";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<EntryTail>(EntryTail.class));
    }

    @Override
    @Deprecated
    public List<EntryTail> findLimit10(int n) {
        String sql = "SELECT id,dateDone,name,lengthMinute,describing,relativeDate,totalMinute,averageMinute from entries LIMIT ?, 10";
        int page = (n - 1) * 10;
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<EntryTail>(EntryTail.class), page);
    }

    @Override
    @Deprecated
    public int entryNumber() {
        String sql = "SELECT COUNT(id) AS total FROM entries ;";
        final SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sql);
        rowSet.next();
        return rowSet.getInt("total");
    }

    @Override
    @Deprecated
    public List<EntryTail> findLimite(int start, int limit) {
        String sql = "SELECT id,dateDone,name,lengthMinute,describing,relativeDate,totalMinute,averageMinute from entries LIMIT ?, ?";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<EntryTail>(EntryTail.class), start, limit);
    }
}
