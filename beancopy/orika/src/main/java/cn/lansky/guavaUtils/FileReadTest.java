package cn.lansky.guavaUtils;


import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.HashSet;

/**
 * @author onlyo
 * @since 2019/7/23 21:59
 */
public class FileReadTest {
    public static void main(String[] args) throws IOException {
//        List<String> context = Files.readLines(new File("D:\\onlyoproject\\cn-lansky\\beancopy\\orika\\src\\main\\resources\\aa.txt"),
//                Charsets.UTF_8);
        Charset charset = Charset.defaultCharset();
        // Joiner.on(",").useForNull("").join()
//        BiMap
        String str = "";
        //Preconditions.checkArgument(StringUtils.isEmpty(str), "str 不能为空");

        System.out.println(new BigDecimal(2).compareTo(new BigDecimal(2)));
        System.out.println(charset.name());
    }
}
