package com.jun.review;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.util.List;

/**
 * @author rujun.huang
 * @date 2021-10-14 21:51
 */
public abstract class BaseDao2 {
    QueryRunner queryRunner = new QueryRunner();

    //1.通用的增删改操作
    public int update(String sql, Object... args) {
        Connection connect = JdbcUtils2.getConnection();
        try {
            return queryRunner.update(connect, sql, args);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils2.close(connect);
        }
        return -1;
    }

    //2.查询一个用户
    public <T>T queryForOne(Class<T> type, String sql, Object... args) {
        Connection connect = JdbcUtils2.getConnection();
        try {
            return queryRunner.query(connect, sql, new BeanHandler<T>(type), args);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils2.close(connect);
        }
        return null;
    }

    //3.获取对象集合
    public <T> List<T> queryForList(Class<T> type, String sql, Object... args) {
        Connection connect = JdbcUtils2.getConnection();
        try {
            return queryRunner.query(connect, sql, new BeanListHandler<T>(type), args);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils2.close(connect);
        }
        return null;
    }

    //4.获取某个简单的值
    public Object querySingleValue(String sql, Object... args) {
        Connection connect = JdbcUtils2.getConnection();
        try {
            return queryRunner.query(connect, sql, new ScalarHandler(), args);
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            JdbcUtils2.close(connect);
        }
        return null;
    }
}
