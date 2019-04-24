package cn.lantian.Synchroi;

/**
 * @author onlyo
 * @since 2019/4/17 9:48
 */
public class SynchroiTest {
    public void test() throws InterruptedException {
        synchronized (SynchroiTest.class) {

        }

    }

    public static void main(String[] args) {
        Integer a = 1, b = 2;
        Integer c = a;
        a = b;
        b = c;
      //  swap(a, b);
        System.out.println(a + "   " + b);
    }

    public static void swap(Integer a, Integer b) {
        Integer c = a;
        a = b;
        b = c;
    }
}
