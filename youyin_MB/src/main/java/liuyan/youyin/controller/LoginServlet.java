package liuyan.youyin.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import liuyan.youyin.pojo.AdminUser;
import liuyan.youyin.service.UserService;
import liuyan.youyin.service.impl.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		UserService userService = new UserServiceImpl(); 
		String username = (String) request.getParameter("username");
		String password = (String) request.getParameter("password");
		AdminUser adminUser = userService.findUserInfo(username, password);
		System.out.println(adminUser);
		if(adminUser !=null){
//			response.sendRedirect("WEB-INF/html/first.html");
			request.getRequestDispatcher("WEB-INF/html/first.html").forward(request, response);
		} else{
			response.sendRedirect("index.html");
		}
	}

}
