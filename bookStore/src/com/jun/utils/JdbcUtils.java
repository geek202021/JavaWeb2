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
    //使用ThreadLocal管理事务
    private static ThreadLocal<Connection> conns = new ThreadLocal<Connection>();

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
//    public static Connection getConnection()  {
//        Connection connect = null;
//        try {
//            connect = datasource.getConnection();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return connect;
//    }
    public static Connection getConnection(){
        Connection connect = conns.get();
        if (connect == null) {
            try {
                connect = datasource.getConnection();
                //保存到ThreadLocal对象中,供后面的JDBC使用
                conns.set(connect);
                connect.setAutoCommit(false);//设置为手动管理事务
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return connect;
    }

    //提交事务并关闭连接
    public static void commitAndClose() {
        Connection connection = conns.get();
        if (connection != null) {
            //如果不等于null，说明之前使用过连接，操作过数据库
            try {
                connection.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        //一定要执行remove操作，否则会出错。（因为Tomcat服务器底层使用了线程池技术）
        conns.remove();
    }
    //回滚事务，并关闭连接
    public static void rollbackAndClose() {
        Connection connection = conns.get();
        if (connection != null) {
            //如果不等于null，说明之前使用过连接，操作过数据库
            try {
                connection.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        //一定要执行remove操作，否则会出错。（因为Tomcat服务器底层使用了线程池技术）
        conns.remove();
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
