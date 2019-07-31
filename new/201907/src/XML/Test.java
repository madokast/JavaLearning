package XML;

/**
 * XML
 * 可扩展标记语言
 * 可扩展？标签自定义
 *
 * XML 和 HTML
 *
 * XML用于代替properties 配置文件
 * 方便于网络传输
 * XML存储数据
 *
 * 基本语法
 *
 * 解析xml
 *      DOM思想——服务器端
 *          把XML一次性加载到内存，形成一个树结构
 *          优点：操作方便，可以进行所有CRUD操作
 *          缺点：消耗内存
 *      SAX思想——移动端
 *          逐行读取，基于事件驱动。例如读到<a>标签，就指定做某事
 *          优点：不占内存。内存中永远只有一行，读下一行就会释放
 *          缺点：只能读取，不能修改XML
 *
 * 常见的XML解析器
 *      JAXP 官方提供，烂
 *      DOM4J 有限的 常用
 *      Jsoup 解析HTML的，DOM形式，
 *      PULL 安卓内置 SAX方式
 */

public class Test {
}
