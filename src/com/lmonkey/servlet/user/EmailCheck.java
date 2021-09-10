package com.lmonkey.servlet.user;

import com.lmonkey.service.InFormation_USERDao;
import com.lmonkey.service.LMONKEY_USERDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/emailcheck")
public class EmailCheck extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置字符集
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        String name = req.getParameter("name");

        //查询数据库中的name是否存在
        int count = InFormation_USERDao.selectEmail(name);

        //获取输出流
        PrintWriter out = resp.getWriter();
        if(count >0 ){
            out.print("false");
        }else{
            out.print("true");
        }
        out.close();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
