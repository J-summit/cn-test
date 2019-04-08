package cn.lansky.设计模式.代理.cglb;

/**
 * @author onlyo
 * @since 2019/3/12 21:45
 */
public class Test {
    public static void main(String[] args) {
        BookFacadeImpl1 b = (BookFacadeImpl1)  new BookFacadeCglib().getInstance(new BookFacadeImpl1());
        b.addBook();
    }
}
