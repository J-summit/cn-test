package cn.lantian.dao;

import cn.lantian.entity.zhuanye;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author onlyo
 * @since 2019/1/21 17:54
 */
@Repository
public interface TestDao extends BaseMapper<zhuanye> {

    IPage<zhuanye> selectTest(Page page);

    List<zhuanye> pageHelperTest();
}
