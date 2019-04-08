package cn.lantian.jdk8;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * @author onlyo
 * @since 2019/2/26 21:41
 */
public class ForkJoinTest {

    public static void main(String[] args) {
        System.out.println(ForkJoinPool.commonPool().getParallelism());

        ForkJoinPool forkJoinPool  = new ForkJoinPool();
        forkJoinPool.invoke(new RecursiveAction() {
            @Override
            protected void compute() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        forkJoinPool.shutdown();
    }
}
