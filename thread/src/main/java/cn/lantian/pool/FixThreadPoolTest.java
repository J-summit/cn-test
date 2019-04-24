package cn.lantian.pool;

import java.util.concurrent.Executors;

/**
 * @author onlyo
 * @since 2019/4/21 22:15
 */
public class FixThreadPoolTest {
    public static void main(String[] args) {
        Executors.newFixedThreadPool(2);
    }
}
