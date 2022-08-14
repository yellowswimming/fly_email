package com.hy.Dao;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class BaseDao {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    //静态代码块，类加载的时候就初始化了
    static{
        Properties properties = new Properties();
        //通过类加载器读取对应的资源
        InputStream is = BaseDao.class.getClassLoader().getResourceAsStream("db.properties");
        try{
            properties.load(is);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        driver=properties.getProperty("driver");
        url=properties.getProperty("url");
        username=properties.getProperty("username");
        password=properties.getProperty("password");
    }
    //获取数据库连接
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection connection=null;
        Class.forName(driver);
        connection= DriverManager.getConnection(url,username,password);
        return connection;
    }
    //编写查询公共类
    public static ResultSet execute(Connection connection, String sql, Object[] params, ResultSet resultSet, PreparedStatement preparedStatement) throws Exception{
        //预编译sql,防止sql注入
        preparedStatement=connection.prepareStatement(sql);
        for(int i=0;i<params.length;i++){
            preparedStatement.setObject(i+1,params[i]);
        }
        resultSet=preparedStatement.executeQuery();
        return resultSet;
    }
    //编写增删改公共方法
    public static int execute(Connection connection,String sql,Object[] params,PreparedStatement preparedStatement)throws Exception{
        preparedStatement=connection.prepareStatement(sql);
        for(int i=0;i<params.length;i++){
            preparedStatement.setObject(i+1,params[i]);

        }
        int updateRows=preparedStatement.executeUpdate();
        return updateRows;
    }
    //关闭连接，释放新资源
    public  static boolean closeResource(Connection connection,PreparedStatement preparedStatement,ResultSet resultSet){
        boolean flag=true;
        if(resultSet!=null){
            try{
                resultSet.close();
                resultSet=null;
            }catch (SQLException e){
                e.printStackTrace();
                flag=false;
            }
        }

        if(connection!=null){
            try{
                connection.close();
                connection=null;
            }catch (SQLException e){
                e.printStackTrace();
                flag=false;
            }
        }
        if(preparedStatement!=null){
            try{
                preparedStatement.close();
                preparedStatement=null;
            }catch (SQLException e){
                e.printStackTrace();
                flag=false;
            }
        }
        return flag;

    }


}
