package cn.lansky.demo;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author onlyo
 * @since 2019/7/16 21:36
 */
public interface BTest<T> {

     default void test() throws IllegalAccessException, InstantiationException {
        Type[] types =  this.getClass().getGenericInterfaces();
        ParameterizedType parameterized = (ParameterizedType) types[0];
        Class<Test> clazz = (Class<Test>) parameterized.getActualTypeArguments()[0];
    }
}
