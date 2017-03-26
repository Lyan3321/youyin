package liuyan.youyin.controller;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import liuyan.youyin.service.LoginService;

public class MachineLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String data = request.getParameter("data");
		System.out.println(data);
		LoginService ls = new LoginService();
		String result = ls.handleData(data);
		System.out.println(result);
		Writer out = response.getWriter();
		out.write(result);
		out.flush();
		out.close();
	}

}
