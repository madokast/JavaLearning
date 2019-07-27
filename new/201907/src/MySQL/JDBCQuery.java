package MySQL;

import com.sun.source.tree.CompilationUnitTree;

import java.sql.*;
import java.util.SplittableRandom;

/**
 * ResultSet 结果集对象
 */

public class JDBCQuery {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/student?serverTimezone=Asia/Shanghai", "zrx", "123456");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT id,NAME AS N,balance FROM account");

            //下移 判断是否有数据
            while(resultSet.next()){
                final int id = resultSet.getInt("id");
                final String name = resultSet.getString("N");
                final double balance = resultSet.getDouble("balance");
                System.out.println(id+"--"+name+"--"+balance);
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
