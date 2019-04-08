package cn.summint;

import java.io.*;

/**
 * @author onlyo
 * @since 2019/4/3 21:25
 */
public class SeriableTest {

    public static void main(String[] args) {
        doSerializeStudent();
        Student.a = "222";
        Student s = unSerializeStudent();
        System.out.println(s.a);

    }

    public static void doSerializeStudent() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("student")));
            Student s = new Student();
            s.setAge(18);
            s.setName("summit");
            oos.writeObject(s);
            oos.flush();

            s.setName("summit1");
            oos.writeObject(s);
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Student unSerializeStudent() {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("student")));
            try {
                Student s = (Student) ois.readObject();
                System.out.println(s);

                Student s1 = (Student) ois.readObject();
                System.out.println(s1);
                return s;
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
            ois.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
