package io.bvzx.redis;

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


    /**
     * 删除指定key
     * @param key
     */
    @Override
    public void delete(Object key) {
        redisTemplate.delete(key);
    }

    /**
     * 批量删除key
     * @param keys
     */
    @Override
    public void delete(Collection keys) {
        redisTemplate.delete(keys);
    }

    /**
     * 设置过时时间
     * @param key 键
     * @param timeout 过时时间
     * @param unit 时间单位
     * @return
     */
    @Override
    public Boolean expire(Object key, long timeout, TimeUnit unit) {
        return redisTemplate.expire(key, timeout, unit);
    }

    /**
     * 批量设置过时时间
     * @param keys 键
     * @param timeout 过时时间
     * @param unit 时间单位
     * @return
     */
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

    /**
     * 是否包含key值
     * @param key 键
     * @return
     */
    @Override
    public Boolean hasKey(Object key) {
        return redisTemplate.hasKey(key);
    }

    /**
     * 重命名key
     * @param oldKey 被替换的key
     * @param newKey 新key名
     */
    @Override
    public void rename(Object oldKey, Object newKey) {
        redisTemplate.rename(oldKey, newKey);
    }

    /**
     * 字符串
     * @param key
     * @param value
     * @return
     */
    @Override
    public Object setOpsString(Object key, Object value) {
        return valueOperations.getAndSet(key, value);
    }

    /**
     *
     * @param key
     * @return
     */
    @Override
    public Object getOpsString(Object key) {
        return valueOperations.get(key);
    }

    /**
     *
     * @param key
     * @return
     */
    @Override
    public <T> void setOpsList(Object key, List<T> values) {
        final int[] arrIndex = {0};
        values.forEach(
                (singleVal) -> {
                    listOperations.set(key, arrIndex[0]++, singleVal);
                }
        );
    }

    /**
     *
     * @param key
     * @return
     */
    @Override
    public <T> List<T> getOpsList(Object key) {
        Long arrLen = listOperations.size(key);
        List arrayList = Lists.newArrayList();
        for (int i = 0; i < arrLen; i++) {
            arrayList.add(listOperations.index(key, arrLen));
        }
        return arrayList;
    }

    /**
     *
     * @param key
     * @return
     */
    @Override
    public <K, V> void setOpsHash(Object key, Map<K, V> values) {
        hashOperations.putAll(key, values);
    }

    /**
     *
     * @param key
     * @return
     */
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
