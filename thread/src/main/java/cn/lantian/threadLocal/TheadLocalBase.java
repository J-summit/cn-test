package cn.lantian.threadLocal;

import java.lang.ref.WeakReference;

/**
 * @author onlyo
 * @see ThreadLocal
 * @since 2019/1/17 20:31
 */
public class TheadLocalBase {

    public static void main(String[] args) throws InterruptedException {
        //weakRef();


        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        threadLocal.set("1");
        threadLocal.get();

        Thread t = new Thread();
    }

    /**
     * 弱引用
     */
    private static void weakRef() {
        WeakReference<Object> wr = new WeakReference<>(new Object());
        String a = "test2";
        System.gc();
        System.out.println(wr.get());
        System.out.println(a);
    }
}
