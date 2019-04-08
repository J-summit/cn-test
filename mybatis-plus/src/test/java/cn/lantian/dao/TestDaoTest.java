package cn.lantian.dao;


import cn.lantian.service.TestService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


/**
 * @author onlyo
 * @since 2019/1/21 17:56
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TestDaoTest {
    @Autowired
    private TestDao testDao;

    @Autowired
    private TestService testService;

    @Autowired
    private PeopleDao peopleDao;

    @Test
    public void test1() {
        testDao.selectTest(new Page(1, 2)).getRecords().forEach(System.err::println);
    }

    @Test
    public void pageHelperTest() {
        testService.getList().forEach(System.err::println);
    }

    @Test
    public void test2() {
        peopleDao.lazyLoad();
    }
}
