package cn.lantian.base;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author onlyo
 * @since 2019/4/16 22:20
 */
public class ExcutorTest {
    static
    Thread t1 = new Thread(() -> {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("thread1");
    });


    static
    Thread t2 = new Thread(() -> {
        System.out.println("thread2");
    });


    static
    Thread t3 = new Thread(() -> {
        System.out.println("thread3");
    });

    public static void main(String[] args) {
        ExecutorService es = Executors.newSingleThreadExecutor();
        es.submit(t1);
        es.submit(t2);
        es.submit(t3);

    }
}
