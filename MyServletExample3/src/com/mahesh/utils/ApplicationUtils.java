package com.mahesh.utils;

import java.io.PrintWriter;
import java.util.List;

import com.mahesh.servlets.dto.UserDetailsDTO;

public class ApplicationUtils {

	
	
	
	
	public static void printUserDetailsTableData(PrintWriter out, List<UserDetailsDTO> userList) {
		serachUserDetailsForm(out);
		out.print("<br><table border='2' style='width:600;'>" + "<tr>" + "<td>Id</td>" + "<td>Name</td>"
				+ "<td>Password</td>" + "<td>Address</td>" + "<td>Action</td><tr>");
		for (UserDetailsDTO user : userList) {
			out.print("<tr>");
			out.print("<td>" + user.getId() + "</td><td>" + user.getUserName() + "</td><td>" + user.getPassword()
					+ "</td><td>" + user.getAddress()
					+ "</td>"
					+ "<td>"
					+ "	<a href='editUserAction?actionName=edit&userId="+user.getId()+"'>Edit</a> |"
					+"  <a href='deleteUserAction?actionName=delete&userId="+user.getId()+"'>Delete</a></td>");

			out.print("</tr>");
		}
		out.print("</table>");
		out.print("<br><a href='add-user-details.html'>Add User Details</a>");
	}
	
	public static void serachUserDetailsForm(PrintWriter out) {
		out.print("<b><form action='searchUserAction' method='get' >");
		out.print("<b><br><h3>Search Details : </h3><input name='actionName' type='hidden' value='search'></input>");
		out.print("<b>Username <input name='uname' type='text'></input>");
		out.print("<b>Address <input name='uaddress'  type='text'></input>");
		out.print("<b><input type='submit' value='Search'></input>");
		out.print("<b></form><br>"); 
	}	
	
	
}
