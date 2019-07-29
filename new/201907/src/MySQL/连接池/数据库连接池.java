package MySQL.连接池;

import javax.sql.DataSource;

/**
 * 原本是每次操作都申请连接后释放
 * 导致开销太大
 *
 * DataSource dataSource;
 * 数据源工厂
 * 三种实现 生成 连接对象
 *      由数据库厂商实现
 *
 * C3P0 数据库连接池技术 老旧
 *      第一步：导入jar包
 * Druid 数据库连接池技术，由阿里巴巴提供
 *
 *      获取连接： getConnection
 *      归还连接：重写了close方法
 *
 * Spring JDBC 简化 程序
 */

public class 数据库连接池 {
    public static void main(String[] args) {

    }
}
