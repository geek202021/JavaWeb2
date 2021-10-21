package com.jun.review.Impl;

import com.jun.bean.User;
import com.jun.review.BaseDao2;
import com.jun.review.UserDao2;

/**
 * @author rujun.huang
 * @date 2021-10-14 22:25
 */
public class UserDao2Impl extends BaseDao2 implements UserDao2 {
    @Override
    public User queryByUsername(String username) {
        String sql = "select `id`,`username`,`password`,`email` from t_user2 where username = ?";
        return queryForOne(User.class,sql,username);
    }

    @Override
    public User queryByUsernameAndPwd(String username, String password) {
        String sql = "select `id`,`username`,`password`,`email` from t_user2 where username = ? and password = ?";
        return queryForOne(User.class,sql,username,password);
    }

    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user2(`username`,`password`,`email`) values(?,?,?)";
        return update(sql,user.getUsername(),user.getPassword(),user.getEmail());
    }
}
