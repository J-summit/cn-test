//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package cn.lansky.设计模式.工厂.simple;

import cn.lansky.设计模式.工厂.Audi;
import cn.lansky.设计模式.工厂.Benz;
import cn.lansky.设计模式.工厂.Bmw;
import cn.lansky.设计模式.工厂.Car;


public class SimpleFactory {
    public SimpleFactory() {
    }

    public Car getCar(String name) {
        if ("BMW".equalsIgnoreCase(name)) {
            return new Bmw();
        } else if ("Benz".equalsIgnoreCase(name)) {
            return new Benz();
        } else if ("Audi".equalsIgnoreCase(name)) {
            return new Audi();
        } else {
            System.out.println("这个产品产不出来");
            return null;
        }
    }
}
