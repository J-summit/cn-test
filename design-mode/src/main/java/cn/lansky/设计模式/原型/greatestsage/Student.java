package cn.lansky.设计模式.原型.greatestsage;

import cn.lansky.设计模式.原型.simple.CloneMode;

import java.io.*;

/**
 * @author onlyo
 * @since 2019/3/19 20:00
 */
public class Student implements Cloneable, Serializable {

    public static void main(String[] args) {
        Student s = new Student();
        s.setId(1);
        CloneMode c = new CloneMode();
        c.setName("aa");

        s.setC(c);

        Student s1 = (Student) s.clone();

        System.out.println(s1.getId() == s.getId());
        System.out.println(s1.getC() == s.getC());
    }

    @Override
    public Object clone() {
        ByteArrayOutputStream bos = null;
        ObjectOutputStream oos = null;
        ByteArrayInputStream bis = null;
        ObjectInputStream ois = null;

        try {
            // 序列化
            bos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);

            //发序列话
            bis = new ByteArrayInputStream(bos.toByteArray());
            ois = new ObjectInputStream(bis);
            Student copy = (Student) ois.readObject();
            return copy;
        } catch (Exception var15) {
            var15.printStackTrace();
        } finally {
            try {
                bos.close();
                oos.close();
                bis.close();
                ois.close();
            } catch (IOException var14) {
                var14.printStackTrace();
            }

        }

        return null;
    }

    private CloneMode c;

    public CloneMode getC() {
        return c;
    }

    public void setC(CloneMode c) {
        this.c = c;
    }

    private String name;

    private String subject;

    private Integer id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
