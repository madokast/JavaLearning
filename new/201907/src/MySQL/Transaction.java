package MySQL;

import MySQL.school.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * jdbc事务
 */

public class Transaction {
    public static void main(String[] args) {
        final Connection connection = JDBCUtils.getConnection();
        PreparedStatement preparedStatement01 = null;
        PreparedStatement preparedStatement02 = null;

        String sql01 = "UPDATE account SET balance = balance - ? where name = ? ";
        String sql02 = "UPDATE account SET balance = balance + ? where name = ? ";

        try {
            preparedStatement01 = connection.prepareStatement(sql01);
            preparedStatement02 = connection.prepareStatement(sql02);

            int num = 500;

            preparedStatement01.setInt(1,num);
            preparedStatement01.setString(2,"miao");
            preparedStatement02.setInt(1,num);
            preparedStatement02.setString(2,"zrx");

            connection.setAutoCommit(false);
            preparedStatement01.executeUpdate();
            preparedStatement02.executeUpdate();
            connection.commit();
            System.out.println("转账成功");

        } catch (Exception e) {
            System.out.println("出错");
            e.printStackTrace();
            try {
                System.out.println("回滚");
                if(connection!=null){
                    connection.rollback();
                }
            }catch (SQLException ee){ee.printStackTrace();}
        }finally {
            //释放
            JDBCUtils.close(connection,preparedStatement01);
            JDBCUtils.close(null,preparedStatement02);
        }

    }
}
