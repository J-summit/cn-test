package cn.lantian.synchronizedCollect;

import java.util.concurrent.TimeUnit;

/**
 * @author onlyo
 * @since 2019/4/18 19:11
 */
public class SyncClazz {

    public synchronized void test() throws InterruptedException {
        System.out.println("+++++");
        TimeUnit.SECONDS.sleep(2);
    }

    public void test1() throws InterruptedException {
        synchronized (SyncClazz.class) {
            System.out.println("+++++");
            TimeUnit.SECONDS.sleep(3);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            SyncClazz s1 =new SyncClazz();
            try {
                s1.test1();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        SyncClazz s2 =new SyncClazz();
        s2.test1();
    }
}
