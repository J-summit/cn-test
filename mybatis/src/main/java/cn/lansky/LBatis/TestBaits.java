package cn.lansky.LBatis;

import cn.lansky.demo.Test;
import cn.lansky.demo.TestMapper;

/**
 * @author onlyo
 * @since 2019/7/7 12:26
 */
public class TestBaits {

    public static void main(String[] args) {
        System.out.println(111111);
        LSqlSession sqlSession = new LSqlSession();
        TestMapper testMapper = sqlSession.getMapper(TestMapper.class);
        Test test = testMapper.selectByPrimaryKey(1);



        System.out.println(test);
    }
}
