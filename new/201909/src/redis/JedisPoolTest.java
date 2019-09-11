package redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.awt.*;

public class JedisPoolTest {
    public static void main(String[] args) {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        //看样子需要beanUtils
        jedisPoolConfig.setMaxTotal(50);
        jedisPoolConfig.setMaxIdle(10);



        JedisPool jedisPool = new JedisPool("127.0.0.1",6379);
        final Jedis resource = jedisPool.getResource();



        resource.close();
    }
}
