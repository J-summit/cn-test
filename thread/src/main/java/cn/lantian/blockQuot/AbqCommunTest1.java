package cn.lantian.blockQuot;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author onlyo
 * @since 2019/1/27 10:40
 */
public class AbqCommunTest1 {

    public static void main(String[] args) throws InterruptedException {
        BlockQ1 bq = new BlockQ1();

        new Thread(
                new Runnable() {

                    @Override
                    public void run() {

                        for (int i = 1; i <= 10; i++) {
                            try {
                                bq.sub(i);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }

                    }
                }
        ).start();

        for (int i = 1; i <= 10; i++) {
            bq.main(i);
        }
    }

    static class BlockQ1 {
        BlockingQueue bq1 = new ArrayBlockingQueue<Integer>(1);
        BlockingQueue bq2 = new ArrayBlockingQueue<Integer>(1);
        {
            try {
                bq2.put(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        public void sub(int i) throws InterruptedException {
            bq1.put(1);
            for(int j=1;j<=5;j++){
                System.out.println("sub " + j + ",number: " + i);
            }
            bq2.take();
        }

        public void main(int i) throws InterruptedException {
            bq2.put(1);
            for(int j=1;j<=5;j++){
                System.out.println("main " + j + ",number: " + i);
            }
            bq1.take();
        }

    }
}
