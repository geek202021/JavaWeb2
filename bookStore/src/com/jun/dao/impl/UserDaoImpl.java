package com.jun.dao.impl;

import com.jun.bean.User;
import com.jun.dao.BaseDao;
import com.jun.dao.UserDao;

import java.sql.SQLException;

/**
 * @author rujun.huang
 * @date 2021-10-14 18:39
 */
public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public User queryUserByUsername(String username) {
        String sql = "select `id`,`username`,`password`,`email` from t_user2 where username = ?";
        return queryForOne(User.class,sql,username);
    }

    @Override
    public User queryUserByUsernameAndPwd(String username, String password) {
        String sql = "select `id`,`username`,`password`,`email` from t_user2 where username = ? and password = ?";
        return queryForOne(User.class,sql,username,password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user2(`username`,`password`,`email`) values(?,?,?)";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }
}
