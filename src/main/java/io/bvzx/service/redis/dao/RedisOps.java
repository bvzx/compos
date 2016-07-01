package io.bvzx.service.redis.dao;

import io.bvzx.service.redis.dao.RedisDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.concurrent.TimeUnit;

/**
 * todo
 *
 * @author wugaoda
 * @Description: (类职责详细描述, 可空)
 * @ClassName: RedisOps
 * @date 2016年06月21日 09:13
 * @Copyright (c) 2015-2020 by caitu99
 */
@Component
public class RedisOps implements RedisDao {

    @Autowired
    RedisTemplate redisTemplate;

    public void delete(Object key) {
        redisTemplate.delete(key);
    }

    public void delete(Collection keys) {
        redisTemplate.delete(keys);
    }

    public Boolean expire(Object key, long timeout, TimeUnit unit) {
        return redisTemplate.expire(key, timeout, unit);
    }

    public Boolean hasKey(Object key) {
        return redisTemplate.hasKey(key);
    }
}
