package com.jun.service;

import com.jun.bean.User;

/**
 * @author rujun.huang
 * @date 2021-10-14 19:38
 */
public interface UserService {
    //1.注册用户
    public void registUser(User user);

    //2.登录
    public User login(User user);

    //3.检查用户名是否可用(返回true,表示不可用)
    public boolean existsUsername(String username);
}
