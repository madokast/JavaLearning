package MySQL.school;

import com.sun.source.tree.CompilationUnitTree;

import java.io.File;
import java.sql.*;
import java.time.Year;
import java.util.Properties;

public class JDBCUtils {
    //no instance
    private JDBCUtils(){}
    private static String url;
    private static String user;
    private static String password;
    private static String driver;

    static {
        try {
            //读取配置文件 properties
            Properties properties = new Properties();
            properties.load(JDBCUtils.class.getClassLoader().getResourceAsStream("jdbc.properties"));

            url = properties.getProperty("url");
            user = properties.getProperty("user");
            password = properties.getProperty("password");
            driver = properties.getProperty("driver");

            //加载驱动文件
            Class.forName(driver);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * 获取连接
     * 不想传递参数 海德保证工具类的通用性
     * 定义配置文件
     * @param user 用户名
     * @param pws 密码
     * @return 连接
     */
    public static Connection getConnection(){
        try{
            return DriverManager.getConnection(url,user,password);
        }catch (Exception e){
            e.printStackTrace();
            System.exit(-1);
            return null;
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

        if(connection!=null){
            try{
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


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

    public static void main(String[] args) {
        close(null,null,null);
    }

}
