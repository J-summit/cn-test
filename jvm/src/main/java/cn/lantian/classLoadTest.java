package cn.lantian;

/**
 * @author onlyo
 * @since 2019/3/21 21:34
 */
public class classLoadTest {
    {
        System.out.println("1");
    }
    private String a;
    static {
        System.out.println(3);
    }

    public classLoadTest() {
        System.out.println("2");
    }
}
