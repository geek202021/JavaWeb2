package com.jun.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author rujun.huang
 * @date 2021-10-16 23:16
 */
public class JdbcUtils {
    private static DataSource source;
    static{
        try {
            Properties pro = new Properties();
            InputStream ins = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            pro.load(ins);
            source = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //获取数据库连接池中的连接
    public static Connection getConnection() {
        Connection connect = null;
        try {
            connect = source.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connect;
    }

    //关闭连接
    public static void close(Connection connect) {
        if (connect != null) {
            try {
                connect.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
