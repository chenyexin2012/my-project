package com.holmes.springcloud.test.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * 模拟超时任务
 */
@Slf4j
public class TimeoutTestHystrixCommand extends HystrixCommand<String> {

    public TimeoutTestHystrixCommand() {
        super(HystrixCommandGroupKey.Factory.asKey("TimeoutTestHystrixCommand"));
    }

    @Override
    public String run() throws Exception {

        log.info("{} started........", Thread.currentThread().getName());

        // 模拟超时
        TimeUnit.SECONDS.sleep(5);

        log.info("{} finished........", Thread.currentThread().getName());
        return "SUCCESS";
    }
}
