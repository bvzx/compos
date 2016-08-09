import base.SpringTest;
import io.bvzx.AppContext;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import util.LogUtils;

/**
 * Created by 73992 on 2016/6/30.
 */
public class AppContextTest extends SpringTest{

    @Autowired
    AppContext appContext;

    @Test
    public void ApplicationContextIsValidTest(){
        LogUtils.println(appContext.getBean("appName",String.class));
    }

    @Override
    public void measure() {

    }
}
