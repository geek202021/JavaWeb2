package com.jun.review;

import com.jun.bean.User;

/**
 * @author rujun.huang
 * @date 2021-10-14 22:45
 */
public interface UserService2 {
    public void registUser(User user);

    public User login(User user);

    //3.检查用户名是否可用
    public boolean existsUsername(String username);
}
