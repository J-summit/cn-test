//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package cn.lansky.设计模式.工厂.abstr;

public class AbstractFactoryTest {
    public AbstractFactoryTest() {
    }

    public static void main(String[] args) {
        DefaultFactory factory = new DefaultFactory();
        System.out.println(factory.getCar("Benz"));
    }
}
