package com.fintecher.sims.config.cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisConnectionUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @Author: jwdstef
 * @Description:
 * @Date 2017/6/9
 */
@Slf4j
@Component
public class RedisUtil {

    private RedisTemplate redisTemplate;

    public RedisUtil(RedisTemplate redisTemplate){
        this.redisTemplate = redisTemplate;
    }

    /**
     * 写入缓存
     *
     * @param key
     * @param value
     * @return
     */
    public boolean set(final String key, Object value) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 写入缓存
     *
     * @param key
     * @param value
     * @param expireTime
     * @return
     */
    public boolean set(final String key, Object value, Long expireTime) {
        boolean result = false;
        try {
            ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
            operations.set(key, value);
            redisTemplate.expire(key, expireTime, TimeUnit.SECONDS);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 判断缓存中是否有对应的value
     *
     * @param key
     * @return
     */
    public boolean exists(final String key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 读取缓存
     *
     * @param key
     * @return
     */
    public Object get(final String key) {
        Object result = null;
        ValueOperations<Serializable, Object> operations = redisTemplate.opsForValue();
        result = operations.get(key);
        return result;
    }

    /**
     * 删除对应的value
     *
     * @param key
     */
    public void remove(final String key) {
        if (exists(key)) {
            redisTemplate.delete(key);
        }
    }

    /**
     * 批量删除对应的value
     *
     * @param keys
     */
    public void remove(final String... keys) {
        for (String key : keys) {
            remove(key);
        }
    }

    /**
     * 批量删除key
     *
     * @param pattern
     */
    public void removePattern(final String pattern) {
        Set<Serializable> keys = redisTemplate.keys(pattern);
        if (keys.size() > 0)
            redisTemplate.delete(keys);
    }

    /**
     * 写入队列 List
     *
     * @param key
     * @param value
     * @return
     */
    public boolean lpush(final String key, Object value) {
        boolean result = false;
        try {
            ListOperations<Serializable, Object> operations = redisTemplate.opsForList();
            operations.leftPush(key, value);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 取出队列 List
     *
     * @param key
     * @return
     */
    public Object rpop(final String key) {
        Object result = null;
        try {
            ListOperations<Serializable, Object> operations = redisTemplate.opsForList();
            result = operations.rightPop(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 取出队列 List
     *
     * @param key1
     * @param key2
     * @return
     */
    public Object rpoplpush(final String key1, final String key2) {
        Object result = null;
        try {
            ListOperations<Serializable, Object> operations = redisTemplate.opsForList();
            result = operations.rightPopAndLeftPush(key1, key2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 查询队列 List
     *
     * @param key
     * @return
     */
    public List range(final String key) {
        List result = null;
        try {
            ListOperations<Serializable, Object> operations = redisTemplate.opsForList();
            result = operations.range(key, 0, -1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 查询队列 List的长度
     *
     * @param key
     * @return
     */
    public Long llen(final String key) {
        Long result = null;
        try {
            ListOperations<Serializable, Object> operations = redisTemplate.opsForList();
            result = operations.size(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 发送消息
     *
     * @param channel
     * @param message
     * @return
     */
    public boolean sendMessage(String channel, Object message) {
        boolean result = false;
        try {
            redisTemplate.convertAndSend(channel, message);
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            redisTemplate.multi();
            redisTemplate.exec();
            RedisConnectionUtils.unbindConnection(redisTemplate.getConnectionFactory());
        }
        return result;
    }

}
