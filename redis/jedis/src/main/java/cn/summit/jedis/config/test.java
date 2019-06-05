package cn.summit.jedis.config;

/**
 * @author onlyo
 * @since 2019/4/29 15:37
 */
public class test {
    public static void main(String[] args) {
        String a = "<a>dasda<a><b>dada<b>";
        System.out.println(a.replaceAll("^<b>\\S*<b>$","111" ));
    }
}
