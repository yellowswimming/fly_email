package com.hy.Dao.User;

import com.hy.pojo.User;

import java.sql.Connection;

public interface UserDao {
    //得到登录的用户
    public User getLoginUser(Connection connection,String userName);
    //修改当前用户密码
    public int updatePwd(Connection connection,int id,String password) throws Exception;
}
