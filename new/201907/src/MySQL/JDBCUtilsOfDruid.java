package MySQL;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.Closeable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtilsOfDruid {
    private static DataSource dataSource;
    static {
        try {
            final Properties properties = new Properties();
            properties.load(JDBCUtilsOfDruid.class.getClassLoader().getResourceAsStream(
                    "druid.properties"));

            dataSource = DruidDataSourceFactory.createDataSource(properties);
        }catch (Exception e){
            e.printStackTrace();
            System.exit(-1);
        }
    }

    public static Connection getConnection()throws SQLException {
        return dataSource.getConnection();
    }

    //归还连接
    public static void close(Connection connection){
        if(connection!=null){
            try{
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void close(Connection connection, Statement statement){
        if(statement!=null){
            try{
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        close(connection);
    }

    public static void close(Connection connection, Statement statement, ResultSet resultSet){
        if(resultSet!=null){
            try{
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        close(connection,statement);
    }

    public static DataSource getDataSource(){
        return dataSource;
    }

    public static void main(String[] args) throws Exception{
        final Connection connection = getConnection();
        close(connection);
    }
}
