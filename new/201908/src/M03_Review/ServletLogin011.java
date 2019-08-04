package M03_Review;

import Test.dao.UserDaoTest;
import dao.UserDao;
import domain.User;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * 设置编码
 * 获取 username 和 password
 * 操作数据库，放到单独的类中实现
 * 将username 和password 封装为“虚假的”user对象
 *
 *          UserDao——操作数据库
 *              login(User 虚假的 user)
 *              返回真正的user
 *
 * 调用UserDao.login(user)
 *  检查返回值是否为null
 *      请求跳转
 *      null-->   FailServlet
 *      非null--> 封装user信息到req 然后跳转到 SuccessServlet
 *
 *
 * 开始工作
 *      1. 导入jar包
 *      2. 创建user实体类
 *      3. 利用准备好的JDBCUtils类（此类用于得到数据库连接池和连接），制作IUserDao类，
 *          类中用spring的JDBCTemplate实现简单的查询-生成User对象的操作。测试~
 *      4. 写servlet类，完成登陆的各种逻辑
 */

@WebServlet("/loginServlet011")
public class ServletLogin011 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("/loginServlet011");

        //设置编码
        req.setCharacterEncoding("UTF-8");
        //获取请求参数
        //下面代码太繁琐，使用beanUtils
//        final String username = req.getParameter("username");
//        final String password = req.getParameter("password");
//        final User loginUser = new User();
//        loginUser.setUsername(username);
//        loginUser.setPassword(password);
        final Map<String, String[]> parameterMap = req.getParameterMap();

        //利用上面的map来创建user对象
        final User loginUser = new User();
        try {
            BeanUtils.populate(loginUser,parameterMap);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        //查
        final UserDao userDao = new UserDao();
        final User user = userDao.login(loginUser);

        if(user==null){
            System.out.println("ServletLogin011登陆失败");
            //用户名/密码错误
            //跳转到失败servlet
            final RequestDispatcher requestDispatcher = req.getRequestDispatcher("/failServlet012");
            requestDispatcher.forward(req,resp);
        }
        else{
            System.out.println("ServletLogin011登陆成功");
            //登陆成功。存储数据
            //跳转到成功servlet
            req.setAttribute("user",user);
            final RequestDispatcher requestDispatcher = req.getRequestDispatcher("/successServlet013");
            requestDispatcher.forward(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}
