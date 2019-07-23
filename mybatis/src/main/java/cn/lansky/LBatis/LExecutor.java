package cn.lansky.LBatis;

/**
 * @author onlyo
 * @since 2019/7/7 12:23
 */
public interface LExecutor {

    <T> T query(String statement, Object parameter);
}
