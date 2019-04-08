package cn.lansky.设计模式.策略;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author onlyo
 * @since 2019/3/19 19:36
 */
public class ArraysTest {
    public static void main(String[] args) {
//        List<BigDecimal> list = Arrays.asList(new BigDecimal("111.2"),new BigDecimal("111.1"), new BigDecimal(222), new BigDecimal(333));
//        Collections.sort(list, Comparator.naturalOrder());
//        System.out.println(list);

        List<Atest> l1 = new ArrayList<>();
        l1.add(new Atest(new BigDecimal("11")));
        l1.add(new Atest(new BigDecimal("12")));
        for (int i =0;i<l1.size()-1;i++) {
            System.out.println(1);
        }
        Collections.sort(l1,(b1,b2)->{
            return b2.getB1().compareTo(b1.getB1());
        });

        System.out.println(l1);


    }
}
