//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package cn.lansky.设计模式.工厂.simple;


import cn.lansky.设计模式.工厂.Car;

public class SimpleFactoryTest {
    public SimpleFactoryTest() {
    }

    public static void main(String[] args) {
        Car car = (new SimpleFactory()).getCar("Audi");
        System.out.println(car.getName());
    }
}
