package com.jun.review;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author rujun.huang
 * @date 2021-10-14 21:52
 */
public class JdbcUtils2 {
    private static DataSource source;
    static{
        try {
            Properties pro = new Properties();
            InputStream ins = JdbcUtils2.class.getClassLoader().getResourceAsStream("jdbc.properties");
            pro.load(ins);
            source = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static Connection getConnection(){
        Connection connect = null;
        try {
            connect = source.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connect;
    }

    public static void close(Connection connect){
        if (connect != null) {
            try {
                connect.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }


}
