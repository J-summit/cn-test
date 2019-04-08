//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package cn.lansky.设计模式.工厂.abstr;


import cn.lansky.设计模式.工厂.Benz;
import cn.lansky.设计模式.工厂.Car;

public class BenzFactory extends AbstractFactory {
    public BenzFactory() {
    }

    @Override
    public Car getCar() {
        return new Benz();
    }
}
