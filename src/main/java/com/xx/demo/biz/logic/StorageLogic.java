package com.xx.demo.biz.logic;

import java.util.Map;
import java.util.Set;

import redis.clients.jedis.ScanResult;

/**
 * Redis缓存
 * @author chlingm
 *
 */
public interface StorageLogic {

    /**
     * 生成针对特定prefix唯一的自增ID
     * 
     * @param prefix
     * @return
     */
    public Long generateId(String prefix);

    public String get(String prefix, Long id);

    public void set(String prefix, Long id, String value);

    public boolean del(String prefix, Long id);

    public Map<String, String> hgetAll(String prefix, Long id);

    public void hmset(String prefix, Long id, Map<String, String> hash);

    public String hget(String prefix, Long id, String field);

    public String hget(String prefix, String id, String field);

    public void hset(String prefix, Long id, String field, String value);

    public void hset(String prefix, String id, String field, String value);

    public boolean hdel(String prefix, Long id, String... fields);

    public boolean hexists(String prefix, Long id, String field);

    public void sadd(String prefix, String key, String member);

    public boolean srem(String prefix, String key, String member);

    public boolean srem(String prefix, String key, String... members);

    public boolean sismember(String prefix, String key, String member);

    public ScanResult<String> sscan(String prefix, String key, String cursor, Integer count);

    public boolean exists(String prefix, String key);

    public Set<String> smembers(String prefix, String key);

    public boolean del(String prefix, String key);

    public String get(String prefix, String key);

    public void set(String prefix, String key, String value);

    public void set(String prefix, String key, String value, int seconds);

    public void expire(String prefix, String key, int seconds);

    public void zadd(String prefix, String key, long score, String value);

    public Set<String> zrangebyscore(String prefix, String key, long lScore, long hScore);

    public void zrem (String prefix, String key, String value);
    
}
