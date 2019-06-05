package cn.summit.jedis.lock;

import cn.summit.jedis.config.JedisConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author onlyo
 * @since 2019/4/29 10:29
 */
public class RedisLock {
    /**
     * 获取锁
     *
     * @param key     对应的key
     * @param timeout 超时时间
     * @return 锁的value值
     */
    public String getLock(String key, Long timeout) {
        try {
            Jedis jedis = JedisConfig.getJedis();
            //指定一定时间内去获取 超过这个时间则直接返回 获取失败
            Long end = System.currentTimeMillis() + timeout;
            String value = UUID.randomUUID().toString();
            //循环去设置值 并且设置过期时间
            while (System.currentTimeMillis() < end) {
                if (jedis.setnx(key, value) == 1) {
                    jedis.pexpire(key, timeout);
                    //设置锁成功
                    return value;
                }
                //返回-1 则该key未设置超时时间
                if (jedis.ttl(key) == -1) {
                    jedis.pexpire(key, timeout);
                }
                //每次循环卡1s
                TimeUnit.SECONDS.sleep(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 释放锁
     *
     * @param key   对应的key
     * @param value value值
     * @return 释放成功与否
     */
    public boolean releaseLock(String key, String value) {
        try {
            Jedis jedis = JedisConfig.getJedis();
            while (true) {
                // watch 决定事务是执行还是回滚 发现key修改 则mutil的事务回滚
                jedis.watch(key);
                if (value.equals(jedis.get(key))) {
                    Transaction transaction = jedis.multi();
                    transaction.del(key);
                    List<Object> list = transaction.exec();
                    if (list == null) {
                        continue;
                    }
                    return true;
                }
                jedis.unwatch();
                break;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        RedisLock redisLock = new RedisLock();
        String key = "t";
        String value = redisLock.getLock(key, 10000L);
        if (value != null) {
            System.out.println("获取锁成功！！！！");
        }
        String value1 = redisLock.getLock(key, 10000L);

        boolean a = redisLock.releaseLock(key, value);
        System.out.println(a);
    }
}
