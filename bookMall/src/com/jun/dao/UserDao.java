package com.jun.dao;

import com.jun.bean.User;

/**
 * @author rujun.huang
 * @date 2021-10-16 23:27
 */
public interface UserDao  {
    public int saveUser(User user);

    public User queryUserByUserName(String username);

    public User queryUserByUserNameAndPwd(String username, String password);

}
