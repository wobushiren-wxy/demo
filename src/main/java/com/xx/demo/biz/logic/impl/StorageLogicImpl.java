package com.xx.demo.biz.logic.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import com.xx.demo.biz.logic.StorageLogic;
import com.xx.demo.dao.DaoFactory;
import com.xx.demo.redis.RedisMaster;
import com.xx.demo.redis.RedisSlave;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.ScanParams;
import redis.clients.jedis.ScanResult;
import redis.clients.jedis.exceptions.JedisConnectionException;


public class StorageLogicImpl implements StorageLogic {

    private static final String                          ALL_PREFIX         = "all";
    private ConcurrentHashMap<String, List<RedisMaster>> redisMastersMap    = new ConcurrentHashMap<String, List<RedisMaster>>();
    private ConcurrentHashMap<Integer, List<JedisPool>>  slaveJedisPoolMap  = new ConcurrentHashMap<Integer, List<JedisPool>>();
    private ConcurrentHashMap<Integer, JedisPool>        masterJedisPoolMap = new ConcurrentHashMap<Integer, JedisPool>();

    public StorageLogicImpl() {
        super();
        try {
            init();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void init() throws SQLException {
        List<RedisMaster> redisMasters = DaoFactory.getRedisDAO().getRedisMasters();
        for (RedisMaster redisMaster : redisMasters) {
            String types[] = redisMaster.getType().split(",");
            for (String type : types) {
                List<RedisMaster> masters = redisMastersMap.get(type);
                if (masters == null) {
                    masters = new ArrayList<RedisMaster>();
                    redisMastersMap.put(type, masters);
                }
                masters.add(redisMaster);
            }
            JedisPool masterJedisPool = new JedisPool(redisMaster.getHost(), redisMaster.getPort());
            masterJedisPoolMap.put(redisMaster.getId(), masterJedisPool);
        }
        List<RedisSlave> redisSlaves = DaoFactory.getRedisDAO().getRedisSlaves();
        for (RedisSlave redisSlave : redisSlaves) {
            List<JedisPool> slaveJedisPools = slaveJedisPoolMap.get(redisSlave.getSlaveof());
            if (slaveJedisPools == null) {
                slaveJedisPools = new ArrayList<JedisPool>();
                slaveJedisPoolMap.put(redisSlave.getSlaveof(), slaveJedisPools);
            }
            JedisPool slaveJedisPool = new JedisPool(redisSlave.getHost(), redisSlave.getPort());
            slaveJedisPools.add(slaveJedisPool);
        }
    }

    @Override
    public Long generateId(String prefix) {
        JedisHandler<Long> jedisHandler = new JedisHandler<Long>() {

            @Override
            public Long handle(Jedis jedis, Object... args) {
                String prefix = (String) args[0];
                String key = prefix + "id";
                return jedis.incr(key);
            }
        };
        return masterJedisHandle(jedisHandler, prefix, 0L);
    }

    @Override
    public String get(String prefix, Long id) {
        JedisHandler<String> jedisHandler = new JedisHandler<String>() {
            @Override
            public String handle(Jedis jedis, Object... args) {
                String prefix = (String) args[0];
                Long id = (Long) args[1];
                String key = prefix + id.toString();
                return jedis.get(key);
            }
        };
        return slaveJedisHandle(jedisHandler, prefix, id);
    }

    @Override
    public void set(String prefix, Long id, String value) {
        JedisHandler<String> jedisHandler = new JedisHandler<String>() {
            @Override
            public String handle(Jedis jedis, Object... args) {
                String prefix = (String) args[0];
                Long id = (Long) args[1];
                String value = (String) args[2];
                String key = prefix + id.toString();
                return jedis.set(key, value);
            }
        };
        masterJedisHandle(jedisHandler, prefix, id, value);
    }

    @Override
    public boolean del(String prefix, Long id) {
        JedisHandler<Boolean> jedisHandler = new JedisHandler<Boolean>() {
            @Override
            public Boolean handle(Jedis jedis, Object... args) {
                String prefix = (String) args[0];
                Long id = (Long) args[1];
                String key = prefix + id.toString();
                if (jedis.del(key) == 1L) {
                    return true;
                } else {
                    return false;
                }
            }
        };
        return masterJedisHandle(jedisHandler, prefix, id);
    }

    @Override
    public String hget(String prefix, Long id, String field) {
        JedisHandler<String> jedisHandler = new JedisHandler<String>() {
            @Override
            public String handle(Jedis jedis, Object... args) {
                String prefix = (String) args[0];
                Long id = (Long) args[1];
                String field = (String) args[2];
                String key = prefix + id.toString();
                return jedis.hget(key, field);
            }
        };
        return slaveJedisHandle(jedisHandler, prefix, id, field);
    }

    @Override
    public String hget(String prefix, String id, String field) {
        JedisHandler<String> jedisHandler = new JedisHandler<String>() {
            @Override
            public String handle(Jedis jedis, Object... args) {
                String prefix = (String) args[0];
                String id = (String) args[2];
                String field = (String) args[3];
                String key = prefix + id;
                return jedis.hget(key, field);
            }
        };
        return slaveJedisHandle(jedisHandler, prefix, 0L, id, field);
    }

    @Override
    public void hset(String prefix, String id, String field, String value) {
        JedisHandler<Long> jedisHandler = new JedisHandler<Long>() {
            @Override
            public Long handle(Jedis jedis, Object... args) {
                String prefix = (String) args[0];
                String id = (String) args[2];
                String field = (String) args[3];
                String value = (String) args[4];
                String key = prefix + id;
                return jedis.hset(key, field, value);
            }
        };
        masterJedisHandle(jedisHandler, prefix, 0L, id, field, value);
    }

    @Override
    public void hset(String prefix, Long id, String field, String value) {
        JedisHandler<Long> jedisHandler = new JedisHandler<Long>() {
            @Override
            public Long handle(Jedis jedis, Object... args) {
                String prefix = (String) args[0];
                Long id = (Long) args[1];
                String field = (String) args[2];
                String value = (String) args[3];
                String key = prefix + id.toString();
                return jedis.hset(key, field, value);
            }
        };
        masterJedisHandle(jedisHandler, prefix, id, field, value);
    }

    @Override
    public boolean hexists(String prefix, Long id, String field) {
        JedisHandler<Boolean> jedisHandler = new JedisHandler<Boolean>() {

            @Override
            public Boolean handle(Jedis jedis, Object... args) {
                String prefix = (String) args[0];
                Long id = (Long) args[1];
                String field = (String) args[2];
                String key = prefix + id.toString();
                return jedis.hexists(key, field);
            }
        };
        return slaveJedisHandle(jedisHandler, prefix, id, field);

    }

    @Override
    public boolean hdel(String prefix, Long id, String... fields) {
        JedisHandler<Boolean> jedisHandler = new JedisHandler<Boolean>() {

            @Override
            public Boolean handle(Jedis jedis, Object... args) {
                String prefix = (String) args[0];
                Long id = (Long) args[1];
                String[] fields = (String[]) args[2];
                String key = prefix + id.toString();
                if (jedis.hdel(key, fields) == 1L) {
                    return true;
                } else {
                    return false;
                }
            }
        };
        return masterJedisHandle(jedisHandler, prefix, id, fields);
    }

    @Override
    public Map<String, String> hgetAll(String prefix, Long id) {
        JedisHandler<Map<String, String>> jedisHandler = new JedisHandler<Map<String, String>>() {

            @Override
            public Map<String, String> handle(Jedis jedis, Object... args) {
                String prefix = (String) args[0];
                Long id = (Long) args[1];
                String key = prefix + id.toString();
                return jedis.hgetAll(key);
            }
        };
        return slaveJedisHandle(jedisHandler, prefix, id);
    }

    @Override
    public void hmset(String prefix, Long id, Map<String, String> hash) {
        JedisHandler<String> jedisHandler = new JedisHandler<String>() {

            @SuppressWarnings("unchecked")
			@Override
            public String handle(Jedis jedis, Object... args) {
                String prefix = (String) args[0];
                Long id = (Long) args[1];
                Map<String, String> hash = (Map<String, String>) args[2];
                String key = prefix + id.toString();
                return jedis.hmset(key, hash);
            }
        };
        masterJedisHandle(jedisHandler, prefix, id, hash);
    }

    @Override
    public void sadd(String prefix, String key, String member) {
        JedisHandler<Long> jedisHandler = new JedisHandler<Long>() {

            @Override
            public Long handle(Jedis jedis, Object... args) {
                String prefix = (String) args[0];
                String key = (String) args[2];
                String member = (String) args[3];
                return jedis.sadd(prefix + key, member);
            }
        };
        masterJedisHandle(jedisHandler, prefix, 0L, key, member);
    }

    @Override
    public boolean srem(String prefix, String key, String member) {
        JedisHandler<Boolean> jedisHandler = new JedisHandler<Boolean>() {

            @Override
            public Boolean handle(Jedis jedis, Object... args) {
                String prefix = (String) args[0];
                String key = (String) args[2];
                String member = (String) args[3];
                if (jedis.srem(prefix + key, member) == 1L) {
                    return true;
                } else {
                    return false;
                }
            }
        };
        return masterJedisHandle(jedisHandler, prefix, 0L, key, member);
    }

    @Override
    public boolean srem(String prefix, String key, String... members) {
        JedisHandler<Boolean> jedisHandler = new JedisHandler<Boolean>() {

            @Override
            public Boolean handle(Jedis jedis, Object... args) {
                String prefix = (String) args[0];
                String key = (String) args[2];
                String[] members = (String[]) args[3];
                if (jedis.srem(prefix + key, members) == 1L) {
                    return true;
                } else {
                    return false;
                }
            }
        };
        return masterJedisHandle(jedisHandler, prefix, 0L, key, members);
    }

    @Override
    public boolean sismember(String prefix, String key, String member) {
        JedisHandler<Boolean> jedisHandler = new JedisHandler<Boolean>() {

            @Override
            public Boolean handle(Jedis jedis, Object... args) {
                String prefix = (String) args[0];
                String key = (String) args[2];
                String member = (String) args[3];
                return jedis.sismember(prefix + key, member);
            }
        };
        return slaveJedisHandle(jedisHandler, prefix, 0L, key, member);
    }

    @Override
    public ScanResult<String> sscan(String prefix, String key, String cursor, Integer count) {
        JedisHandler<ScanResult<String>> jedisHandler = new JedisHandler<ScanResult<String>>() {

            @Override
            public ScanResult<String> handle(Jedis jedis, Object... args) {
                String prefix = (String) args[0];
                String key = (String) args[2];
                String cursor = (String) args[3];
                Integer count = (Integer) args[4];
                ScanParams scanParams = new ScanParams();
                scanParams.count(count);
                return jedis.sscan(prefix + key, cursor, scanParams);

            }
        };
        return slaveJedisHandle(jedisHandler, prefix, 0L, key, cursor, count);

    }

    @Override
    public Set<String> smembers(String prefix, String key) {
        JedisHandler<Set<String>> jedisHandler = new JedisHandler<Set<String>>() {

            @Override
            public Set<String> handle(Jedis jedis, Object... args) {
                String prefix = (String) args[0];
                String key = (String) args[2];
                return jedis.smembers(prefix + key);

            }
        };
        return slaveJedisHandle(jedisHandler, prefix, 0L, key);

    }

    @Override
    public boolean del(String prefix, String key) {
        JedisHandler<Boolean> jedisHandler = new JedisHandler<Boolean>() {
            @Override
            public Boolean handle(Jedis jedis, Object... args) {
                String prefix = (String) args[0];
                String key = (String) args[2];
                key = prefix + key;
                if (jedis.del(key) == 1L) {
                    return true;
                } else {
                    return false;
                }
            }
        };
        return masterJedisHandle(jedisHandler, prefix, 0L, key);
    }

    @Override
    public String get(String prefix, String key) {
        JedisHandler<String> jedisHandler = new JedisHandler<String>() {
            @Override
            public String handle(Jedis jedis, Object... args) {
                String prefix = (String) args[0];
                String key = (String) args[2];
                key = prefix + key;
                return jedis.get(key);
            }
        };
        return slaveJedisHandle(jedisHandler, prefix, 0L, key);
    }

    @Override
    public void set(String prefix, String key, String value) {
        JedisHandler<String> jedisHandler = new JedisHandler<String>() {
            @Override
            public String handle(Jedis jedis, Object... args) {
                String prefix = (String) args[0];
                String key = (String) args[2];
                String value = (String) args[3];
                key = prefix + key;
                return jedis.set(key, value);
            }
        };
        masterJedisHandle(jedisHandler, prefix, 0L, key, value);
    }

    @Override
    public void set(String prefix, String key, String value, int seconds) {
        JedisHandler<String> jedisHandler = new JedisHandler<String>() {
            @Override
            public String handle(Jedis jedis, Object... args) {
                String prefix = (String) args[0];
                String key = (String) args[2];
                String value = (String) args[3];
                key = prefix + key;
                int seconds = (Integer) args[4];
                return jedis.setex(key, seconds, value);
            }
        };
        masterJedisHandle(jedisHandler, prefix, 0L, key, value, seconds);
    }

    @Override
    public void expire(String prefix, String key, int seconds) {
        JedisHandler<Long> jedisHandler = new JedisHandler<Long>() {
            @Override
            public Long handle(Jedis jedis, Object... args) {
                String prefix = (String) args[0];
                String key = (String) args[2];
                int seconds = (Integer) args[3];
                key = prefix + key;
                return jedis.expire(key, seconds);
            }
        };
        masterJedisHandle(jedisHandler, prefix, 0L, key, seconds);
    }

    @Override
    public boolean exists(String prefix, String key) {
        JedisHandler<Boolean> jedisHandler = new JedisHandler<Boolean>() {

            @Override
            public Boolean handle(Jedis jedis, Object... args) {
                String prefix = (String) args[0];
                String key = (String) args[2];
                return jedis.exists(prefix + key);
            }
        };
        return slaveJedisHandle(jedisHandler, prefix, 0L, key);
    }

    private <T> T slaveJedisHandle(JedisHandler<T> jedisHandler, Object... args) {
        String prefix = (String) args[0];
        Long id = (Long) args[1];
        T result = null;
        Integer masterRedisId = getMasterRedisId(prefix, id);
        if (masterRedisId != null) {
            List<JedisPool> slaveJedisPoolList = slaveJedisPoolMap.get(masterRedisId);
            Random r = new Random();
            int i = r.nextInt(slaveJedisPoolList.size());
            JedisPool slaveJedisPool = slaveJedisPoolList.get(i);
            if (slaveJedisPool != null) {
                Jedis slaveJedis = slaveJedisPool.getResource();
                try {
                    result = jedisHandler.handle(slaveJedis, args);
                } catch (JedisConnectionException e) {
                    if (slaveJedis != null) {
                        slaveJedisPool.returnBrokenResource(slaveJedis);
                        slaveJedis = null;
                    }
                    throw e;
                } finally {
                    if (slaveJedis != null) {
                        slaveJedisPool.returnResource(slaveJedis);
                    }
                }
            }
        }
        return result;
    }

    private <T> T masterJedisHandle(JedisHandler<T> jedisHandler, Object... args) {
        String prefix = (String) args[0];
        Long id = (Long) args[1];
        T result = null;
        Integer masterRedisId = getMasterRedisId(prefix, id);
        if (masterRedisId != null) {
            JedisPool masterJedisPool = masterJedisPoolMap.get(masterRedisId);
            if (masterJedisPool != null) {
                Jedis masterJedis = masterJedisPool.getResource();
                try {
                    result = jedisHandler.handle(masterJedis, args);
                } catch (JedisConnectionException e) {
                    if (masterJedis != null) {
                        masterJedisPool.returnBrokenResource(masterJedis);
                        masterJedis = null;
                    }
                    throw e;
                } finally {
                    if (masterJedis != null) {
                        masterJedisPool.returnResource(masterJedis);
                    }
                }
            }
        }
        return result;
    }

    private Integer getMasterRedisId(String prefix, Long id) {
        List<RedisMaster> redisMasterList = redisMastersMap.get(prefix);
        if (redisMasterList == null) {
            redisMasterList = redisMastersMap.get(ALL_PREFIX);
        }
        Integer masterJedisId = null;
        if (redisMasterList != null) {
            for (RedisMaster redisMaster : redisMasterList) {
                long begin = redisMaster.getBegin();
                long end = redisMaster.getEnd();
                if ((end == -1) || id >= begin && id < end) {
                    masterJedisId = redisMaster.getId();
                }
            }
        }
        return masterJedisId;
    }

    private interface JedisHandler<T> {
        public T handle(Jedis jedis, Object... args);
    }

    @Override
    public void zadd(String prefix, String key, long score, String value) {
        JedisHandler<Long> jedisHandler = new JedisHandler<Long>() {
            @Override
            public Long handle(Jedis jedis, Object... args) {
                String prefix = (String) args[0];
                String key = (String) args[2];
                long score = (Long) args[3];
                String value = (String) args[4];
                key = prefix + key;
                return jedis.zadd(key, score, value);
            }
        };
        masterJedisHandle(jedisHandler, prefix, 0L, key, score, value);
    }

    @Override
    public Set<String> zrangebyscore(String prefix, String key, long lScore, long hScore) {
        JedisHandler<Set<String>> jedisHandler = new JedisHandler<Set<String>>() {
            @Override
            public Set<String> handle(Jedis jedis, Object... args) {
                String prefix = (String) args[0];
                String key = (String) args[2];
                Long lScore = (Long) args[3];
                Long hScore = (Long) args[4];
                key = prefix + key;
                return jedis.zrangeByScore(key, lScore.doubleValue(), hScore.doubleValue());
            }
        };
        return slaveJedisHandle(jedisHandler, prefix, 0L, key, lScore, hScore);
    }

    @Override
    public void zrem(String prefix, String key, String value) {
        JedisHandler<Long> jedisHandler = new JedisHandler<Long>() {
            @Override
            public Long handle(Jedis jedis, Object... args) {
                String prefix = (String) args[0];
                String key = (String) args[2];
                String value = (String) args[3];
                key = prefix + key;
                return jedis.zrem(key, value);
            }
        };
        masterJedisHandle(jedisHandler, prefix, 0L, key, value);
    }

}
