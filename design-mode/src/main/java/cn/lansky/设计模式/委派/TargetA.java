package cn.lansky.设计模式.委派;

/**
 * @author onlyo
 * @since 2019/3/18 21:34
 */
public class TargetA implements IDetegate {
    @Override
    public void doing() {
        System.out.println("A");
    }
}
