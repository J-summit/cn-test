package cn.lansky.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
public class Test {
    private Integer id;

    private Integer nums;

    private String name;

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.stream().findFirst();
    }
}

