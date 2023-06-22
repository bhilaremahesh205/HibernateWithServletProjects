package com.mahesh.servlets;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mahesh.service.UserDetailsService;
import com.mahesh.service.UserDetailsServiceImpl;
import com.mahesh.utils.ApplicationUtils;

public class LoginServlet extends HttpServlet  {
	
	private UserDetailsService userService = new UserDetailsServiceImpl();
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("uname");
		String pass = request.getParameter("upass");
		System.out.println("doGet Username : "+username +" Password : "+pass);
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		
		
		Boolean result = userService.checkUserDetailsWithDatabase(username, pass);
		//Boolean result = userService.checkUserDetails(username, pass);
		
		if(result != null && result){
			out.print("<b><h1>Welcome Login Successful..</h1></b>");
			ApplicationUtils.printUserDetailsTableData(out, userService.getAllUsers());
		}else {
			out.print("<b>Login Fails please try once again</b>");
			out.print("<br><a href='index.html'>Login Form</a>");
		}
		out.print("</body></html>");
		
		/*
		 * if(username.equals("uname") && pass.equals("upass")){
		 * 
		 * out.print("<b><h1>Welcome Login Successful..</h1></b>");
		 * 
		 * }else { out.print("<b>Login Fails please try once again</b>");
		 * out.print("<br><a href='index.html'>Login Form</a>"); }
		 */
		
	}

	
}
