package MySQL.连接池;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import javax.sql.PooledConnection;
import java.sql.Connection;
import java.util.Properties;

/**
 * 德鲁伊 数据库连接池
 * 工厂类获取数据库连接池对象
 *
 * 配置文件 ：
 *      druid.properties
 */

public class DruidTest {
    public static void main(String[] args) throws Exception{
        Properties properties = new Properties();
        properties.load(DruidTest.class.getClassLoader().getResourceAsStream("druid.properties"));

        final DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);

        final Connection connection = dataSource.getConnection();

        System.out.println("connection = " + connection);
    }
}
