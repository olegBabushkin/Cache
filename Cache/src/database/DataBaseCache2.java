package database;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.exceptions.JedisException;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//REDDIS
public class DataBaseCache2<K, V> implements IDataBase<K, V> {
    private static DataBaseCache2 instance;
    private Jedis jedis;


    private DataBaseCache2() {
        this.jedis = RedisUtil.getJedis();
    }

    public static DataBaseCache2 getDataBase2() {
        if (instance == null) {
            instance = new DataBaseCache2();
        }
        return instance;
    }

    @Override
    public void add(K key, V value) {
        byte[] keyBytes = key.toString().getBytes();
        byte[] valueBytes = value.toString().getBytes();
        try {
            jedis.sadd(keyBytes, valueBytes);
            //after saving the data, lets retrieve them to be sure that it has really added in redis
            Set<byte[]> members = jedis.smembers(keyBytes);
            for (byte[] member : members) {
                System.out.println((V) new String(member));
            }
        } catch (JedisException e) {
            //if something wrong happen, return it back to the pool
            if (null != jedis) {
                RedisUtil.getPool().returnBrokenResource(jedis);
                jedis = null;
            }
        }
        System.out.println("addInReddis");
    }

   /* public void addHash(K key, V value) {
        //add some values in Redis HASH
        Map<String, String> map = new HashMap<>();
        map.put(key.toString(), value.toString());


        //save to redis
        jedis.hmset(key.toString(), map);

        //after saving the data, lets retrieve them to be sure that it has really added in redis
        Map<String, String> retrieveMap = jedis.hgetAll(key.toString());
        for (String keyMap : retrieveMap.keySet()) {
            System.out.println(keyMap + " " + retrieveMap.get(keyMap));


        *//*} catch (JedisException e) {
            //if something wrong happen, return it back to the pool
            if (null != jedis) {
                RedisUtil.getPool().returnBrokenResource(jedis);
                jedis = null;
            }
        }*//*
            System.out.println("addInReddis");
        }
    }*/


        @Override
        public void deleteOldest(K key){
            byte[] keyBytes = key.toString().getBytes();
            System.out.println(jedis.del(keyBytes));
        }

        @Override
        public V get (K key){
            return null;
        }
}
