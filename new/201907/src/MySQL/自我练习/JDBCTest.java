package MySQL.自我练习;

import com.mysql.cj.xdevapi.SqlDataResult;

import java.lang.invoke.VarHandle;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql:///student?serverTimezone=Asia/Shanghai", "zrx", "123456");
            statement = connection.createStatement();
//            final int i = statement.executeUpdate("INSERT INTO account values(null,'a',120)");
            final int i = statement.executeUpdate("delete from account where name='a'");
            System.out.println("i = " + i);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if(statement!=null){
                try {
                    statement.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }

            if(connection!=null){
                try {
                    connection.close();
                }catch (SQLException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
