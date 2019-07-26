package MySQL;

/**
 * 数据库学习~~
 * MySQL学习
 *
 * 数据库的基本知识 DB
 * 常见数据库软件
 * Oracle
 * MySQL
 * MSQL
 * DB2
 * SQLite
 *
 *
 * MySQL 内容
 * MySQL服务——server——没有界面的应用程序
 * 登陆 和 退出
 *
 * 目录结构
 * 安装目录
 * 数据目录
 *
 * SQL——结构化查询语言
 *      方言
 * 语法：SELECT * FROM tb
 *
 * DDL 操作数据库和数据库中的表
 * CREATE RETRIEVE UPDATE DELETE
 *
 * SHOW DATABASES
 *
 * 数据库备份和还原
 * 命令行 / 图形化
 *
 * 多表查询
 * 事务
 * DCL
 *
 * 内链接查询
 *
 * 事务基本介绍
 *      事务定义
 * 四大特征
 *  原子性
 *  隔离性 多个十五之间相互独立 但是会有相互影响
 *  一致性 事务操作前后数据总量不变
 *  永久性
 *
 * 事务的隔离级别
 *  多个事务操作同一批数据，会引发问题。有不同的的隔离级别
 *  存在问题：
 *      脏读 一个事物，读取到另一个事务中没有提交的事物
 *      不可重复读 在同一个事物中，两次读取到的数据不一样。又称为虚读
 *      幻读 一个事物增删改中所有记录，另一个事务中添加了一条数据，则第一个事务查询不到袭击的修改
 *  隔离级别
 *      read uncommitted 读未提交 —— 脏读 不可重复读 幻读
 *      read committed 读已提交 —— 不可重复读 幻读
 *      repeatable read 可重复读 —— 幻读
 *      serializable 串行化 —— 解决所有问题
 *  隔离级别越高，安全性越高，但是效率低
 *
 *  MySQL 默认的级别 read committed 读已提交
 *  Oracle 默认级别 repeatable read 可重复读
 *
 * DCL
 *
 * JDBC 学习 532
 *  java data base connectivity
 *  本质：数据库产品有很多种
 *  操作所有关系型数据库的规则（一套接口）
 *
 *  多个SQL厂商提供JDBC的实现类（数据库驱动）
 *
 *  快速入门门
 *
 */


public class Lesson {
}
