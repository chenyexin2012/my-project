package com.holmes.springcloud.test.hystrix;

import com.netflix.hystrix.*;
import org.junit.After;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class HystrixCommandTest {

    @Test
    public void test() {

        for (int i = 0; i < 10; i++) {
            HelloHystrixCommand helloHystrixCommand = new HelloHystrixCommand();
            System.out.println(helloHystrixCommand.execute());
            // 只能执行一次 com.netflix.hystrix.exception.HystrixRuntimeException: HelloHystrixCommand command executed multiple times - this is not permitted.
            // 重复执行需要重新创建对象
            // System.out.println(helloHystrixCommand.execute());
        }
    }

    @Test
    public void testConfig() {

        // 线程池配置
        HystrixThreadPoolProperties.Setter threadPoolPropertiesSetter = HystrixThreadPoolProperties.Setter()
                // 核心线程数，默认值10
                .withCoreSize(8)
                // 最大线程数，默认值10
                .withMaximumSize(32)
                // 作业队列的最大值
                // 值为-1，那么使用SynchronousQueue，否则正数将会使用LinkedBlockingQueue。
                .withMaxQueueSize(1000)
                // 非核心线程存活时间，默认值-1，表示不过期
                .withKeepAliveTimeMinutes(30)
                // 设置队列拒绝请求的阀值，即使队列没有到达最大值，也拒绝，默认值5
                .withQueueSizeRejectionThreshold(10)
                // 允许扩充至最大线程数，为false则maximumSize不作用，默认值false
                .withAllowMaximumSizeToDivergeFromCoreSize(true)
                // 统计的时间，默认10000
                .withMetricsRollingStatisticalWindowInMilliseconds(10000)
                // 每个滑动窗口被拆分成多少个bucket，默认10
                .withMetricsRollingStatisticalWindowBuckets(10);

        // 熔断参数配置
        HystrixCommandProperties.Setter commandPropertiesSetter = HystrixCommandProperties.Setter()
                ////////////////////////////////////////////////////////////////////////////////
                // 熔断配置
                // 1. 是否强制启用熔断器，一般没什么用
                .withCircuitBreakerForceOpen(false)
                // 2. 是否强制关闭熔断器，一般没什么用
                .withCircuitBreakerForceClosed(false)
                // 3. 是否启动熔断器
                .withCircuitBreakerEnabled(true)
                // 4. 一个采样窗口中失败率超过此值，则会打开熔断器
                .withCircuitBreakerErrorThresholdPercentage(50)
                // 5. 在进行失败率判断之前，一个采样周期内必须进行至少N个请求才能进行采样统计，保证有足够的采样
                .withCircuitBreakerRequestVolumeThreshold(50)
                // 6. 熔断后的重试时间窗口，且在该时间窗口内只允许一次重试。
                .withCircuitBreakerSleepWindowInMilliseconds(5000)
                ////////////////////////////////////////////////////////////////////////////////
                // 并发控制
                // 1. 线程隔离方式（信号量隔离或线程池隔离）
                .withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.SEMAPHORE)
                // 2. 控制并发的信号量数量
                .withExecutionIsolationSemaphoreMaxConcurrentRequests(10)
                // 3. 是否允许超时
                .withExecutionTimeoutEnabled(true)
                // 4. 执行的超时时间
                .withExecutionTimeoutInMilliseconds(50000)
                // 5. 发生超时是否中断
                .withExecutionIsolationThreadInterruptOnTimeout(true)
                // 6. 取消调用的情况下是否中断
                .withExecutionIsolationThreadInterruptOnFutureCancel(false)
                ////////////////////////////////////////////////////////////////////////////////
                // 命令降级配置
                // 1. 是否允许降级
                .withFallbackEnabled(true)
                // 2. 最大并发降级请求处理上限，超过此上限，降级逻辑不会执行并且会抛出一个异常
                .withFallbackIsolationSemaphoreMaxConcurrentRequests(10)
                ////////////////////////////////////////////////////////////////////////////////
                // 度量统计(metrics)配置
                // 1. 滑动窗口持续时间
                .withMetricsRollingStatisticalWindowInMilliseconds(10000)
                // 2. 滑动窗口Bucket总数
                .withMetricsRollingStatisticalWindowBuckets(10)
                // 3. 是否启用百分比
                .withMetricsRollingPercentileEnabled(true)
                // 4. 百分数计算使用的滑动窗口持续时间
                .withMetricsRollingPercentileWindowInMilliseconds(10000)
                // 5. 百分数计算使用的Bucket总数
                .withMetricsRollingPercentileWindowBuckets(10)
                // 6. 百分数计算使用的Bucket容量
                .withMetricsRollingPercentileBucketSize(10)
                // 7. 健康状态快照收集的周期
                .withMetricsHealthSnapshotIntervalInMilliseconds(10000)
                ////////////////////////////////////////////////////////////////////////////////
                // 请求上下文配置
                // 1. 是否启用请求日志
                .withRequestLogEnabled(false)
                // 2. 是否启用请求缓存
                .withRequestCacheEnabled(false);

        HystrixCommand.Setter
                .withGroupKey(HystrixCommandGroupKey.Factory.asKey("helloHystrixCommand"))
                .andCommandKey(HystrixCommandKey.Factory.asKey("commandKey"))
                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("hystrix-command"))
                .andThreadPoolPropertiesDefaults(threadPoolPropertiesSetter)
                .andCommandPropertiesDefaults(commandPropertiesSetter);
    }

    /**
     * 测试线程配置
     */
    @Test
    public void testThread() {

        // 线程池配置
        HystrixThreadPoolProperties.Setter threadPoolPropertiesSetter =
                HystrixThreadPoolProperties.Setter()
                        .withCoreSize(4)
                        .withMaximumSize(8)
                        .withAllowMaximumSizeToDivergeFromCoreSize(true)
                        .withMaxQueueSize(-1)
                        .withQueueSizeRejectionThreshold(10);

        HystrixCommand.Setter hystrixCommandSetter = HystrixCommand.Setter
                .withGroupKey(HystrixCommandGroupKey.Factory.asKey("helloHystrixCommand"))
                .andCommandKey(HystrixCommandKey.Factory.asKey("commandKey"))
                .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("hello-hystrix-command-thread"))
                .andThreadPoolPropertiesDefaults(threadPoolPropertiesSetter);

        for (int i = 0; i < 100; i++) {
            HelloHystrixCommand helloHystrixCommand = new HelloHystrixCommand(hystrixCommandSetter);
            helloHystrixCommand.execute();
        }
    }

    @After
    public void after() throws InterruptedException {
        TimeUnit.SECONDS.sleep(10);
    }
}
