package day190909.dao.impl;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import day190909.dao.ProvinceDao;
import day190909.doamin.Province;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import javax.swing.tree.RowMapper;
import java.util.List;
import java.util.Properties;

public class ProvinceDaoImpl implements ProvinceDao {
    private static JdbcTemplate jdbcTemplate;
    static {
        try {
            Properties properties = new Properties();
            properties.load(ProvinceDaoImpl.class.getClassLoader().getResourceAsStream(
                    "druid.properties"));

            System.out.println("properties = " + properties);

            final DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
            jdbcTemplate = new JdbcTemplate(dataSource);
        }catch ( Exception e){e.printStackTrace();}
    }


    @Override
    public List<Province> findAll() {

        String sql = "SELECT * FROM day190909.province";

        System.out.println("jdbcTemplate = " + jdbcTemplate);


        final List<Province> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<Province>(Province.class));

        return list;
    }
}
