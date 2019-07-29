package MySQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * 预编译SQL
 * 防止sql注入
 *
 * 预编译sql
 * 使用 ？ 所谓占位符
 */

public class PreparedStatementTest {
//    PreparedStatement preparedStatement;

    public static void main(String[] args) {
        Connection connection=null;
        Statement statement=null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet=null;
        try {
            connection = JDBCUtils.getConnection();
            final String sql = "select * from dept where Did = ?";

            preparedStatement=connection.prepareStatement(sql);

            preparedStatement.setInt(1,1);

            resultSet= preparedStatement.executeQuery();
            while(resultSet.next()){
                System.out.println("resultSet.getInt(\"Did\") = " + resultSet.getInt("Did"));
                System.out.println("resultSet.getString(\"Dname\") = " + resultSet.getString("Dname"));
            }
        }catch (Exception e){
            JDBCUtils.close(connection,preparedStatement,resultSet);
        }
    }
}
