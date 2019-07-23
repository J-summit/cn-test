package cn.lansky.LBatis;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author onlyo
 * @since 2019/7/7 12:23
 */
public class LMapperProxy<T> implements InvocationHandler {


    private final LSqlSession sqlSession;
    private final Class<T> mapperInterface;

    public LMapperProxy(LSqlSession sqlSession, Class<T> mapperInterface) {
        this.sqlSession = sqlSession;
        this.mapperInterface = mapperInterface;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        if (method.getDeclaringClass().getName().equals(TestMapperXml.nameSpace)) {
            String sql = TestMapperXml.methodSqlMapping.get(method.getName());
            System.out.println(String.format("SQL [ %s ], parameter [%s] ", sql, args[0]));
            return sqlSession.selectOne(sql, String.valueOf(args[0]));
        }
        return null;
    }
}
