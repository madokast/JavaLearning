package M05_Cookie_Session_And_JSP;

import javax.servlet.http.HttpSession;

/**
 * 会话技术 和 JSP
 *
 * 会话技术
 *   会话：谈话
 *      我：你吃了吗 ---会话开始
 *      张三：我吃了
 *      我：你吃了啥
 *      张三：我吃了面条
 *      我：吃了几碗
 *      张三：吃了三碗
 *      我：吃饱了吗？
 *      张三：你好烦啊。---会话结束
 *
 *      多次的 问与答
 *      以上多次问答(多次请求响应)，始终都在一次会话之内
 *          请求响应仿佛有状态
 *
 *      一次会话中，包含多次请求和响应。
 *          什么是一次会话。会话开始：浏览器第一次给服务器请求
 *                          会话结束：双方有一方断开(关闭浏览器，或关闭服务器)
 *          会话的意义：多次请求响应间共享数据！！
 *          共享数据的作用域：一次会话
 *
 *      利用会话技术，实现有状态通信
 *          举例：淘宝的购物车，就是会话技术实现的
 *
 *   客户端会话技术 cookie
 *      把数据存在客户端
 *
 *      概念：客户端会话技术
 *      第一次响应时，服务器把一些数据存到浏览器中
 *      之后的请求响应，双方都会把这个数据传给对方
 *
 *      使用方法：
 *          创建cookie对象，绑定数据
 *              new Coolie(name,value)
 *          发送cookie到浏览器
 *              response.addCookie(cookie)
 *          之后的servlet 获取cookie 拿到数据
 *              request.getCookies() 返回Cookie[]
 *
 *      使用细节
 *          一次可不可以发送多个cookie？
 *              可以。add多个就可以了
 *          cookie在浏览器中保存多长时间？
 *              1.默认情况：关闭浏览器自动释放
 *              2.设置cookie生命周期，就可以在硬盘中持久性保存。
 *                  setMaxAge(int seconds)
 *                  正数 》 持久化，写入硬盘。存活秒数
 *                  负数 》 默认情况，即存活到浏览器关闭
 *                  零   》 表示删除cookie信息
 *          cookie能不能存中文信息？
 *              tomcat8之前，不能直接存中文。8之後支持中文数据
 *          cookie获取范围多大？作用域？
 *               假设在一个tomcat服务器中，部署了多个web项目。那么cookie能不能共享？
 *               不能。
 *               怎么贡献？setPath方法来设置cookie的获取范围
 *               默认是当前虚拟目录/day16
 *
 *          cookie的特点和作用
 *              1. 存储数据在客户端浏览器中。安全性不高，不太安全。不安全，易被篡改
 *              2. 浏览器对于cookie的大小和同一域名下的数目有限制。总数有限制
 *              3. 作用：一般用于存储少量的不太敏感的数据
 *                  在不登录的情况下，完成服务器对客户端的身份识别
 *
 *              案例：记住上一次访问时间
 *
 *   服务器端会话技术 session
 *      把数据存到服务器
 *      在一次会话的多次请求间共享数据。
 *      保存在服务器的HttpSession中
 *          httpSession.getAttribute()
 *          httpSession.setAttribute()
 *          httpSession.removeAttribute()
 *      原理：依赖于cookie
 *          第一次请求session 则创建session 得到 JSESSIONID = D09A71255F07826C7DA8DEF3E7FA2B9F
 *          浏览器再次请求时，会发送 JSESSIONID=D09A71255F07826C7DA8DEF3E7FA2B9F
 *          这样服务器找到了这个id 就能拿到相同的session
 *      细节：
 *          1. 客户端关闭 服务器不关闭 。两次获取的session是否为同一个？
 *              不是。cookie灭有了
 *              期望浏览器关闭后，session还存在。
 *              那就是
 *              cookie = new Cookie("JSESSIONID",session.getId());
 *              cookie.serMaxAge(2222)
 *              addCookie(new Cookie("JSESSIONID",session.getId()))
 *          2. 服务器关闭后 客户端不关闭。两次获取的session是否为同一个？
 *              不是。内存都释放了。session对象也不存在了
 *              怎么解决呢？
 *              session的钝化：服务器关闭后，序列化session
 *              session的活化：服务器启动后，反序列化session
 *          3. session的失效问题。
 *              服务器关闭
 *              session调用方法 httpSession.invalidate()
 *              session默认失效时间 30min
 *       特点：
 *          用于存储一次会话的多次请求数据
 *          存储在服务器
 *          大小不限 数据类型不限
 *
 *       和cookie区别
 *          位置
 *          大小
 *          安全性
 *
 *
 *
 *
 * JSP
 *   动态资源——Java代码实现
 *   概念：Java server pages。一种特殊的html页面
 *   目的：用于简化书写
 *   原理：
 *      1. 浏览器请求jsp页面
 *      2. 服务器解析请求消息，找是否存在该jsp资源。没有 404
 *      3. 找到了。会把a.jsp转换为_a.Java文件（servlet），再编译这个Java文件，生成_a.class字节码文件
 *      4. 最后执行字节码文件，完成访问。
 *      5. 所以jap本质上就是一个servlet
 *
 *   JSP脚本
 *      <%   Java代码 %> ： 定义的Java代码出现在service方法中。service方法中能些什么，这里就能写什么
 *      <%!  Java代码 %> ： 定义成员（成员变量 成员方法）——使用不多。因为不推荐再servlet中定义成员，可能会引发线程安全问题
 *      <%=  Java代码 %> ： 输出到页面，实际上是service方法中的write(你写的东西)。因此输出语句中可以写什么，就能些什么
 *
 *   JSP内置对象
 *      什么是内置对象？
 *          在JSP中不需要获取和创建就可以使用的对象——一共有9个，今天学习三个
 *          request
 *          response
 *          out——类似于response.geWriter() 有区别——缓冲区刷新时间不同
 *              out                  —— 后执行它的缓冲区
 *              response.geWriter()  —— 先执行它的缓冲区
 *      ideaJ没有代码提示的问题——应该导入为global包才行
 *
 * 小练习：
 *      带有验证码和密码的用户登陆程序
 *      验证码存放在session中，这样共享数据
 */

public class Learn {
    int i = 3;
    void myFun(){
        int i = 3;
    }

    HttpSession httpSession;
    {
//        httpSession.getAttribute()
//        httpSession.setAttribute();
//        httpSession.removeAttribute();
//        httpSession.invalidate();
    }
}
