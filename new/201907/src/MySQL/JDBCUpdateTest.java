package MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUpdateTest {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        try {
            //register
            Class.forName("com.mysql.cj.jdbc.Driver");
            //sql
            String sql = "INSERT INTO account values(null,'wangwu',2100)";
            //conn
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/student?serverTimezone=Asia/Shanghai",
                    "zrx", "123456");
            //state
            statement = connection.createStatement();
            //execute
            int count = statement.executeUpdate(sql);
            System.out.println("count = " + count);
        } catch (ClassNotFoundException e) {
            e.getException();
        } catch (SQLException e) {
            e.getErrorCode();
        }finally {
            if(statement!=null){
                try {
                    statement.close();
                }catch (SQLException e){
                    e.getErrorCode();
                }
            }

            if(connection!=null){
                try {
                    connection.close();
                }catch (SQLException e){
                    e.getErrorCode();
                }
            }
        }
    }
}
