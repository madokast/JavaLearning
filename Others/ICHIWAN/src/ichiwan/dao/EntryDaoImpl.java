package ichiwan.dao;

import ichiwan.domain.Entry;
import ichiwan.domain.EntryForm;
import ichiwan.util.JDBCUtils;
import org.apache.catalina.User;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class EntryDaoImpl implements EntryDao{
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Entry> findAll() {
        String sql = "select id,dateDone,name,lengthMinute,describing from entries order by id asc;";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<Entry>(Entry.class));
    }

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
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @Override
    public void deleteEntry(int id) {
        String sql = "DELETE FROM entries WHERE id = ? ";
        jdbcTemplate.update(sql,id);
    }

    @Override
    public Entry queryEntryById(int id) {
        //    private int id;
        //    private Date dateDone;
        //    private String name;
        //    private int lengthMinute;
        //    private String describing;
        String sql = "SELECT id,dateDone,name,lengthMinute,describing FROM entries WHERE id= ?";
        return jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<Entry>(Entry.class),id);
    }
}
