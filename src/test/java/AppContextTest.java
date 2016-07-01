import base.SpringTest;
import io.bvzx.service.AppContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by 73992 on 2016/6/30.
 */
public class AppContextTest extends SpringTest{

    @Autowired
    AppContext appContext;

    @Test
    public void ApplicationContextIsValidTest(){
        LogUtils.println(appContext.springcontext.getBean("appName").toString());
    }

}
