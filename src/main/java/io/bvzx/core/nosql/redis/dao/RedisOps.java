package io.bvzx.core.nosql.redis.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * todo
 *
 * @author wugaoda
 * @Description: (类职责详细描述, 可空)
 * @ClassName: MongdbOperater
 * @date 2016年06月21日 09:13
 * @Copyright (c) 2015-2020 by caitu99
 */
@Component
public class RedisOps implements RedisDao{

    @Autowired
    RedisTemplate redisTemplate;



}
