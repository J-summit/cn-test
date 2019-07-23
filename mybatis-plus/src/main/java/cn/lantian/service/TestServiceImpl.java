package cn.lantian.service;

import cn.lantian.dao.PeopleDao;
import cn.lantian.dao.TestDao;
import cn.lantian.entity.People;
import cn.lantian.entity.zhuanye;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author onlyo
 * @since 2019/1/21 19:20
 */
@Service("testService")
public class TestServiceImpl extends ServiceImpl<PeopleDao, People> implements TestService {

    @Autowired
    private TestDao testDao;

    @Override
    public List<zhuanye> getList() {
//        this.getOne(new QueryWrapper<zhuanye>().lambda().eq(zhuanye::getAge, 1));
        PageHelper.startPage(1, 4);
        return testDao.pageHelperTest();
    }
}
