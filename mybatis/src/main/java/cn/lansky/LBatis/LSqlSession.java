package cn.lansky.LBatis;

import java.lang.reflect.Proxy;

/**
 * @author onlyo
 * @since 2019/7/7 12:23
 */
public class LSqlSession {


	public static void main(String[] args) {
		Long a =128l;
		Long b = 128l;
		System.out.println(a.equals(b));
	}

	private LExecutor executor = new LSimpleExecutor();
	//TODO configuration

	public <T> T selectOne(String statement, Object parameter) {
		return executor.query(statement, parameter);
	}

	public <T> T getMapper(Class<T> clazz) {
		return (T) Proxy.newProxyInstance(clazz.getClassLoader(),
				new Class[]{clazz}, new LMapperProxy(this, clazz));
	}
}
