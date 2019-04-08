package cn.summint;

import com.baidu.bjf.remoting.protobuf.FieldType;
import com.baidu.bjf.remoting.protobuf.annotation.Protobuf;
import lombok.Data;

import java.io.Serializable;

/**
 * @author onlyo
 * @since 2019/4/3 21:26
 */
@Data
public class Student implements Serializable {
    private static final long serialVersionUID = 1347752902499738756L;

    @Protobuf(fieldType = FieldType.STRING, order = 1)
    private String name;

    @Protobuf(fieldType = FieldType.INT32, order = 2)
    private Integer age;

    public static String a = "111";
}
