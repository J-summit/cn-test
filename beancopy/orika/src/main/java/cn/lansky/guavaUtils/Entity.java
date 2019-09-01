package cn.lansky.guavaUtils;

import lombok.Data;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Objects;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

@Data
public class Entity {
    public static void main(String[] args) {
        System.out.println(ChronoUnit.DAYS.between(LocalDate.now(), LocalDate.now())
        );



    }

    private String id;

    private String name;

    private String test;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Entity entity = (Entity) o;
        return Objects.equals(id, entity.id) &&
                Objects.equals(name, entity.name) &&
                Objects.equals(test, entity.test);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, test);
    }
}
