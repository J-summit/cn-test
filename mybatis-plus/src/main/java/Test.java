import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

/**
 * @author onlyo
 * @since 2019/7/9 10:58
 */
public class Test {
    public static void main(String[] args) {
        String time = "2019-01-01T22:11:10";
        LocalTime lt = LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm:ss"));
        System.out.println(lt);

    }
}
