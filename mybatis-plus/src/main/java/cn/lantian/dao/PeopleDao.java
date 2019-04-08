package cn.lantian.dao;

import cn.lantian.entity.Person;
import cn.lantian.entity.zhuanye;

import java.util.List;

/**
 * @author onlyo
 * @since 2019/1/21 21:22
 */
public interface PeopleDao {

    List<zhuanye> lazyLoad();

    List<Person> findById();
}
