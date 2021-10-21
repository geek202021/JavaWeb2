package com.jun.review.Impl;

import com.jun.bean.User;
import com.jun.review.UserDao2;
import com.jun.review.UserService2;

/**
 * @author rujun.huang
 * @date 2021-10-14 22:48
 */
public class UserService2Impl implements UserService2 {
    private UserDao2 userDao2 = new UserDao2Impl();
    @Override
    public void registUser(User user) {
        userDao2.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao2.queryByUsernameAndPwd(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        if (userDao2.queryByUsername(username) == null) {
            return false;
        }
        return true;
    }
}
