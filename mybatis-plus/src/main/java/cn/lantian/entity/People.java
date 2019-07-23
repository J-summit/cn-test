package cn.lantian.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@TableName("person")
public class People implements Serializable {

    private static final long serialVersionUID = -2519113758058536348L;

    private Integer id;
    private String userName;
    private Integer age;

    @TableId
    private Integer pid;

//    private zhuanye zhuanye;


    public People(Integer id, String userName, Integer age, Integer pid) {
        this.id = id;
        this.userName = userName;
        this.age = age;
        this.pid = pid;
    }
}
