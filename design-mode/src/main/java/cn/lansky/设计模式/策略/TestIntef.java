package cn.lansky.设计模式.策略;

import java.util.function.Consumer;

/**
 * @author onlyo
 * @since 2019/3/12 22:24
 */
public class TestIntef<T> {
    public static void main(String[] args) {
        TestIntef<String> t = new TestIntef();
        t.hanshu((a)->{
            System.out.println(a.toUpperCase());
        }, "str");
    }

    public void test() {
        this.hanshu(( a)->{
            System.out.println(a.toUpperCase());
        }, "str");
    }

    public void hanshu(Consumer<String> c, String obj) {

        c.accept(obj);
    }
}
