package com.jun.review;

import com.jun.bean.User;

/**
 * @author rujun.huang
 * @date 2021-10-14 22:20
 */
public interface UserDao2 {
    public User queryByUsername(String username);
    //如果返回null,说明用户名或密码错误
    public User queryByUsernameAndPwd(String username, String password);

    public int saveUser(User user); //注册

}
