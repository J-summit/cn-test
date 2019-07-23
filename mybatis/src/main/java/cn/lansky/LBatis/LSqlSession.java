package cn.lansky.LBatis;

import org.apache.ibatis.binding.MapperProxy;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.SimpleExecutor;

import java.lang.reflect.Proxy;

/**
 * @author onlyo
 * @since 2019/7/7 12:23
 */
public class LSqlSession {

    private LExecutor executor = new LSimpleExecutor();
    //TODO configuration

    public <T> T selectOne(String statement, Object parameter) {
        return executor.query(statement,parameter);
    }

    public <T> T getMapper(Class<T> clazz) {
        return (T) Proxy.newProxyInstance(clazz.getClassLoader(),
                new Class[]{clazz}, new LMapperProxy(this, clazz));
    }
}
