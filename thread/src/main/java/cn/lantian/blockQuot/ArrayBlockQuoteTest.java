package cn.lantian.blockQuot;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @author onlyo
 * @since 2019/1/27 10:20
 */
public class ArrayBlockQuoteTest {
    public static void main(String[] args) {

        /**
         * Throws exception     sepcial value          Blocks           Times out
         * add(e)                 offer(e)            put(e)            offer(e,times,unit)
         * remove()                 poll()            take()            poll(time,unit)
         *
         */
    }

    class BlockQ1{
        BlockingQueue bq1 = new ArrayBlockingQueue<Integer>(1);
        BlockingQueue bq2 = new ArrayBlockingQueue<Integer>(1);
    }
}
