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
        session.getMapper(TestMapper.class);
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
}
