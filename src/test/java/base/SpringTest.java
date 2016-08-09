package base;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * todo
 *
 * @author wugaoda
 * @Description: (类职责详细描述, 可空)
 * @ClassName: WinningRsult
 * @date 2016年07月01日 11:20
 * @Copyright (c) 2015-2020 by caitu99
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring/*.xml")
@ActiveProfiles("dev")
public abstract class SpringTest {
    @Test
    public abstract void measure() ;
}
