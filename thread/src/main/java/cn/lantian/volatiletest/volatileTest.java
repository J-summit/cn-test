package cn.lantian.volatiletest;

import lombok.Data;

/**
 * @author onlyo
 * @since 2019/1/20 11:08
 */
@Data
public class

volatileTest {

    private Integer a;

    public static void main(String[] args) throws InterruptedException {

        volatileTest v = new volatileTest();
        v.setA(4);
        Thread.sleep(1000);

        new Thread(() -> {
            v.setA(3);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("sub1:" + v.getA());
        }).start();


        new Thread(() -> {
            v.setA(2);

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("sub2:" + v.getA());
        }).start();

        System.out.println("main:" + v.getA());
    }
}
