package cn.lantian;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @author onlyo
 * @since 2019/1/29 15:23
 */
public class OomTest extends classLoadTest {

    public static void main(String[] args) {
//        List<OomTest> list = new ArrayList<>();
//        while (true) {
//            list.add(new OomTest());
//        }
        classLoadTest c = new OomTest();
        //  OomTest a = new classLoadTest();

        LocalDate b = LocalDate.now();
        LocalTime q = LocalTime.now();


        LocalDateTime ldt = LocalDateTime.now();
        LocalDateTime a = LocalDateTime.of(b, q);
        System.out.println( a.toLocalTime());
        System.out.println(ldt);
        System.out.println(a);


    }
}
