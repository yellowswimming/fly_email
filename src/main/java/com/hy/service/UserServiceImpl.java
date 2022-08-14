package com.hy.service;

import com.hy.Dao.BaseDao;
import com.hy.Dao.User.UserDao;
import com.hy.Dao.User.UserDaoImpl;
import com.hy.pojo.User;

import java.sql.Connection;

public class UserServiceImpl implements UserService {
    private UserDao userDao;
    public UserServiceImpl(){
        userDao=new UserDaoImpl();
    }
    @Override
    public User login(String userName, String password) {
        Connection connection=null;
        User user=null;
        try {
            connection= BaseDao.getConnection();
            user=userDao.getLoginUser(connection,userName);
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            BaseDao.closeResource(connection,null,null);
        }
        return user;
    }

    @Override
    public boolean updatePwd(int id, String password) {
        return false;
    }
}
