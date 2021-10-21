package com.jun.review.test;

import com.jun.bean.User;
import com.jun.review.UserDao2;
import com.jun.review.Impl.UserDao2Impl;
import org.junit.Test;

/**
 * @author rujun.huang
 * @date 2021-10-14 22:30
 */
public class UserDao2Test {
    UserDao2 userDao2 = new UserDao2Impl();
    @Test
    public void queryByUsername() {
        if (userDao2.queryByUsername("admin") == null) {
            System.out.println("用户名可用");
        } else{
            System.out.println("用户名不可用！");
        }
    }

    @Test
    public void queryByUsernameAndPwd() {
        if (userDao2.queryByUsernameAndPwd("admin", "admin") == null) {
            System.out.println("用户名或密码错误！");
        } else {
            System.out.println("欢迎登录！");
        }
    }

    @Test
    public void saveUser() {
        System.out.println(userDao2.saveUser(new User(null,"admin1","admin1","admin@qq.com")));
    }
}
