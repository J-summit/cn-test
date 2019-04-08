//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package cn.lansky.设计模式.工厂.abstr;


import cn.lansky.设计模式.工厂.Audi;
import cn.lansky.设计模式.工厂.Car;

public class AudiFactory extends AbstractFactory {
    public AudiFactory() {
    }

    @Override
    public Car getCar() {
        return new Audi();
    }
}
