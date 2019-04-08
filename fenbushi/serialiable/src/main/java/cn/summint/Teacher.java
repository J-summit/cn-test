package cn.summint;

import lombok.Data;

import java.io.*;

/**
 * @author onlyo
 * @since 2019/4/4 9:49
 */
@Data
public class Teacher implements Serializable {
    private static final long serialVersionUID = 233977036409248986L;
    private String name;

    private Student student;

    public Object deepClone() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bao = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bao);
        oos.writeObject(this);


        System.out.println("大小:"+bao.toByteArray().length);
        ByteArrayInputStream bai = new ByteArrayInputStream(bao.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bai);
        Object obj = ois.readObject();

        oos.close();
        ois.close();
        return obj;
    }
}
