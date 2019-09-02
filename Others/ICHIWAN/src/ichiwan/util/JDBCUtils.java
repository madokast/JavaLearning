package ichiwan.util;

//jdbc的工具类
//使用druid连接池

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Objects;
import java.util.Properties;

public class JDBCUtils {
    private static DataSource ds;

    static {
        try {
            Properties properties = new Properties();
            final InputStream resourceAsStream = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            Objects.requireNonNull(resourceAsStream);
            properties.load(resourceAsStream);

            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static DataSource getDataSource() {
        return ds;
    }

    public static Connection getConnection() throws Exception {
        return ds.getConnection();
    }
}
