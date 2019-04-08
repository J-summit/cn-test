//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package cn.lansky.设计模式.代理.custom;

import cn.lansky.设计模式.代理.jdk.BookFacade;
import java.lang.reflect.Method;

public class GPMeipo implements GPInvocationHandler {
    private BookFacade target;

    public GPMeipo() {
    }

    public Object getInstance(BookFacade target) throws Exception {
        this.target = target;
        Class clazz = target.getClass();
        System.out.println("被代理对象的class是:" + clazz);
        return GPPorxy.newProxyInstance(new GPClassLoader(), clazz.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("我是媒婆：得给你找个异性才行");
        System.out.println("开始进行海选...");
        System.out.println("------------");
        method.invoke(this.target, args);
        System.out.println("------------");
        System.out.println("如果合适的话，就准备办事");
        return null;
    }
}
