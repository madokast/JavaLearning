package Test.util;

import org.junit.Test;
import util.JDBCUtils;

import java.sql.Connection;

public class JDBCUtilsTest {
    @Test
    public void getDataSourceTest(){
       try {
           final Connection connection = JDBCUtils.getConnection();
           System.out.println("connection = " + connection);
           connection.close();
       }catch (Exception e){e.printStackTrace();}
    }
}
