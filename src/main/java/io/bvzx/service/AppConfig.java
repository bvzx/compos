package io.bvzx.service;

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

    @Value("app.version")
    public String appVersion;

    @Value("env")
    public int env;

    @Value("is.dev.mode")
    public boolean isDevMode;

    @Value("is.test.mode")
    public boolean isTestMode;

    @Value("is.product.mode")
    public boolean isPrdMode;

    @Value("ssl.url")
    public boolean sslUrl;

}
