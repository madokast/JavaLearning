package TomcatAndServlet;

/**
 * web知识回顾
 *  软件架构 C/S B/S
 *  资源分类：静态 动态
 *  网络通信三要素：IP port 协议
 *
 * web服务器软件 tomcat
 *  MySQL服务器 web服务器 部署wen项目让用户通过浏览器访问
 *  webLogic —— 大型javaEE服务器，支持所有的JavaEE规范，收费
 *      JavaEE是Java语言在企业及开发中使用的即使规范的总和，共13项
 *      webSphere——收费
 *      JBoss——收费
 *      tomcat——apache基金组织，中小型的JavaEE服务器，仅仅支持少量的规范。开源的，免费的
 *
 * tomcat：
 *      下载
 *      安装——解压
 *      卸载——删除
 *      启动
 *      关闭——正常关闭shutdown.bat 强制关闭(点击X)
 *      配置——主要怎么配属项目
 *
 * tomcat目录
 *      bin         二进制（start.bat）
 *      conf        配置
 *      lib         依赖 jar 包
 *      logs        日志
 *      temp        临时文件
 *      webapps     web项目
 *      work        运行时数据
 *
 * 启动问题
 *      1. 黑窗口一闪而过——没有配置JAVA_HOME
 *      2. 端口被占用：
 *          找到占用端口的程序
 *
 * 配置项目
 *      1. 直接放到webapps目录下
 *      2. 配置文件
 *
 * 项目——静态项目 和 动态项目
 *      目录结构有区别：
 *          动态项目：
 *              —— root
 *                  --WEB-INF
 *                      --web.xml
 *                      --classes
 *                      --lib
 * 集成tomcat到ideaJ
 *
 * web服务器软件 servlet
 */

public class 终于开始了 {
}
