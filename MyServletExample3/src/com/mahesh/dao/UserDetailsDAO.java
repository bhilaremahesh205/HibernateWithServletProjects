package com.mahesh.dao;

import java.util.List;

import com.mahesh.servlets.dto.UserDetailsDTO;


//Data access object
public interface UserDetailsDAO {
	
	Boolean checkUserDetailsWithDatabase(String uname, String pass);
	
	UserDetailsDTO addUserDetailsInDatabase(String name,String pass,String address);
	
	UserDetailsDTO getUserDetailsByDatabase(String uname, String pass);
	
	List<UserDetailsDTO> getAllUsers();

	List<UserDetailsDTO> deleteUserDetails(String userId);
	
	UserDetailsDTO getUserDetailsById(String uId);

	List<UserDetailsDTO> updateUserDetails(UserDetailsDTO newUserDetails);
	
	List<UserDetailsDTO> searchUserDetails(String name, String address);
}
