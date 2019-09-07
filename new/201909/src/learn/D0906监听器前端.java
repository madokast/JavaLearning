package learn;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Listener
 * 概念：web三大组建之一。用的比较少。
 *
 * 事件监听机制
 *      事件：一件事情，如点击按钮
 *      事件源：事件发生的地方
 *      监听器：一个对象
 *      注册监听：将事件、事件源和监听器绑定在一起，当事件源上事件发生时，执行监听器代码
 *
 * ServletContextListener
 *      见下
 *
 * 步骤：
 *      定义一个类，实现ServletContextListener
 *      实现方法
 *      配置
 *          web.xml
 *          注解
 *
 * JQuery学习--JS框架
 *      概念--JS框架
 *          简化JS开发
 *          本质就是js文件,封装了js原生代码
 *      快速入门
 *          下载文件
 *          项目中导入
 *          使用
 *              $()
 *              html()
 *              css(k,v)
 *      JQuery对象和JS对象的区别和转换
 *          $()-->jquery对象
 *          JS对象和JQ对象不通用
 *      选择器
 *          帅选元素
 *
 *      事件绑定 入口函数 样式
 *
 *      DOM操作
 *          内容操作
 *              html() //获取/设置 标签体内容
 *              text() //纯文本
 *              val() //获取设置value属性值
 *          属性惭怍
 *              通用属性操作
 *                  attr and remove  ---- 自定义属性
 *                  prop and remove  ---- 固有属性
 *              class属性操纵
 *                  addClass
 *                  removeClass
 *                  toggleClass 切换
 *          增删改查
 *              append() 末尾添加
 *              prepend() 首部添加
 *              a.appendTo(b)  b添加a 放行相反
 *              prependTo()
 *
 *      案例
 *
 * 动画
 * 遍历
 * 事件绑定
 * 案例
 * 插件
 *
 *
 * Ajax
 *      概念:asynchronous JavaScript and xml 异步的JS和XML
 *          客户端和服务器相互交互的基础上
 *              同步:客户端必须等待服务器端的响应,等待期间不能做其他事. 必须加载整个页面
 *              异步:不用等待,等待时可以干其他的操作 变化部分页面
 *      实现方法:
 *          二种方式:原生JS/ JQ方式
 *              了解即可
 *          JQ方式:
 *              $.ajax
 *              $.get
 *              $.post
 *
 * JSON
 */

public class D0906监听器前端 {
    //目的：监听ServletContext对象的创建和销毁
    ServletContextListener servletContextListener = new ServletContextListener() {
        @Override
        //初始化
        //ServletContext 创建后调用该方法
        public void contextInitialized(ServletContextEvent servletContextEvent) {

        }

        @Override
        //销毁
        //ServletContext 销毁前会调用该方法
        public void contextDestroyed(ServletContextEvent servletContextEvent) {

        }
    };
}
