package com.jun.test;

import com.jun.utils.JdbcUtils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author rujun.huang
 * @date 2021-10-14 12:20
 */
public class JdbcUtilsTest {
    @Test
    public void testJdbcUtils()  {
        for (int i = 0; i < 100; i++) {
            Connection connect = JdbcUtils.getConnection();
            System.out.println(connect);
            JdbcUtils.close(connect);
        }
    }
}
