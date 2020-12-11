package com.suiyi.sharequartz.spring;

import com.suiyi.sharequartz.service.HelloServiceImpl;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.Date;
import java.util.StringJoiner;

public class SpringJob extends QuartzJobBean {

    @Autowired
    private HelloServiceImpl helloService;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        StringJoiner outStr = new StringJoiner(" | ")
                .add("Spring Job ")
                .add(helloService.sayHello())
                .add(new Date().toString())
                .add(context.getJobDetail().getKey().getName());
        System.err.println(outStr);
    }
}
