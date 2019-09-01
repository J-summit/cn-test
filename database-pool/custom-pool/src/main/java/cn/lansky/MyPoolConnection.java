package cn.lansky;

import lombok.Data;

import java.sql.Connection;

/**
 * @author onlyo
 * @since 2019/7/28 21:28
 */
@Data
public class MyPoolConnection {

    private Connection con;

    /**
     * true 正在使用
     */
    private boolean busi;
}
