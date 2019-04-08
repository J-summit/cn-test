package cn.lansky.设计模式.委派;

/**
 * @author onlyo
 * @since 2019/3/18 21:37
 */
public class Test {

    public static void main(String[] args) {
        Dispatcher dispatcher = new Dispatcher(new TargetA());
        dispatcher.doing();
    }
}
