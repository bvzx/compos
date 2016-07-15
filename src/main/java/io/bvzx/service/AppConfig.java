package io.bvzx.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;

/**
 * todo
 *
 * @author wugaoda
 * @Description: (类职责详细描述, 可空)
 * @ClassName: AppConfig
 * @date 2016年06月30日 10:57
 * @Copyright (c) 2015-2020 by caitu99
 */
@Component
public class AppConfig {

    @Value("${app.version}")
    public String appVersion;

    @Value("${env}")
    public Integer env;

    @Value("${is.dev.mode}")
    public Boolean isDevMode;

    @Value("${is.test.mode}")
    public Boolean isTestMode;

    @Value("${is.product.mode}")
    public Boolean isPrdMode;

    @Value("${ssl.url}")
    public String sslUrl;

}
