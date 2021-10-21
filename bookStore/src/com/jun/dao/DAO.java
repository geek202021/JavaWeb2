package com.jun.dao;

import com.jun.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * 封装了针对于数据表的通用操作。
 *
 * @author rujun.huang
 * @date 2021-10-14 16:26
 */
public class DAO<T> {
    //使用DbUtils操作数据库
    private QueryRunner queryRunner = new QueryRunner();

    //1.通用的增删改操作：update(),执行：Insert\Update\Delete 语句
    public int update(String sql, Object... args) throws SQLException {
        Connection connect = JdbcUtils.getConnection();
        try {
            return queryRunner.update(connect, sql, args);
        } finally {
            JdbcUtils.close(connect);
        }
    }
    //2.查询返回一个 javaBean 的 sql 语句
    public <T>T queryForOne(Class<T> type, String sql, Object... args) throws SQLException {
        Connection connect = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connect, sql, new BeanHandler<T>(type), args);
        } finally {
            JdbcUtils.close(connect);
        }
    }
    //3.查询返回一个 javaBean 的 sql 语句,获取对象集合
    public List<T> queryForList(Class<T> type, String sql, Object... args) throws SQLException {
        Connection connect = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connect, sql, new BeanListHandler<T>(type), args);
        } finally {
            JdbcUtils.close(connect);
        }
    }
    //4.执行返回一行一列的 sql 语句,获取某个简单的值
    public Object queryForSingleValue(String sql, Object... args) throws SQLException {
        Connection connect = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connect, sql, new ScalarHandler(), args);
        } finally {
            JdbcUtils.close(connect);
        }
    }
}
