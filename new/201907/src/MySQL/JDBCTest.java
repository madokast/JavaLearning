package MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

/**
 * 1. 导入java包
 * 2. 注册驱动
 * 3. 获取数据库连接对象 Connection
 * 4. 定义SQL语句-发送SQL到数据库
 * 5  获取执行sqsl语句的对象 statement
 * 6. 执行sql，接受返回结果
 * 7. 处理结果
 * 8. 释放资源
 *
 * 下面是快速入门
 */

public class JDBCTest {
    public static void main(String[] args) throws Exception{
        //导入驱动。不执行
        Class.forName("com.mysql.cj.jdbc.Driver");

        //获取连接对象
        final Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/student?serverTimezone=Asia/Shanghai", "root", "123456");

        //定义sql语句
        String sql = "UPDATE account SET balance = 1000";//sql语句不要加分号

        //得到语句,并执行
        final Statement statement = connection.createStatement();
        final int count = statement.executeUpdate(sql);

        System.out.println("count = " + count);

        //释放资源
        statement.close();
        connection.close();
    }
}

/**
 * DriverManager
 *      注册驱动 registerDriver(java.sql.Driver driver)
 *             因为com.mysql.cj.jdbc.Driver类中有静态代码块
 *      获取数据库连接
 *
 * Connection
 *      Statement createStatement()
 *      PreparedStatementTest prepareStatement(sql)
 *      void setAutoCommit(boolean autoCommit) 开启事务，参数false则开启事务
 *      void commit() 提交事务
 *      void rollback() throws 回滚事务
 */