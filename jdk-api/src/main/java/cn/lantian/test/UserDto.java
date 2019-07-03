package cn.lantian.test;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

/**
 * @author onlyo
 * @since 2019/6/5 16:56
 */
@Data
public class UserDto {
    private int id;

    private String name;

    public LocalDateTime ldt;

    private LocalDate ld;

    private LocalTime lt;

    private LiDto liDto;

    private List<Sour> sours;

}
