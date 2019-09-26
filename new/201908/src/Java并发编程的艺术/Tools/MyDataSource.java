package Java并发编程的艺术.Tools;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;
import java.util.Properties;

public class MyDataSource {
    private static Properties properties = null;
    private static DataSource dataSource = null;

    static {
        try {
            System.out.println("MyDataSource-1");
            properties = new Properties();

            System.out.println("MyDataSource-2");
            final InputStream resourceAsStream = MyDataSource.class.
                    getClassLoader().getResourceAsStream("druid.properties");
            Objects.requireNonNull(resourceAsStream);
            System.out.println("MyDataSource-3");
            properties.load(resourceAsStream);
            System.out.println("MyDataSource-4");
            dataSource = DruidDataSourceFactory.createDataSource(MyDataSource.properties);
            System.out.println("MyDataSource-5");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws Exception {
        System.out.println("getConnection");
        final Connection connection = dataSource.getConnection();
        System.out.println("connection = " + connection);
        return dataSource.getConnection();
    }

    public static void close(PreparedStatement statement, Connection connection) throws Exception {
        if (statement != null)
            statement.close();
        if (connection != null)
            connection.close();
    }

    public static void close(ResultSet resultSet,PreparedStatement statement, Connection connection)throws Exception{
        if(resultSet!=null)
            resultSet.close();

        close(statement,connection);
    }

    public static void main(String[] args) throws Exception{
        final Connection connection = getConnection();
        System.out.println("connection = " + connection);
        connection.close();
    }
}
