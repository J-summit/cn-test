package cn.lantian.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author onlyo
 * @since 2019/1/30 20:01
 */
@RestController
@Slf4j
public class ThreadPoolController {


    @Autowired
    private ThreadPoolTaskExecutor getThreadPool;

    @GetMapping("thread")
    public void threadTest() {
        getThreadPool.execute(() ->
        {
            System.out.println(Thread.currentThread().getName() + ":thread pool");

            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
