package database;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisUtil {
    //the jedis connection pool
    private static JedisPool pool = null;

    //configure our pool connection
    static {
        pool = new JedisPool("localhost", 6379);
    }

    public static Jedis getJedis() {
        Jedis jedis = pool.getResource();
        return jedis;
    }

    public static JedisPool getPool() {
        return pool;
    }
}
