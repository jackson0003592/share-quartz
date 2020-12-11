package com.suiyi.sharequartz.jobconfig;

import com.suiyi.sharequartz.spring.SpringJob;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

//@Component
public class JobClusterInit {

    @Autowired
    Scheduler scheduler;

    @PostConstruct
    public void dataSource() {

    }

    @PostConstruct
    public void initJob() throws Exception {
        JobDetail detail1 = JobBuilder.newJob(SpringJob.class).withIdentity("job-1").build();
        Trigger trigger1 = TriggerBuilder.newTrigger().withIdentity("trigger-1")
                .startNow().withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(5)).build();

        JobDetail detail2 = JobBuilder.newJob(SpringJob.class).withIdentity("job-2").build();
        Trigger trigger2 = TriggerBuilder.newTrigger().withIdentity("trigger-2")
                .startNow().withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(5)).build();

        JobDetail detail3 = JobBuilder.newJob(SpringJob.class).withIdentity("job-3").build();
        Trigger trigger3 = TriggerBuilder.newTrigger().withIdentity("trigger-3")
                .startNow().withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(5)).build();

        scheduler.scheduleJob(detail1, trigger1);
        scheduler.scheduleJob(detail2, trigger2);
        scheduler.scheduleJob(detail3, trigger3);
    }
}
