package Test;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class DatabaseTest {
    public static void main(String[] args)throws Exception {
        final Properties properties = new Properties();
        properties.load(DatabaseTest.class.
                getClassLoader().getResourceAsStream("druid.properties"));
        final DataSource dataSource = DruidDataSourceFactory.createDataSource(properties);
        final Connection connection = dataSource.getConnection();

        final ResultSet resultSet = connection.prepareStatement("select * from account").executeQuery();

        while(resultSet.next()){
            System.out.println("resultSet.getInt(\"Aid\") = " + resultSet.getInt("Aid"));
            System.out.println("resultSet.getString(\"name\") = " + resultSet.getString("name"));

        }

        connection.close();

    }
}
