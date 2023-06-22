package com.mahesh.service;

import java.util.List;

import com.mahesh.servlets.dto.UserDetailsDTO;

public interface UserDetailsService {

	Boolean checkUserDetailsWithDatabase(String uname, String pass);

	UserDetailsDTO addUserDetailsInDatabase(String name, String pass, String address);

	UserDetailsDTO getUserDetailsByDatabase(String uname, String pass);

	List<UserDetailsDTO> getAllUsers();

	List<UserDetailsDTO> deleteUserDetails(String userId);

	UserDetailsDTO getUserDetailsById(String uId);

	List<UserDetailsDTO> updateUserDetails(UserDetailsDTO newUserDetails);

	Boolean isUserDetailsAlreadyExist(String username, String address);

	Boolean checkUserDetails(String uname, String pass);

	List<UserDetailsDTO> searchUserDetails(String name, String address);
}
