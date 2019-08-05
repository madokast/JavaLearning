package M04_HTTP_And_Response;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * Day 15
 *
 * HTTP响应消息
 * 服务器-->浏览器
 *
 * 回顾：请求消息
 *      请求行
 *      请求头
 *      空行
 *      请求体
 *
 * 相应消息：服务器-->客户端
 *      响应行 HTTP/1.1 200 OK
 *      响应头 键值对
 *      空行 /t/n
 *      响应体：HTML页面 内容
 *
 * 709
 * ------------------------------------------
 * 相应行 HTTP/1.1 200 OK
 *      协议 状态码 状态描述
 *      状态码：本次请求和响应的状态。5大类。1XX 2XX 3XX 4XX 5XX
 *      100-服务器接受客户端信息，但是没有接收完成，等待客户端继续发送
 *      300-客户端内，A说我做不了，你让B去吧。于是服务器再请求B。
 *      304-访问缓存吧。当浏览器缓存了图片，且图片没有发生改变，服务器就发送304让浏览器读取缓存信息。
 *
 * 710
 * -------------------------------------------
 * 响应头 键值对
 *      content-type: text/html;charset=utf-8 当前资源的格式，编码方法。没有弄好就会导致中文乱码
 *      content-length
 *      content-disposition  告诉浏览器以什么格式打开响应体数据
 *              in-line    当前页面显示
 *              attachment 用于资源下载
 *
 * 响应体：传输的数据
 *
 * 711
 * ----------------------------------------------
 * response对象
 * 用于设置响应消息数据。设置响应行 响应头 响应体
 *
 * 设置状态码： setStatus(int)
 * 设置响应头：setHeader(name，value)
 * 设置响应体：流方式设置，输出流。
 *      字符输出流——getWriter
 *      字节输出流——getOutputStream
 *
 *
 * HttpServletResponse httpServletResponse;
 *     {
 *         httpServletResponse.setStatus();
 *         httpServletResponse.setHeader(name,key);
 *         httpServletResponse.getWriter();
 *         httpServletResponse.getOutputStream()
 *     }
 *
 * 712
 * ------------------------------------------------
 * 写代码了!!
 *
 */

public class ResponseLearn {
}
