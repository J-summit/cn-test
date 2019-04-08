package cn.summint.clone;

import cn.summint.Student;
import cn.summint.Teacher;

import java.io.IOException;

/**
 * @author onlyo
 * @since 2019/4/4 9:49
 */
public class DeepCloneTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Teacher t = new Teacher();
        t.setName("summit");
        Student s = new Student();
        s.setName("aaa");
        t.setStudent(s);

        Teacher t1 = (Teacher) t.deepClone();

        System.out.println(t==t1);
        t1.setName("summit1");
        System.out.println(t1);
        System.out.println(t);

    }
}
