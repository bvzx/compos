package io.bvzx.redis;

import com.sun.corba.se.spi.ior.ObjectKey;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * todo
 *
 * @author wugaoda
 * @Description: (类职责详细描述, 可空)
 * @ClassName: RedisDao
 * @date 2016年06月30日 11:26
 * @Copyright (c) 2015-2020 by caitu99
 */
 interface RedisDao {
    
    
     void delete(Object key);

     void delete(Collection keys);

     Boolean expire(Object key, long timeout, TimeUnit unit);

    Boolean batchExpire(Collection keys,long timeout,TimeUnit unit);

     Boolean hasKey(Object key);

     void rename(Object oldKey, Object newKey);

    Object setOpsString(Object key,Object value);

    Object getOpsString(Object key);

    <T> void setOpsList(Object key, List<T> values);

    <T> List<T> getOpsList(Object key);

    <K,V> void setOpsHash(Object key, Map<K,V> values);

    Object getOpsHash(Object key);


}
