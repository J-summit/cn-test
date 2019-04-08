//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package cn.lansky.设计模式.工厂.func;


import cn.lansky.设计模式.工厂.Bmw;
import cn.lansky.设计模式.工厂.Car;

public class BmwFactory implements Factory {
    public BmwFactory() {
    }

    @Override
    public Car getCar() {
        return new Bmw();
    }
}
