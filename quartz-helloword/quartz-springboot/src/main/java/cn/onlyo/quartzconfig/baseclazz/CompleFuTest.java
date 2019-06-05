package cn.onlyo.quartzconfig.baseclazz;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author onlyo
 * @since 2019/1/15 14:47
 */
public class CompleFuTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        CompletableFuture.completedFuture(get());
//
//        System.out.println("oko ok ok o");
        CompletableFuture future = CompletableFuture.completedFuture(1);
        CompletableFuture future1 = CompletableFuture.completedFuture(future);
        CompletableFuture future2 = CompletableFuture.completedFuture(future1);
        System.out.println(future2.get());
        System.out.println(future1.get());
        System.out.println(future.get());

    }

    public static String get() throws InterruptedException {
        Thread.sleep(10000);
        return "ok";
    }
}
