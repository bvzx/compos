package io.bvzx.core.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * todo
 *
 * @author wugaoda
 * @Description: (类职责详细描述, 可空)
 * @ClassName: WinningRsult
 * @date 2016年06月27日 09:06
 * @Copyright (c) 2015-2020 by caitu99
 */
public class NosqlManager {

    private static final int STATE_MONGODB=1;
    private static final int STATE_REDIS=2;

    @Autowired private MongoTemplate mongoTemplate;
    @Autowired private RedisTemplate redisTemplate;

    private final static AtomicInteger count=new AtomicInteger(0);

    private int state;

    private NosqlManager(int state){
        this.state=state;
    }

    public static NosqlManager createMongoDB(){
        count.incrementAndGet();
        return new NosqlManager(NosqlManager.STATE_MONGODB);
    }

    public static NosqlManager createRedis(){
        count.incrementAndGet();
        return new NosqlManager(NosqlManager.STATE_REDIS);
    }

    public int getNosqlManagerCount(){
        return count.intValue();
    }

    public String getName(){
        if (state==STATE_MONGODB){
            return "STATE_MONGODB";
        }else if (state==STATE_REDIS){
            return "STATE_REDIS";
        }else{
            throw new IllegalArgumentException("The state does not match");
        }
    }

}
