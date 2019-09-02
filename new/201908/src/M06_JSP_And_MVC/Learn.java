package M06_JSP_And_MVC;

/**
 * 2019年8月8日
 * 754
 *
 * JSP
 *      指令——配置JSP页面，导入资源文件
 *          格式： <%@ 指令名称 属性名=属性值 属性名1=属性值1%>
 *          分类： 1. page    配置JSP页面
 *                      举例：<%@ page contentType="text/html;charset=UTF-8" language="java" %>
 *                      contentType  等同于 setContentType(mime和字符集 当前页面编码)
 *                      language 编程语言
 *                      buffer 缓冲区 默认8GB
 *                      import 导入Java包  <%@ page import="java.util.List" %>
 *                      errorPage 错误页面，当当前页面发生错误时，自动跳转错误
 *                      isErrorPage="" 其实都是服务器挂了  可以使用内置对象exception对象。默认值false
 *                 2. include 导入页面资源文件
 *                      包含页面。
 *                      <%@ include file="log.jsp"%>
 *                 3. taglib  导入资源
 *                      导入标签库
 *
 *      注释
 *          html 注释       <!--注释-->
 *          JSP特有的注释   <%--注释--%>
 *
 *      内置对象
 *            变量名         真实类型
 *          response         HttpResponse
 *          request          HttpRequest
 *          out              JSPWriter
 *          pageContext      PageContext
 *          session          HttpSession
 *          application      ServletContext——最大对象，服务器本身
 *          page             Object = this 就是servlet对象本身
 *          config           ServletConfig  配置对象
 *          exception        Throwable      -- 只有isErrorPage了的page才有这个
 *
 *
 *          域对象4个
 *              pageContext —— 当前页面共享数据。获取其他8和内置对象
 *              request     —— 一次请求访问多个资源。请求跳转 派发
 *              session     —— 一次会话的多个请求
 *              application —— 唯一。最大
 *
 * MVC开发模式
 *      历史问题：
 *          早期只有servlet没有jsp，只能使用response输出html内容
 *          然后sum开发了jsp，在jsp里面写了Java代码 和 html标签
 *          结果Java JavaScript html/css 全部混在一起了 —— 一坨屎 没办法分工，别人看不懂，难以维护
 *          MVC模式 ，规定什么代码只能写在什么地方
 *      MVC
 *          M model 模型    业务操作   使用JavaBean完成
 *          V view 试图     展示数据   使用JSP
 *          C controller 控制器  获取客户输入 分发  不做具体事情   使用servlet充当
 *               调用模型M 进行业务操作
 *      程序流程
 *          1. 浏览器请求资源
 *          2. 控制器C收到请求，调用模型M进行业务操作
 *          3. 模型M把数据返回控制器C
 *          4. 控制器C把数据给视图V展示
 *
 *      优点：低耦合 方便维护 利于分工协作 重用性高
 *
 *      缺点：没有明确的定义 使得项目架构变得复杂 对开发人员要求高
 *
 * JSP里面尽可能不要写Java代码，只写少量的Java代码
 * 使用EL表达式和JSTL标签
 *
 * EL表达式
 *      概念：expression language 表达式语言
 *      目的：替换和简化JSP中Java代码编写
 *      语法：${表达式}
 *          JSP默认支持EL表达式。如果想要不解析
 *      用法：
 *          运算
 *              运算符：
 *                  算数运算符 + - * / div mod
 *                  比较运算符
 *                  逻辑运算符
 *                  空运算符   empty
 *                      判断字符串 数组 集合 是否为null 以及 长度是否为零
 *                      ${empty list}
 *          获取值
 *              el表达式。只能从域对象中获取值
 *              语法：
 *                  ${域名称.key}
 *                      域名称
 *                          pageContext     pageScope
 *                          request         requestScope
 *                          session         sessionScope
 *                          application     applicationScope
 *                      如 request.name
 *               若为空：不返回任何东西
 *               语法二：
 *                  ${key} 从最小的scope开始查找
 *
 *           获取对象
 *              默认输出这个对象的toString()
 *              ${key.属性名}
 *
 *           隐式对象  直接可以用的对象
 *              四个Scope
 *              pageContext 可以用于获取其他8个对象
 *              pageContext.request.contextPath 动态获取虚拟目录
 *
 * JSTL标签
 *      概念 Java server pages tag library  JSP标准标签库
 *      由apache提供的开源的免费JSP标签
 *      作用 用于简化和替换jsp上的Java代码 <标签>
 *      使用步骤：
 *          导入jar包
 *          引入变迁库 利用tablib指令 <% taglib %>
 *          使用标签
 *
 *      常用的jsp标签——jsp中的Java代码大部分用途——查询数据库然后展示list集合中的数据
 *          if
 *          choose——相当于switch语句
 *          foreach
 *
 * 三层架构
 *      软件设计架构 和 mvc类似
 *      把一个软件分为3层
 *          界面/表示层web层：用户看得到，通过界面上的组件和服务器交互
 *          业务逻辑层service层：即完成各种功能
 *              组合基本的数据访问方法，合成一个完整的业务
 *          数据访问层dao层：操作数据库。
 *              封装最简单的数据库访问方法
 *
 *      分为不同包
 *          项目名.web
 *          。。。.service
 *          。。。.dao
 *
 *      框架
 *          web层——是springMVC
 *          dao层——是MyBatis
 *          service层——是spring框架
 *
 * 案例：
 *      用户信息列表展示
 *      需求：用户信息的增删改查操作
 *      设计：
 *          1. 技术选型。用什么技术？
 *              servlet+JSP+MySQL+JDBCTemplate+Duird+BeanUtils+tomcat
 *          2. 数据库设计
 *              create database day17; -- 创建数据库
 *              use day17; -- 使用数据库
 *              create table user{ --创建表
 *                  id int primary key auto_increment,
 *                  name varchar(20) not null,
 *                  gender varchar(5)
 *              }
 *          3. 环境搭建
 *              TODO：创建新项目，回顾整个过程
 *              创建数据库环境
 *              创建项目
 *              导入jar包
 *          4. 编码
 *          5. 测试
 *          6. 部署
 *          7. 运维
 *
 */

public class Learn {
}
