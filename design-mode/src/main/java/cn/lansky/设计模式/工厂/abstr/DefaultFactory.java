//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package cn.lansky.设计模式.工厂.abstr;

import cn.lansky.设计模式.工厂.Car;
import cn.lansky.设计模式.工厂.func.AudiFactory;

public class DefaultFactory extends AbstractFactory {
    private AudiFactory defaultFactory = new AudiFactory();

    public DefaultFactory() {
    }

    @Override
    public Car getCar() {
        return this.defaultFactory.getCar();
    }
}
