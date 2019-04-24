package cn.lantian.base;

import java.util.concurrent.TimeUnit;

/**
 * @author onlyo
 * @since 2019/4/16 16:07
 */
public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("thread1");

        });
        t1.start();
        t1.join();
        Thread t2 = new Thread(() -> {
            System.out.println("thread2");

        });
        t2.start();
        t2.join();

        Thread t3 = new Thread(() -> {
            System.out.println("thread3");

        });
        t3.start();
        t3.join();

    }
}
