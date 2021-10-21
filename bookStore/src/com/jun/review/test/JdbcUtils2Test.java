package com.jun.review.test;

import com.jun.review.JdbcUtils2;

import java.sql.Connection;

/**
 * @author rujun.huang
 * @date 2021-10-14 22:02
 */
public class JdbcUtils2Test {
    public static void main(String[] args) {
        Connection connect = JdbcUtils2.getConnection();
        for (int i = 0; i < 20; i++) {
            System.out.println(connect);
        }
        JdbcUtils2.close(connect);
    }
}
