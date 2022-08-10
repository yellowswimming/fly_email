package com.hy.servlet;

import com.hy.util.Constant;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class LoginOut extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object usr_session = req.getSession().getAttribute(Constant.USER_SESSION);
        if(usr_session!=null){
            req.getSession().removeAttribute(Constant.USER_SESSION);
            resp.sendRedirect(req.getContextPath()+"/index.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       doGet(req, resp);
    }
}
