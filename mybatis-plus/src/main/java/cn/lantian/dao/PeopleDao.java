package cn.lantian.dao;

import cn.lantian.entity.People;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * @author onlyo
 * @since 2019/1/21 21:22
 */
@Repository
public interface PeopleDao extends BaseMapper<People> {


    People findById(Integer id);
}
