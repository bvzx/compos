import base.SpringTest;
import io.bvzx.service.AppConfig;
import io.bvzx.service.AppContext;
import io.bvzx.service.util.Logs;

/**
 * Created by 73992 on 2016/7/1.
 */
public class SpringAnnoValueTest extends SpringTest {


    @Override
    public void measure() {
        Logs.log(AppContext.getBean("appConfig",AppConfig.class).appVersion);
        Logs.log(AppContext.getBean("appConfig",AppConfig.class).env);
        Logs.log(AppContext.getBean("appConfig",AppConfig.class).isDevMode);
        Logs.log(AppContext.getBean("appConfig",AppConfig.class).isPrdMode);
        Logs.log(AppContext.getBean("appConfig",AppConfig.class).isTestMode);
        Logs.log(AppContext.getBean("appConfig",AppConfig.class).sslUrl);
    }
}
