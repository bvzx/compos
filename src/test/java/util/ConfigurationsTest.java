package util;

import base.SpringTest;
import io.bvzx.service.util.app.Configurations;
import org.junit.Test;

/**
 * todo
 *
 * @author wugaoda
 * @Description: (类职责详细描述, 可空)
 * @ClassName: WinningRsult
 * @date 2016年07月01日 10:58
 * @Copyright (c) 2015-2020 by caitu99
 */

public class ConfigurationsTest extends SpringTest {

    @Test
    public void test(){
        LogUtils.println(Configurations.getPropPaths()[0]);
        LogUtils.println(Configurations.getValue(null,"0"));
    }

    @Override
    public void measure() {

    }
}
