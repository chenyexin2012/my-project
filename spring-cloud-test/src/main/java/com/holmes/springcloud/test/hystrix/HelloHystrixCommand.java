package com.holmes.springcloud.test.hystrix;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 *
 */
public class HelloHystrixCommand extends HystrixCommand<String> {

    protected HelloHystrixCommand() {
        super(HystrixCommandGroupKey.Factory.asKey("HelloHystrixCommand"));
    }

    @Override
    protected String run() throws Exception {

        System.out.println(Thread.currentThread().getName()  + " hello hystrix command");
        return "Hello";
    }
}
