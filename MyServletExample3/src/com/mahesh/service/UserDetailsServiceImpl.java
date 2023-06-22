package com.mahesh.service;

import java.util.List;

import com.mahesh.dao.UserDetailsDAO;
import com.mahesh.dao.UserDetailsHibernateDAO;
import com.mahesh.dao.UserDetailsJDBCDAOImpl;
import com.mahesh.servlets.dto.UserDetailsDTO;

public class UserDetailsServiceImpl implements UserDetailsService {

	UserDetailsDAO userDao = new UserDetailsJDBCDAOImpl();

	@Override
	public Boolean checkUserDetailsWithDatabase(String uname, String pass) {
		return userDao.checkUserDetailsWithDatabase(uname, pass);
	}

	@Override
	public UserDetailsDTO getUserDetailsByDatabase(String uname, String pass) {
		return userDao.getUserDetailsByDatabase(uname, pass);
	}

	@Override
	public UserDetailsDTO addUserDetailsInDatabase(String name, String pass, String address) {
		//userDao = new UserDetailsHibernateDAO();
		return userDao.addUserDetailsInDatabase(name, pass, address);
	}

	@Override
	public List<UserDetailsDTO> getAllUsers() {
		//userDao = new UserDetailsHibernateDAO();
		return userDao.getAllUsers();
	}

	@Override
	public List<UserDetailsDTO> deleteUserDetails(String userId) {
		return userDao.deleteUserDetails(userId);
	}

	@Override
	public UserDetailsDTO getUserDetailsById(String uId) {
		return userDao.getUserDetailsById(uId);
	}

	@Override
	public List<UserDetailsDTO> updateUserDetails(UserDetailsDTO newUserDetails) {
		return userDao.updateUserDetails(newUserDetails);
	}
	
	@Override
	public List<UserDetailsDTO> searchUserDetails(String name, String address) {
		//userDao = new UserDetailsHibernateDAO();
		return userDao.searchUserDetails(name, address);
	}

	@Override
	public Boolean isUserDetailsAlreadyExist(String username, String address) {
		Boolean result = false;
		for (UserDetailsDTO user : getAllUsers()) {
			if (null != username && null != user.getUserName() && user.getUserName().equalsIgnoreCase(username)) {
				if (null != address && null != user.getAddress() && user.getAddress().equalsIgnoreCase(address)) {
					result = true;
					break;
				}
			}
		}
		return result;
	}

	@Override
	public Boolean checkUserDetails(String uname, String pass) {
		return uname.equals("uname") && pass.equals("upass");
	}

	

	/*
	 * @Override public UserDetails getUserDetailsById(String uId) { UserDetails
	 * userDetails = null; for(UserDetails user : getAllUsers()) { if(null != uId &&
	 * user.getId().equals(Integer.valueOf(uId))) { userDetails = user; break; } }
	 * return userDetails; }
	 */

}
