package redis;

import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * jedis
 *                 _._
 *            _.-``__ ''-._
 *       _.-``    `.  `_.  ''-._           Redis 2.8.4 (00000000/0) 64 bit
 *   .-`` .-```.  ```\/    _.,_ ''-._
 *  (    '      ,       .-`  | `,    )     Running in stand alone mode
 *  |`-._`-...-` __...-.``-._|'` _.-'|     Port: 6379
 *  |    `-._   `._    /     _.-'    |     PID: 16476
 *   `-._    `-._  `-./  _.-'    _.-'
 *  |`-._`-._    `-.__.-'    _.-'_.-'|
 *  |    `-._`-._        _.-'_.-'    |           http://redis.io
 *   `-._    `-._`-.__.-'_.-'    _.-'
 *  |`-._`-._    `-.__.-'    _.-'_.-'|
 *  |    `-._`-._        _.-'_.-'    |
 *   `-._    `-._`-.__.-'_.-'    _.-'
 *       `-._    `-.__.-'    _.-'
 *           `-._        _.-'
 *               `-.__.-'
 *
 * [16476] 08 Sep 23:01:26.593 # Server started, Redis version 2.8.4
 * [16476] 08 Sep 23:01:26.594 * The server is now ready to accept connections on port 6379
 */

public class Test {
    @org.junit.Test
    public void test1(){
        //获取连接
        Jedis jedis = new Jedis("localhost",6379);
        //操作
        //s-s
        jedis.set("username","zhangsan");
        final String username = jedis.get("username");
        System.out.println("username = " + username);
        jedis.del("username");
//        jedis.setex()

        //s-hash
        jedis.hset("myhash","age","25");
        final String myhash_age = jedis.hget("myhash", "age");
        System.out.println("myhash_age = " + myhash_age);
        jedis.hdel("myhash","age");
        System.out.println(jedis.hget("myhash","age"));
        final Map<String, String> map = jedis.hgetAll("myhash");
        System.out.println("map = " + map);

        //s-list
        jedis.lpush("mylist","A");
        jedis.rpush("mylist","B");
        final List<String> mylist = jedis.lrange("mylist", 0, 2);
        System.out.println("mylist = " + mylist);
        System.out.println("jedis.lpop(\"mylist\") = " + jedis.lpop("mylist"));


        //set
        jedis.sadd("myset","a","b","c","a");
        final Set<String> myset = jedis.smembers("myset");
        System.out.println("myset = " + myset);

        //sortedSet
        jedis.zadd("myzet",1.1,"aa");
        jedis.zadd("myzet",2.1,"bb");
        final Set<String> myzet = jedis.zrange("myzet", 0, -1);
        System.out.println("myzet = " + myzet);

        //释放资源
        jedis.close();
    }
}
