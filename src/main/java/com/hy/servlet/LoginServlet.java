package com.hy.servlet;

import com.hy.pojo.User;
import com.hy.service.UserServiceImpl;
import com.hy.util.Constant;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.jsp.PageContext;

import java.io.IOException;
import java.sql.Connection;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取前端请求的参数
        String userName = req.getParameter("username");
        String passWord = req.getParameter("password");
        UserServiceImpl userService = new UserServiceImpl();
        User user = userService.login(userName, passWord);

        if (user != null && passWord.equals(user.getUserPassword())) {
            req.getSession().setAttribute(Constant.USER_SESSION, user);

            resp.sendRedirect( "sys/homePage.jsp");
        } else {

            req.setAttribute("error", "用户名或密码错误！");
            System.out.println("no");
            req.getRequestDispatcher( "index.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
