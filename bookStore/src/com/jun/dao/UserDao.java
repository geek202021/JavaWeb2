package com.jun.dao;

import com.jun.bean.User;

/**
 * ctrl+shift+t测试
 * @author rujun.huang
 * @date 2021-10-14 18:34
 */
public interface UserDao {
    //1. 根据用户名查询用户信息(如果返回null,说明没有这个用户。反之亦然)
    public User queryUserByUsername(String username);

    //2.根据 用户名和密码查询用户信息(如果返回 null,说明用户名或密码错误)
    public User queryUserByUsernameAndPwd(String username, String password);

    //3.保存用户信息(返回-1 表示操作失败，其他是 sql 语句影响的行数)
    public int saveUser(User user);
}
