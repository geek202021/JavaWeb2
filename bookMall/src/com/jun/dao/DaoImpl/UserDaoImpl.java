package com.jun.dao.DaoImpl;

import com.jun.bean.User;
import com.jun.dao.BaseDao;
import com.jun.dao.UserDao;

/**
 * @author rujun.huang
 * @date 2021-10-16 23:49
 */
public class UserDaoImpl extends BaseDao implements UserDao {
    @Override
    public int saveUser(User user) {
        String sql = "insert into t_user2(`username`,`password`,`email`) values(?,?,?)";
        return update(sql, user.getUsername(), user.getPassword(), user.getEmail(), user.getEmail());
    }

    @Override
    public User queryUserByUserName(String username) {
        String sql = "select `id`,`username`,`password`,`email` from t_user2 where username = ?";
        return queryForOne(User.class,sql,username);
    }

    @Override
    public User queryUserByUserNameAndPwd(String username, String password) {
        String sql = "select `id`,`username`,`password`,`email` from t_user2 where username = ? and password = ?";
        return queryForOne(User.class,sql,username,password);
    }
}
