package cn.lantian.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.List;

/**
 * @author BruceMa
 * @date 2018/11/25 15:30
 */
@Data
public class zhuanye {

    @TableId
    private Integer zid;

    private String major;

    private Integer age;

    private List<Person> personList;

    public zhuanye(Integer zid, String major, Integer age) {
        this.zid = zid;
        this.major = major;
        this.age = age;
    }
}
