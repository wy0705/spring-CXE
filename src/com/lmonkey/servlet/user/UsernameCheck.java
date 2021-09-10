package com.lmonkey.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lmonkey.service.LMONKEY_USERDao;

/**
 * Servlet implementation class UsernameCheck
 * 用户名检查的一个类
 */
@WebServlet("/usernamecheck")
public class UsernameCheck extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//设置字符集
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=utf-8");

		String name = req.getParameter("name");

		//查询数据库中的name是否存在
		int count = LMONKEY_USERDao.selectByName(name);

		//获取输出流
		PrintWriter out = resp.getWriter();
		if(count >0 ){
			out.print("false");
		}else{
			out.print("true");
		}



		out.close();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	

}
