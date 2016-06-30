package io.bvzx;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * todo
 *
 * @author wugaoda
 * @Description: (类职责详细描述, 可空)
 * @ClassName: WinningRsult
 * @date 2016年06月30日 10:57
 * @Copyright (c) 2015-2020 by caitu99
 */
@Component
public class AppConfig {

    @Value("mongo.connectTimeout")
    public String connectTimeout;



}
