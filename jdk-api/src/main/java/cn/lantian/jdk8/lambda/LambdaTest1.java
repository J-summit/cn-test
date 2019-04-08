package cn.lantian.jdk8.lambda;

import cn.lantian.jdk8.EntityTest;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author onlyo
 * @since 2019/3/6 21:15
 */
public class LambdaTest1 {

    public static void main(String[] args) {
        Optional.ofNullable("").map(a -> a.getBytes()).orElse(null);
        String b = "name";

        EntityTest em =    method((e1) -> {
            EntityTest e = new EntityTest();
            e.setName(e1);
            return e;
        }, b);
        System.out.println(em);
        EntityTest eCons = new EntityTest();
        method1((t)->eCons.setName(t), "name1", eCons);
        System.out.println(eCons);
    }

    public static <R, T> T method(Function<R, T> function, R a) {
        return function.apply(a);
    }

    public static <R, T> void method1(Consumer<R> function, R a,T obj ) {
         function.accept(a);
    }
}
