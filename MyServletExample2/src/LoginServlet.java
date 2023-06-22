import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet implements Servlet   {
	
	ServletConfig config = null;
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("uname");
		String pass = request.getParameter("upass");
		
		
		System.out.println("doGet Username : "+username +" Password : "+pass);
		
		//TODO - DB call check username & passw same 
		//then return success or failer page
		
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		if(username.equals("uname") &&  pass.equals("upass")){
			out.print("<b><h1>Welcome Login Successful..</h1></b>");
		}else {
			out.print("<b>Login Fails please try once again</b>");
			out.print("<br><a href='index.html'>Login Form</a>");
		}
		out.print("</body></html>");
	}

	
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String username = request.getParameter("uname");
		String pass = request.getParameter("upass");
		
		
		System.out.println("service Username : "+username +" Password : "+pass);
		
		//TODO - DB call check username & passw same 
		//then return success or failer page
		
		response.setContentType("text/html");

		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		if(username.equals("uname") &&  pass.equals("upass")){
			out.print("<b><h1>Welcome Login Successful..</h1></b>");
		}else {
			out.print("<b>Login Fails please try once again</b>");
			out.print("<br><a href='index.html'>Login Form</a>");
		}
		out.print("</body></html>");
	}

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getServletInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	public void init(ServletConfig arg0) throws ServletException {
		this.config = config;
	}

	
	
}
