package cn.lansky;

/**
 * @author onlyo
 * @since 2019/6/7 22:02
 */
public enum EnumTest {
    t1("t1", "name"),
    t2("t1", "name"),
    t3("t1", "name"),;


    private String id;

    private String name;

    EnumTest(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
