package cn.summint.compareSerialiable;

import cn.summint.Student;
import com.alibaba.fastjson.JSON;
import com.baidu.bjf.remoting.protobuf.Codec;
import com.baidu.bjf.remoting.protobuf.ProtobufProxy;
import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @author onlyo
 * @since 2019/4/4 10:57
 */
public class SerializeCpareTest {
    public static Student getStudent() {
        Student s = new Student();
        s.setName("summit");
        s.setAge(18);
        return s;
    }

    public static void main(String[] args) throws Exception {
        jackSonTest();

        fastJosn();
        protoBuf();

        hessionTest();

    }

    public static void jackSonTest() throws IOException {
        Student s = getStudent();

        ObjectMapper om = new ObjectMapper();
        byte[] writeBytes = null;
        Long start = System.currentTimeMillis();

        for (int i = 0; i < 10000; i++) {
            writeBytes = om.writeValueAsBytes(s);
        }

        System.out.println("jackJson序列化时间(ms):" + (System.currentTimeMillis() - start) + "===大小:" + writeBytes.length);

        Student s1 = om.readValue(writeBytes, Student.class);
        System.out.println(s1);
    }

    public static void fastJosn() throws IOException {
        Student s = getStudent();

        String txt = null;
        Long start = System.currentTimeMillis();

        for (int i = 0; i < 10000; i++) {
            txt = JSON.toJSONString(s);
        }

        System.out.println("fastJson序列化时间(ms):" + (System.currentTimeMillis() - start) + "===大小:" + txt.getBytes().length);

        Student s1 = JSON.parseObject(txt, Student.class);
        System.out.println(s1);
    }


    public static void protoBuf() throws IOException {
        Student s = getStudent();

        Codec<Student> personCodec = ProtobufProxy.create(Student.class, false);
        Long start = System.currentTimeMillis();
        byte[] b = null;
        for (int i = 0; i < 10000; i++) {
            b = personCodec.encode(s);
        }

        System.out.println("protoBuf序列化时间(ms):" + (System.currentTimeMillis() - start) + "===大小:" + b.length);

        Student s1 = personCodec.decode(b);
        System.out.println(s1);
    }

    public static void hessionTest() throws IOException {
        Student s = getStudent();

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        HessianOutput ho = new HessianOutput(os);
        Long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            ho.writeObject(s);
            if (i == 0) {
                System.out.println(os.toByteArray().length);
            }
        }

        System.out.println("hession序列化时间(ms):" + (System.currentTimeMillis() - start) + "===大小:");

        HessianInput hi = new HessianInput(new ByteArrayInputStream(os.toByteArray()));
        Student s1 = (Student) hi.readObject();
        System.out.println(s1);
    }

}
