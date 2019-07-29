package MySQL;

import MySQL.school.Student;
import com.sun.jdi.PathSearchingVirtualMachine;

import javax.print.DocFlavor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class 德鲁伊工具类练习 {
    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = JDBCUtilsOfDruid.getConnection();
            String sql = "select * from student where Sage = ?";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1,42);

            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                //(String name, String sex, int age, int dept)
                Student student = new Student(
                        resultSet.getString("Sname"),
                        resultSet.getString("Ssex"),
                        resultSet.getInt("Sage"),
                        resultSet.getInt("Sdept")
                );

                System.out.println("student = " + student);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCUtilsOfDruid.close(connection,preparedStatement,resultSet);
        }
    }
}
