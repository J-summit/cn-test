package cn.lantian.config;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author onlyo
 * @since 2019/1/30 16:23
 */
@Configuration
public class TaskExecutorConfig {

    @Bean
    public ThreadPoolTaskExecutor getThreadPool() {
        ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();
        pool.setCorePoolSize(2);
        pool.setMaxPoolSize(32);
        pool.setKeepAliveSeconds(100);
        //缓存队列满 新建线程
        // pool.setQueueCapacity(0);
        //  pool.setThreadNamePrefix("test2-");
        //ThreadFactoryBuilder
        pool.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        ThreadFactoryBuilder threadFactory = new ThreadFactoryBuilder();
        threadFactory.setUncaughtExceptionHandler(new ExceptHand());
        threadFactory.setNameFormat("google-gauava%d");

        pool.setThreadFactory(threadFactory.build());
        pool.initialize();
        return pool;
    }

    class ExceptHand implements Thread.UncaughtExceptionHandler {

        @Override
        public void uncaughtException(Thread t, Throwable e) {
            System.out.println("线程处理异常退出");
        }
    }
    /**
     * 给新创建的线程取名字、或者设置为守护线程、错误处理器等操作时,线程工厂的好处就提现出来
     * 不用ThreadFactoryBuilder的时候 我们这么写代码。我们每次要新建一个类来实现ThreadFactory,有点繁琐
     */

}
