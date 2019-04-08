package cn.lantian.jdk8.computerfuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author onlyo
 * @since 2019/2/27 20:25
 */
public class ComputerTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        //1 同步操作
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        completableFuture.complete(" hello word");
        System.out.println(completableFuture.get());


        //2 异步操作
        CompletableFuture c1 = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            System.out.println("runAsync");
        });
        //阻塞操作


        c1.get();
        System.out.println("end=================");

// 3 真正的异步

        CompletableFuture<String> c2 = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName());
            return " 3.++++ok";
        });
    }
}
