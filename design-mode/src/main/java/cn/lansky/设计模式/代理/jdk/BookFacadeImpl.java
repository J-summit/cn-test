package cn.lansky.设计模式.代理.jdk;

/**
 * @author BruceMa
 * @date 2018/3/29 9:14
 */
public class BookFacadeImpl implements BookFacade {
    @Override
    public void addBook() {
        System.out.println("增加图书方法。。。");
    }
}
