package com.jun.review.test;

import com.jun.bean.User;
import com.jun.review.Impl.UserService2Impl;
import com.jun.review.UserService2;
import org.junit.Test;

/**
 * @author rujun.huang
 * @date 2021-10-14 22:55
 */
public class UserService2Test {
    UserService2 userService2 = new UserService2Impl();
    @Test
    public void registUser() {
        userService2.registUser(new User(null,"admin2","admin2","admin2@qq.com"));
    }

    @Test
    public void login() {
        System.out.println(userService2.login(new User(null, "admin", "admin", null)));
    }

    @Test
    public void existsUsername() {
        if (userService2.existsUsername("admin2")) {
            System.out.println("用户名已存在");
        } else {
            System.out.println("用户名可用！");
        }
    }
}
