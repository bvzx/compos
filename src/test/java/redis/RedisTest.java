package redis;

import base.SpringTest;
import io.bvzx.RedisKey;
import io.bvzx.redis.RedisOps;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * todo
 *
 * @author wugaoda
 * @Description: (类职责详细描述, 可空)
 * @ClassName: WinningRsult
 * @date 2016年07月15日 14:05
 * @Copyright (c) 2015-2020 by caitu99
 */
public class RedisTest extends SpringTest {

    @Autowired
    RedisOps redisOps;

    @Override
    public void measure()  {
        String redisKey=String.format(RedisKey.USER_ACCOUNT_INFO,"10001");
        redisOps.setOpsString(redisKey,"1");
    }
}
