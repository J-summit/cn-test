package cn.lansky.设计模式.原型.simple;

import java.io.Serializable;

/**
 * @author onlyo
 * @since 2019/3/19 19:54
 */
public class CloneMode extends ProtoType implements Cloneable, Serializable {
    private String name;
    private Integer age;


    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
