package cn.lantian.synchronizedCollect;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * @author onlyo
 * @since 2019/1/27 11:53
 */
public class ConTest {

    /**
     * 将线程不安全的 转变成线程安全的 内部实现将方法   synchronized (mutex)
     *
     */
    public static void main(String[] args) {
        Collections.synchronizedCollection(new ArrayList<>());
        Collections.synchronizedMap(new HashMap<>());

    }
}
