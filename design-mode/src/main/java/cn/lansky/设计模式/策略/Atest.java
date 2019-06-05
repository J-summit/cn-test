package cn.lansky.设计模式.策略;

import java.math.BigDecimal;

/**
 * @author onlyo
 * @since 2019/3/20 11:21
 */
public class Atest {
    private BigDecimal b1;

    public Atest(BigDecimal b1) {
        this.b1 = b1;
    }

    public BigDecimal getB1() {
        return b1;
    }

    public void setB1(BigDecimal b1) {

        this.b1 = b1;
    }
}
