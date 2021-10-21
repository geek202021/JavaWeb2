package com.jun.service.impl;

import com.jun.bean.User;
import com.jun.dao.UserDao;
import com.jun.dao.impl.UserDaoImpl;
import com.jun.service.UserService;

/**
 * @author rujun.huang
 * @date 2021-10-14 20:17
 */
public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public void registUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public User login(User user) {
        return userDao.queryUserByUsernameAndPwd(user.getUsername(),user.getPassword());
    }

    @Override
    public boolean existsUsername(String username) {
        if(userDao.queryUserByUsername(username) == null){
            return false;
        }
        return true;
    }
}
