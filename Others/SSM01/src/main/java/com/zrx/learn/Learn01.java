package com.zrx.learn;

import org.springframework.web.context.ContextLoaderListener;

/**
 * 2019年10月27日
 * 整合SSM
 *      一句话：利用 spring框架 整个 springMVC 和 MyBatis
 * 配置 + 注解 —— 那个简单那个来
 *
 * 每个部分都要能单独运行
 *
 * ------------------------------
 * 创建数据库
 *
 * ------------------------------
 * 首先单独搭建spring 和 springMVC
 * 此时有两个xml配置文件
 * 然后再整合
 *      当启动tomcat，不仅扫描springMVC。xml 也扫描applicationConfig.xml
 *      方法：利用监听器在servletContext中加载xml，并存在这个域中
 */

public class Learn01 {
//    ContextLoaderListener
}
