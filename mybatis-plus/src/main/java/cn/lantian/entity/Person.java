package cn.lantian.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
public class Person implements Serializable {

    private static final long serialVersionUID = -2519113758058536348L;

    @TableId
    private Integer id;
    private String userName;
    private Integer age;
    private Integer pid;

//    private zhuanye zhuanye;


    public Person(Integer id, String userName, Integer age, Integer pid) {
        this.id = id;
        this.userName = userName;
        this.age = age;
        this.pid = pid;
    }
}
