package com.jun.dao;

import com.jun.bean.User;
import com.jun.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.xml.ws.handler.Handler;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author rujun.huang
 * @date 2021-10-16 23:27
 */
public abstract class BaseDao {
    QueryRunner queryRunner = new QueryRunner();
    public int update(String sql, Object... args) {
        Connection connect = JdbcUtils.getConnection();
        try {
            return queryRunner.update(connect, sql, args);
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            JdbcUtils.close(connect);
        }
        return -1;
    }

    public <T> T queryForOne(Class<T> type, String sql, Object... args) {
        Connection connect = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connect, sql, new BeanHandler<T>(type), args);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JdbcUtils.close(connect);
        }
        return null;
    }

    public <T> List<T> queryForList(Class<T> type, String sql, Object... args) {
        Connection connect = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connect, sql, new BeanListHandler<T>(type), args);
        } catch (Exception e) {
            e.printStackTrace();
        } finally{
            JdbcUtils.close(connect);
        }
        return null;
    }

    public Object querySingleValue(String sql, Object... args) {
        Connection connect = JdbcUtils.getConnection();
        try {
            return queryRunner.query(connect,sql,new ScalarHandler(), args);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.close(connect);
        }
        return null;
    }

}
