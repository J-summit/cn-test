package cn.lansky.demo;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author onlyo
 * @since 2019/7/16 21:36
 */
public class ATest implements BTest<Test> {



    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        ATest a = new ATest();
        a.test();
    }


}
