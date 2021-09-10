package com.lmonkey.servlet.user;

import com.lmonkey.service.LMONKEY_USERDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/phonecheck")
public class phoneCheck extends HttpServlet {

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符集
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");

        String name = request.getParameter("name");

        //查询数据库中的name是否存在
        int count = LMONKEY_USERDao.selectByName(name);

        //获取输出流
        PrintWriter out = response.getWriter();
        if(count >0 ){
            out.print("false");
        }else{
            out.print("true");
        }



        out.close();
    }



}
