package cn.summit;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author onlyo
 * @since 2019/6/2 10:12
 */
public class BeanFactoryTest {
    public static void main(String[] args) {
        //通过main启动
        ClassPathXmlApplicationContext xml = new ClassPathXmlApplicationContext("application.xml");
    }
}
