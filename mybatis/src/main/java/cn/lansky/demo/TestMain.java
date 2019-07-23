package cn.lansky.demo;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author onlyo
 * @since 2019/6/8 13:55
 */
public class TestMain {
    public static void main(String[] args) throws IOException {
        SqlSession session = getSqlSessionFactory().openSession();
        TestMapper testMapper =  session.getMapper(TestMapper.class);
        testMapper.selectBlog(1);
        Test t1 = new Test();
        t1.setId(1);
        t1.setName("tom");
        testMapper.updatebyId(t1);
        try {
            Test test = session.selectOne(
                    "cn.lansky.demo.TestMapper.selectBlog", 1);
            System.out.println(test);
        } finally {
            session.close();
        }
    }

    public static SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }

    public void test1() {

    }

    public int test1(int a) {
        return 1;
    }
}
