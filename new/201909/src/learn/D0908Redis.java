package learn;

/**
 * 864
 * redis 特殊的数据库软件
 *      概念
 *      下载安装
 *      命令操作
 *          数据结构
 *      持久化
 *      Java操作redis
 *
 * 一款高性能的NOSQL系列的非关系型数据库
 *      NOSQL no only sql
 *      非关系型  redis hbase
 *      关系型：数据存在表里 数据之间有关联 数据存在硬盘文件上
 *      非关系型：没有表的概念，存储为键值对 数据存在内存中  数据间没有关系
 *      关系型数据库——文件IO 速度慢
 *      非关系型数据库——
 *
 * 需求：经常要查询一个变化慢的数据库
 *  思想：缓存于内存中
 *  过程：第一次查询缓存，以后的相同查询就不访问数据库了
 *      Java Msp集合作为缓存的的缺点？  多个机器无法共享，用redis实现缓存
 *
 *
 *  用途：
 *      缓存
 *      好友列表
 *      任务队列——秒数、抢购、12360 高并发
 *      应用排行榜
 *      网站统计访问
 *      数据过期处理--精确到毫秒
 *      分布式集群架构中的session分离
 *
 * 下载安装：
 *      redis.windows.conf 配置文件
 *      redis-cli 客户端
 *      redis-serve 服务器端
 *
 *
 * redis数据结构
 *      键值对
 *      key-都是字符串
 *      value-五种
 *          字符串string
 *          哈希结构 hash （map  --即redis嵌套
 *          列表格式 list 《linkedList  按插入顺序
 *          集合   set  --不重复 不保证顺序
 *          有序集合  sortedSet   --不重复
 *
 * 命令：
 *  string
 *      set key value
 *      get key
 *      del key
 *  hash
 *      hset key field value
 *      hget key field
 *      hgetall key
 *      hdel key field
 * list  mylist = [a,b,c]  当作队列
 *      lpush / rpush key value  --左加 有加
 *      lrange key start end
 *
 *      lpop / rpop key
 *
 * set
 *      sadd key value
 *      smembers key --all element
 *      srem key value -- remove one
 *
 * sortedSet —— 排行榜 热搜榜
 *      zadd key score value  -- 对score排序
 *      zrange key start end
 *      zrem key value
 *
 * range 0 -1 ---all
 *
 * 通用命令
 *      keys * -- 所有键
 *      type key -- 类型
 *      del key -- 删除键值对
 *
 * 872
 * 持久化
 *      内存数据库——可以持久化
 *      持久化机制：
 *          RDB：默认。——不保证全部保存
 *             在一定的间隔事件中，检测key变化，然后持久化数据
 *          AOF：日志记录方式。——对性能影响大
 *      配置文件
 *          save 900 1
 *          save 300 10
 *          save 60 10000
 *          #   In the example below the behaviour will be to save:
 *          #   after 900 sec (15 min) if at least 1 key changed   15分钟后，如果有1个key改变，就会持久化一次
 *          #   after 300 sec (5 min) if at least 10 keys changed   5min后，10个变
 *          #   after 60 sec if at least 10000 keys changed         1分钟，1w key
 *          重新启动redis服务器，并指定配置文件
 *
 *      AOF方法
 *          appendonly no
 *          appendonly yes
 *          # appendfsync always
 *          appendfsync everysec
 *          # appendfsync no
 *
 *
 * Jedis——Java操作redis的工具
 *      使用方法
 *      下载jar
 *
 * jedisPool 连接池
 *
 */

public class D0908Redis {
}
