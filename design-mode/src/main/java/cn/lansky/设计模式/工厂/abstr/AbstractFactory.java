//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package cn.lansky.设计模式.工厂.abstr;


import cn.lansky.设计模式.工厂.Car;

public abstract class AbstractFactory {
    public AbstractFactory() {
    }

    protected abstract Car getCar();

    public Car getCar(String name) {
        if ("BMW".equalsIgnoreCase(name)) {
            return (new BmwFactory()).getCar();
        } else if ("Benz".equalsIgnoreCase(name)) {
            return (new BenzFactory()).getCar();
        } else if ("Audi".equalsIgnoreCase(name)) {
            return (new AudiFactory()).getCar();
        } else {
            System.out.println("这个产品产不出来");
            return null;
        }
    }
}
