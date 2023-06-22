package com.mahesh.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mahesh.service.UserDetailsService;
import com.mahesh.service.UserDetailsServiceImpl;
import com.mahesh.servlets.dto.UserDetailsDTO;
import com.mahesh.utils.ApplicationUtils;

public class UserDetailsServlets extends HttpServlet {

	private UserDetailsService userService = new UserDetailsServiceImpl();

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("uname");
		String pass = request.getParameter("upass");
		String address = request.getParameter("address");

		System.out.println("doPost Username : " + username + " Password : " + pass + " Address : " + address);

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		Boolean result = userService.isUserDetailsAlreadyExist(username, address);
		if (result) {
			out.print("<b>User Already Exists.... Please try with different name</b>");
			ApplicationUtils.printUserDetailsTableData(out, userService.getAllUsers());
		} else {
			UserDetailsDTO userDetails = userService.addUserDetailsInDatabase(username, pass, address);
			List<UserDetailsDTO> userList = userService.getAllUsers();
			out.print("<b><h1>Add Successfully with generated id : - " + userDetails.getId() + "</h1></b>");

			ApplicationUtils.printUserDetailsTableData(out, userList);
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

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userAction = request.getParameter("actionName");
		String userId = request.getParameter("userId");
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<html><body>");

		switch (userAction) {
			case "edit":
				editUserDetails(userId, out);
				break;
			case "delete":
				deleteUserDetails(userId, out);
				break;
			case "modifyUserDetails":
				modifyUserDetails(request, userId, out);
				break;
			case "search":
				searchUserDetails(request, out);
				break;
			default:
				out.print("data not found something went wrong");
				break;
		}

		/*
		 * if (null != userAction && userAction.equals("edit")) {
		 * editUserDetails(userId, out); } else if (null != userAction &&
		 * userAction.equals("delete")) { deleteUserDetails(userId, out); } else if
		 * (null != userAction && userAction.equals("modifyUserDetails")) {
		 * modifyUserDetails(request, userId, out); } else if (null != userAction &&
		 * userAction.equals("search")) { searchUserDetails(request, out); } else {
		 * out.print("data not found something went wrong"); }
		 */

		out.print("</body></html>");
	}

	private void searchUserDetails(HttpServletRequest request, PrintWriter out) {
		String name = request.getParameter("uname");
		String address = request.getParameter("uaddress");
		List<UserDetailsDTO> userList = userService.searchUserDetails(name, address);
		if (null != userList) {
			out.print("<b>Users found ");
			ApplicationUtils.printUserDetailsTableData(out, userList);
		} else {
			out.print("<b>Users not found ");
			ApplicationUtils.printUserDetailsTableData(out, userService.getAllUsers());
		}
	}

	private void modifyUserDetails(HttpServletRequest request, String userId, PrintWriter out) {
		String name = request.getParameter("uname");
		String pass = request.getParameter("upass");
		String address = request.getParameter("uaddress");
		UserDetailsDTO newUserDetails = new UserDetailsDTO();
		newUserDetails.setId(Integer.valueOf(userId));
		newUserDetails.setUserName(name);
		newUserDetails.setPassword(pass);
		newUserDetails.setAddress(address);

		UserDetailsDTO oldUserDetails = userService.getUserDetailsById(userId);
		if (oldUserDetails.equals(newUserDetails)) {
			out.print("<b>User having same data... modification not done</b>");
			ApplicationUtils.printUserDetailsTableData(out, userService.getAllUsers());
		} else {
			Boolean result = userService.isUserDetailsAlreadyExist(name, address);
			if (result) {
				out.print("<b>User Already Exists.... Please try with different name</b>");
				ApplicationUtils.printUserDetailsTableData(out, userService.getAllUsers());
			} else {
				List<UserDetailsDTO> userList = userService.updateUserDetails(newUserDetails);
				if (userList != null) {
					out.print("<b><h1>User Edited Successfully with id : - " + userId + "</h1></b>");
					ApplicationUtils.printUserDetailsTableData(out, userList);
				} else {
					ApplicationUtils.printUserDetailsTableData(out, userService.getAllUsers());
				}
			}
		}
	}

	private void deleteUserDetails(String userId, PrintWriter out) {
		List<UserDetailsDTO> userList = userService.deleteUserDetails(userId);
		if (userList != null) {
			out.print("<b><h1>User Deleted Successfully with id : - " + userId + "</h1></b>");
			ApplicationUtils.printUserDetailsTableData(out, userList);
		} else {
			ApplicationUtils.printUserDetailsTableData(out, userService.getAllUsers());
		}
	}

	private void editUserDetails(String userId, PrintWriter out) {
		UserDetailsDTO user = userService.getUserDetailsById(userId);
		if (user != null) {
			out.print("<b><h1>Edit User Form : - " + userId + "</h1></b>");
			out.print("<b><form action='modifyUserAction' method='get' >");
			out.print("<b><br><input name='actionName' type='hidden' value='modifyUserDetails'></input>");
			out.print("<b><br><input name='userId' type='hidden' value='" + user.getId() + "'></input>");
			out.print("<b><br>Username <input name='uname' type='text' value='" + user.getUserName() + "'></input>");
			out.print("<b><br>Password <input name='upass' type='text' value='" + user.getPassword() + "'></input>");
			out.print("<b><br>Address <input name='uaddress'  type='text' value='" + user.getAddress() + "'></input>");
			out.print("<b><br><br><input type='submit' value='Modify'></input>");
			out.print("<b><br></form><br>");
			ApplicationUtils.printUserDetailsTableData(out, userService.getAllUsers());
		} else {
			ApplicationUtils.printUserDetailsTableData(out, userService.getAllUsers());
		}
	}
}
