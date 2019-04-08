package cn.lansky.设计模式.原型.simple;

/**
 * @author onlyo
 * @since 2019/3/19 19:54
 */
public class ProtoTypeTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        CloneMode mode = new CloneMode();
        mode.setName("hello");
        Integer a = new Integer(1);
        mode.setAge(a);


        CloneMode pt = (CloneMode) mode.clone();

        System.out.println(pt == mode);
        System.out.println(pt.getAge() + ":" + pt.getName());
        System.out.println(a == mode.getAge());


    }
}
