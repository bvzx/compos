package io.bvzx.service.redis;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
    private RedisTemplate redisTemplate;


    private ValueOperations valueOperations;
    private ListOperations listOperations;
    private HashOperations hashOperations;
    private SetOperations setOperations;
    private ZSetOperations zSetOperations;


    @PostConstruct
    private void init() {
        valueOperations = redisTemplate.opsForValue();
        listOperations = redisTemplate.opsForList();
        hashOperations = redisTemplate.opsForHash();
        setOperations = redisTemplate.opsForSet();
        zSetOperations = redisTemplate.opsForZSet();
    }


    @Override
    public void delete(Object key) {
        redisTemplate.delete(key);
    }

    @Override
    public void delete(Collection keys) {
        redisTemplate.delete(keys);
    }

    @Override
    public Boolean expire(Object key, long timeout, TimeUnit unit) {
        return redisTemplate.expire(key, timeout, unit);
    }

    @Override
    public Boolean batchExpire(Collection keys, long timeout, TimeUnit unit) {
        final boolean[] retFlag = {true};
        keys.forEach((singleVal) -> {
            boolean ret = expire(singleVal, timeout, unit);
            if (!ret) {
                retFlag[0] = false;
            }
        });
        return retFlag[0];
    }

    @Override
    public Boolean hasKey(Object key) {
        return redisTemplate.hasKey(key);
    }

    @Override
    public void rename(Object oldKey, Object newKey) {
        redisTemplate.rename(oldKey, newKey);
    }

    @Override
    public Object setOpsString(Object key, Object value) {
        return valueOperations.getAndSet(key, value);
    }

    @Override
    public Object getOpsString(Object key) {
        return valueOperations.get(key);
    }

    @Override
    public <T> void setOpsList(Object key, List<T> values) {
        final int[] arrIndex = {0};
        values.forEach(
                (singleVal) -> {
                    listOperations.set(key, arrIndex[0]++, singleVal);
                }
        );
    }

    @Override
    public <T> List<T> getOpsList(Object key) {
        Long arrLen = listOperations.size(key);
        List arrayList = Lists.newArrayList();
        for (int i = 0; i < arrLen; i++) {
            arrayList.add(listOperations.index(key, arrLen));
        }
        return arrayList;
    }

    @Override
    public <K, V> void setOpsHash(Object key, Map<K, V> values) {
        hashOperations.putAll(key, values);
    }

    @Override
    public Object getOpsHash(Object key) {
        Set keySets = hashOperations.keys(key);
        Map maps = Maps.newHashMap();
        keySets.forEach(
                (singleKey) -> {
                    maps.put(singleKey, hashOperations.get(key, singleKey));
                }
        );
        return maps;
    }
}
