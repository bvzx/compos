package mongodb;

import com.alibaba.fastjson.JSON;
import io.bvzx.service.mongdb.domain.MatchComment;
import io.bvzx.service.util.NosqlManager;
import io.bvzx.service.web.domain.Carmen;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * todo
 *
 * @author wugaoda
 * @Description: (类职责详细描述, 可空)
 * @ClassName: WinningRsult
 * @date 2016年06月22日 18:13
 * @Copyright (c) 2015-2020 by caitu99
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class MongodbTest {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    public void mongodbTest(){
        MatchComment matchComment=new MatchComment();
        matchComment.setContent("今天天气很好");
        matchComment.setCreatTime((int) (System.currentTimeMillis()/1000));
        matchComment.setMatchId(1000);
        matchComment.setUserId(233);
        mongoTemplate.insert(matchComment);
        Query q=new Query();
        Criteria c=new Criteria();
        c.and("matchId").is(1000);
        q.addCriteria(c);
        MatchComment m=mongoTemplate.findOne(q,MatchComment.class);
        MatchComment reply=new MatchComment();
        reply.setCreatTime((int) (System.currentTimeMillis()/1000));
        reply.setUserId(234);
        reply.setMatchId(1000);
        reply.setContent("鸟儿呱呱叫");
        m.setReply(reply);
        mongoTemplate.insert(m);
        MatchComment m2=mongoTemplate.findById("576b3c1535b56730d3551a84",MatchComment.class);
        MatchComment reply2=new MatchComment();
        reply2.setCreatTime((int) (System.currentTimeMillis()/1000));
        reply2.setUserId(234);
        reply2.setMatchId(1000);
        reply2.setContent("吵死人了撸！");
        m2.getReply().setReply(reply2);
        mongoTemplate.insert(m2);

    }

    @Test
    public void redisTest(){
        redisTemplate.getConnectionFactory().getConnection().flushAll();
        Carmen carmen=new Carmen();
        carmen.setApiId(10001);
        carmen.setCreateTime(System.currentTimeMillis()/1000);
        carmen.setCreator("mp_z1001");
        carmen.setEnv(0);
        carmen.setModifyTime(System.currentTimeMillis()/1000);
        carmen.setServiceMethodId(1010);
        redisTemplate.opsForValue().set("carman:api:method:mapping:2", JSON.toJSONString(carmen));
    }


    @Test
    public void nosqlMangerTest(){
        NosqlManager nosqlManager=NosqlManager.createRedis();
        NosqlManager nosqlManager1=NosqlManager.createMongoDB();
        NosqlManager nosqlManager2=NosqlManager.createRedis();
        NosqlManager nosqlManager3=NosqlManager.createRedis();
        NosqlManager nosqlManager4=NosqlManager.createRedis();
        NosqlManager nosqlManager5=NosqlManager.createRedis();
        NosqlManager nosqlManager6=NosqlManager.createRedis();
        NosqlManager nosqlManager7=NosqlManager.createRedis();
        NosqlManager nosqlManager8=NosqlManager.createRedis();
        System.out.println(nosqlManager.getNosqlManagerCount());
    }

    @Test
    public void bwanwrapper(){
        BeanWrapper beanWrapper=new BeanWrapperImpl(new Carmen());
        BeanWrapper beanWrapper1=new BeanWrapperImpl(new Carmen());
        Carmen carmen= (Carmen) beanWrapper.getWrappedInstance();
        System.out.println(carmen.getApiId());
    }

}
