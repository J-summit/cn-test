//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package cn.lansky.设计模式.工厂.simple;


import cn.lansky.设计模式.工厂.Car;

public class SimpleFactoryTest {
    public SimpleFactoryTest() {
    }

    public static void main(String[] args) throws Exception {
       Car car = new SimpleFactory().getCar2(CarImpl.Audi);
        System.out.println(car.getName());
    }
}
