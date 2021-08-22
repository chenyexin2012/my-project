package com.holmes.springcloud.test.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 *
 */
@Slf4j
public class HelloHystrixCommand extends HystrixCommand<String> {

    private static final Random RANDOM = new Random();

    public HelloHystrixCommand() {
        super(HystrixCommandGroupKey.Factory.asKey("HelloHystrixCommand"));
    }

    public HelloHystrixCommand(HystrixCommand.Setter setter) {
        super(setter);
    }

    @Override
    public String run() throws Exception {

        log.info("{} started........", Thread.currentThread().getName());

        // 模拟执行时间
        TimeUnit.MILLISECONDS.sleep(RANDOM.nextInt(500));

        log.info("{} finished........", Thread.currentThread().getName());
        return "HELLO";
    }
}
