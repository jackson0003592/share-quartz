package com.suiyi.sharequartz.jobconfig;

import com.suiyi.sharequartz.spring.SpringJob;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class JobInit {

    @Autowired
    Scheduler scheduler;

    @PostConstruct
    public void dataSource(){

    }

    @PostConstruct
    public void initJob() throws Exception {
        JobDetail detail = JobBuilder.newJob(SpringJob.class).withIdentity("spring job").build();
        Trigger trigger = TriggerBuilder.newTrigger().withSchedule(SimpleScheduleBuilder.repeatSecondlyForever(5)).startNow().build();

        try {
            scheduler.scheduleJob(detail, trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

}
