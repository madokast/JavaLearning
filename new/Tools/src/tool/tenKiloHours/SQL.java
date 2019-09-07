package tool.tenKiloHours;

import com.mysql.cj.jdbc.Driver;
import com.mysql.cj.jdbc.JdbcConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * 简单操作数据库，添加
 */

public class SQL {
    public static void main(String[] args) {
        String sql = "INSERT INTO entries(DATEDONE, NAME, LENGTHMINUTE, DESCRIBING) VALUES " +
                "('2019-09-06','Java',90,'Ajax')";


        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (Exception e){
            e.printStackTrace();
            System.exit(-1);
        }

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/ichiwan?serverTimezone=Asia/Shanghai","root","123456"
            );
            final PreparedStatement preparedStatement = connection.prepareStatement(sql);
            final int i = preparedStatement.executeUpdate();
            System.out.println("执行成功，改变行数 "+i);

            preparedStatement.close();

            connection.close();
        }catch (Exception e){
            e.printStackTrace();
            System.exit(-1);
        }


    }
}
