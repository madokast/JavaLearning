package M02_HTTP;

/**
 * http 学习
 * 客户请求服务器
 * 服务器响应客户端
 * http协议
 *  基于TMP/IP
 *  HTTP默认端口 80
 *  请求响应
 *  无状态的，不能通信
 *
 * 历史版本
 *  1.0 —— 每一次请求响应都会建立新的连接
 *  1.1 —— 复用连接
 *
 * 协议格式
 * 请求消息数据格式
 *      请求行： GET URL HTTP/1.1
 *          get 长度有限
 *          post 长度没有限制
 *      请求头： A: a/r/n
 *          user-agent
 *          referer
 *      请求空行：
 *          用于分隔
 *      请求体：user=zhangsan
 *          POST信息
 *
 *
 * 相应消息数据格式
 *
 */

public class HttpLearn {
}
