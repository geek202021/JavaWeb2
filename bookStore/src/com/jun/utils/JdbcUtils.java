package com.jun.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author rujun.huang
 * @date 2021-10-14 12:06
 */
public class JdbcUtils {
    //1.使用Druid数据库连接池技术
    private static DruidDataSource datasource;
    static {
        try {
            Properties pro = new Properties();
            InputStream ins = JdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            pro.load(ins);
//            ins.close();
            datasource = (DruidDataSource)DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //2.获取数据库连接池中的连接
    public static Connection getConnection()  {
        Connection connect = null;
        try {
            connect = datasource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connect;
    }

    //3.关闭连接，放回数据库连接池
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
