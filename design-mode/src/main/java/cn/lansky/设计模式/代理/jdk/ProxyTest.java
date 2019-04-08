package cn.lansky.设计模式.代理.jdk;

/**
 * @author BruceMa
 * @date 2018/3/29 8:56
 * <p>
 * JDK代理只是适用于某些类实现了哪些接口
 */
public class ProxyTest {
    public static void main(String[] args) {
        BookFacadeProxy bf = new BookFacadeProxy();
        BookFacade b = (BookFacade) bf.bind(new BookFacadeImpl());
        b.addBook();

    }
}
