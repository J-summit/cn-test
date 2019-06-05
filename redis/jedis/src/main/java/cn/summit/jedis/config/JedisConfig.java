package cn.summit.jedis.config;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * @author onlyo
 * @since 2019/4/29 10:04
 */
public class JedisConfig {
    private static JedisPool jedisPool;

    static {
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(20);
        jedisPoolConfig.setMaxIdle(10);
        jedisPool = new JedisPool(jedisPoolConfig, "192.168.43.111", 6379);
    }

    public static Jedis getJedis() throws Exception {
        if (jedisPool != null) {
           return jedisPool.getResource();
        }
        throw new Exception("jedispool failed");

    }
}
