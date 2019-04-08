package cn.lantian.jdk8;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author onlyo
 * @since 2019/2/26 21:33
 */
public class CallAbleTest {

    public static void main(String[] args) {


        ExecutorService service = Executors.newFixedThreadPool(1);
        Future<String> future = service.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "future";
            }
        });
    }
}
