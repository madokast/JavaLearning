package MySQL.school;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTest {
    public static void main(String[] args) {
        ResultSet resultSet;
        try(
                final Connection connection = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/school?serverTimezone=Asia/Shanghai","root","123456");
                final Statement statement = connection.createStatement();
        ){
            resultSet = statement.executeQuery("SELECT * FROM student");
            while(resultSet.next()){
                System.out.println(new Student(
                        resultSet.getString("Sname"),
                        resultSet.getString("Ssex"),
                        resultSet.getInt("Sage"),
                        resultSet.getInt("Sdept")
                ));
            }
            resultSet.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
