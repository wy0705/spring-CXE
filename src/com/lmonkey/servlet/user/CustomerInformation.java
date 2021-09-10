package com.lmonkey.servlet.user;

import com.lmonkey.entity.InFormation_USER;
import com.lmonkey.service.InFormation_USERDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/CustomerInformation")
public class CustomerInformation extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置字符集
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=utf-8");

        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String Birthday = req.getParameter("birthday");
        String Sex = req.getParameter("sex");
        String Salary = req.getParameter("salary");
        String Address = req.getParameter("address");
        String Email = req.getParameter("email");
        String PermanentAddress = req.getParameter("PermanentAddress");


        //创建用户实体
        InFormation_USER user = new InFormation_USER(id, name, phone, Birthday, Sex, Salary, Address, Email, PermanentAddress);

        //加入到数据库的用户表中
        int count = InFormation_USERDao.insert(user);

        if (count > 0) {
            resp.sendRedirect("order.jsp");
        } else {
            PrintWriter out = resp.getWriter();

            out.write("<script>");
            out.write("alert('用户信息添加失败！')");
            out.write("location.href='reg.jsp'");
            out.write("</script>");
        }
    }
}
