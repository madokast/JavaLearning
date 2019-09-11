package util;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Map;
import java.util.Properties;

/**
 * 工具类
 */

public class JedisPoolUtils {
    private static JedisPool jedisPool ;
    static {
        try {
            final Properties jedisAddr = new Properties();
            jedisAddr.load(JedisPoolUtils.class.getClassLoader().getResourceAsStream("jedisAddr.properties"));

            final Properties jedisConfig = new Properties();
            jedisConfig.load(JedisPoolUtils.class.getClassLoader().getResourceAsStream("jedisConfig.properties"));

            JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
            BeanUtils.populate(jedisPoolConfig,(Map<String,String>) ((Map) jedisConfig));

            System.out.println("jedisPoolConfig.getMaxTotal() = " + jedisPoolConfig.getMaxTotal());

            jedisPool = new JedisPool(jedisPoolConfig,jedisAddr.getProperty("host"),
                    Integer.parseInt(jedisAddr.getProperty("port")));

        }catch ( Exception e){
            e.printStackTrace();
        }
    }


    public static Jedis getJedis(){
        return jedisPool.getResource();
    }

    @Test
    public void test(){
        final Jedis jedis = getJedis();
        jedis.close();
    }
}
