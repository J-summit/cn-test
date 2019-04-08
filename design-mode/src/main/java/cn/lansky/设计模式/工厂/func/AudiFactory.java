

package cn.lansky.设计模式.工厂.func;


import cn.lansky.设计模式.工厂.Audi;
import cn.lansky.设计模式.工厂.Car;

public class AudiFactory implements Factory {
    public AudiFactory() {
    }

    @Override
    public Car getCar() {
        return new Audi();
    }
}
