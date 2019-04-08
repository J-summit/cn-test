package cn.lansky.设计模式.委派;

/**
 * @author onlyo
 * @since 2019/3/18 21:36
 */
public class Dispatcher implements IDetegate {
    IDetegate iDetegate;

    Dispatcher(IDetegate iDetegate) {
        this.iDetegate = iDetegate;
    }

    @Override
    public void doing() {
        this.iDetegate.doing();

    }
}
