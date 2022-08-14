package com.hy.service;

import com.hy.pojo.User;

public interface UserService {
    //用户登录
    public User login(String userName,String password);

    //根据用户ID，修改密码
    public boolean updatePwd(int id,String password);
}
