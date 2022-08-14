package com.hy.Dao.User;

import com.hy.Dao.BaseDao;
import com.hy.pojo.User;
import com.mysql.cj.x.protobuf.MysqlxPrepare;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@SuppressWarnings({"all"})
public class UserDaoImpl implements UserDao {
    //得到要登录的用户
    @Override
    public User getLoginUser(Connection connection, String userName) {
        PreparedStatement pstm=null;
        ResultSet rs=null;
        User user=null;
        if(connection!=null){
            String sql="select * from user where userName=?";
            Object[] params={userName};
            try{
                rs= BaseDao.execute(connection,sql,params,rs,pstm);
                if(rs.next()){
                    user=new User();
                    user.setId(rs.getInt("id"));
                    user.setUserName(rs.getString("userName"));
                    user.setUserPassword(rs.getString("passWord"));
                    user.setGender((char) rs.getObject("gender"));

                }
            }catch (Exception e){
                e.printStackTrace();

            }
            BaseDao.closeResource(null,pstm,rs);
        }
        return user;
    }

    //修改当前用户密码
    @Override
    public int updatePwd(Connection connection, int id, String password) throws Exception {
        PreparedStatement pstm=null;
        int execute=0;
        if(connection!=null){
            String sql="update user set Password=? where id=?";
            Object[] params={password,id};
            execute=BaseDao.execute(connection,sql,params,pstm);
            BaseDao.closeResource(null, pstm, null);
        }
        return execute;
    }
}
