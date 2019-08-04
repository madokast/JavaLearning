package M02_HTTP;

import Tools.MyDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/demo010")
public class ServletReview10 extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("执行demo010");

        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().write("跳转成功<br />");

        final String username = req.getParameter("username");
        final String password = req.getParameter("password");



        resp.getWriter().write("你输入的用户名和密码分别是："+username+"  "+password+"<br >");

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try{
            System.out.println("1");
            connection = MyDataSource.getConnection();
            System.out.println("2");
            preparedStatement = connection.prepareStatement("select * from account where name = ? and balance = ?");
            System.out.println("3");
            preparedStatement.setString(1,username);
            preparedStatement.setDouble(2,Double.valueOf(password));
            System.out.println("4");
            resultSet = preparedStatement.executeQuery();
            System.out.println("5");
            if(resultSet.next()){
                resp.getWriter().write("登陆成功");
            }else{
                resp.getWriter().write("用户名或密码错误");
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(resultSet!=null){
                try {
                    resultSet.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            if(preparedStatement!=null){
                try {
                    preparedStatement.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }

            if(connection!=null){
                try {
                    connection.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }


        System.out.println("我是demo010");
    }
}
