package Learn;

import Test.BeanUtilsTest;

/**
 * 学习apache的beanUtils类
 *
 * 目的   用于封装javaBean的
 *
 * 问题   1. 什么是JavaBean
 *          答：标准的Java类(实体类)，需要遵守一些规范
 *              1. public的类
 *              2. 必须有空参构造器
 *              3. 成员变量都是private修饰
 *              4. 提供public的setter和getter方法
 *
 *         2. JavaBean的用于？
 *              数据库实体类。用于封装数据
 *
 *         3. BeanUtils干嘛的？
 *              用于操作JavaBean类
 *
 *         4. 一些概念
 *              成员变量：
 *                      举例：
 *                            private int id;
 *                            private String username;
 *                           private String password;
 *              属性：大多数时候即成员变量
 *                      指的是setter和getter截取后的产物。即通过setter和getter名字反推的成员变量名。
 *                      举例：getUsername --> Username --> username
 *                      !!大多数时候属性和成员变量名字是一样的。但是又特例
 *
 *          5. BeanUtils的一些方法
 *              setProperty
 *              getProperty
 *              populate
 */

public class BeanUtilsLearn {
    public static void main(String[] args) {
        //见测试类
    }
}
