package cn.lansky.设计模式.工厂.simple;

/**
 * @author onlyo
 * @since 2019/4/20 23:44
 */
public enum CarImpl {
    Audi("cn.lansky.设计模式.工厂.Audi"),
    ;

    private String clazzUrl;

    CarImpl(String clazzUrl) {
        this.clazzUrl = clazzUrl;
    }

    public String getClazzUrl() {
        return clazzUrl;
    }

    public void setClazzUrl(String clazzUrl) {
        this.clazzUrl = clazzUrl;
    }
}
