package io.bvzx.service.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by lss on 16-8-9.
 */


@Component
public class ScheduleJob {



    @Scheduled(cron = "*/1 * * * * ?")
    public void test(){
        System.out.println("cron  !!!!~~~~");
    }
}
