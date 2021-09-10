package com.lmonkey.servlet.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class CheckUserNum
 */
@WebServlet("/checkusernum")
public class CheckUserNum extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String num = req.getParameter("num");

		HttpSession session = req.getSession();

		String sysCode= (String)session.getAttribute("code");




		PrintWriter out = resp.getWriter();
		if(sysCode.equals(num) ){
			out.print("true");
		}else{
			out.print("false");
		}


		out.close();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

	}



}
