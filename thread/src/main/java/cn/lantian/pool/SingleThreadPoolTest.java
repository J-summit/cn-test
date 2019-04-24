package cn.lantian.pool;

import ch.qos.logback.core.util.TimeUtil;
import io.micrometer.core.instrument.util.TimeUtils;

import java.util.concurrent.*;

/**
 * @author onlyo
 * @since 2019/4/21 22:14
 */
public class SingleThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.execute(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println("execute..异步");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("ok 11");

        es.submit(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println("execute..同步");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println("ok 22");

    }
}
