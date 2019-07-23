package cn.lantian.dao;


import cn.lantian.entity.People;
import cn.lantian.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.yaml.snakeyaml.events.Event;


/**
 * @author onlyo
 * @since 2019/1/21 17:56
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class TestDaoTest {
    @Autowired
    private TestDao testDao;

    @Autowired
    private TestService testService;

    @Autowired
    private PeopleDao peopleDao;


    @Test
    public void findById() {
        People byId = peopleDao.findById(1);
        System.out.println(byId);
    }

    @Test
    public void findById1() {
        People byId = peopleDao.selectById(3);
        log.warn(byId.toString());
    }
}
