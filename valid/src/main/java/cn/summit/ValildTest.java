package cn.summit;

import java.math.BigDecimal;
import java.util.Collections;

/**
 * @author onlyo
 * @since 2019/6/19 10:15
 */
public class ValildTest {

    public static void main(String[] args) {

        PayRequestDto r = new PayRequestDto();
        r.setPayTime("11111111111111111111111111111111111111111111111");
        r.setNullTest("1");
        r.setAssertFalseTest(true);
        r.setAssertTest(true);

        r.setMaxTest("555555");
        r.setMinTest("4444");

        r.setNumber(9d);
        r.setNumber1("9");
        r.setNumber3("123456");
        r.setDigits(new BigDecimal("222.4"));

        r.setLengthTest("sds1");

        r.setCustomTest("str1");
        ValidationUtils.validate(r);
    }
}
