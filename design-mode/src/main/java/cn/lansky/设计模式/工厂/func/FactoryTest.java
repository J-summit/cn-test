

package cn.lansky.设计模式.工厂.func;

public class FactoryTest {
    public FactoryTest() {
    }

    public static void main(String[] args) {
        Factory factory = new AudiFactory();
        System.out.println(factory.getCar());
        Factory factory1 = new BmwFactory();
        System.out.println(factory1.getCar());
    }
}
