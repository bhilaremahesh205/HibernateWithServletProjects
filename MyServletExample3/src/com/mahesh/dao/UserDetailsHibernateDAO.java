package com.mahesh.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;

import com.mahesh.dao.model.UserDetailsModel;
import com.mahesh.servlets.dto.UserDetailsDTO;
import com.mahesh.utils.HibernateUtil;

public class UserDetailsHibernateDAO implements UserDetailsDAO{

	@Override
	public Boolean checkUserDetailsWithDatabase(String uname, String pass) {
		return null;
	}
	
	
	@Override
	public UserDetailsDTO getUserDetailsByDatabase(String uname, String pass) {
		return null;
	}
	
	@Override
	public UserDetailsDTO addUserDetailsInDatabase(String name, String pass, String address) {
		 System.out.println("addUserDetailsInDatabase : using hibernate");
		  Session session = HibernateUtil.getSessionFactory().openSession();
	      Transaction tx = null;
	      UserDetailsDTO userDetailsDTO = null;
	      try {
	         tx = session.beginTransaction();
	         UserDetailsModel userDetailsModel = new UserDetailsModel();
	         userDetailsModel.setUserName(name);
	         userDetailsModel.setPassword(pass);
	         userDetailsModel.setAddress(address);
	         Integer newId = (Integer) session.save(userDetailsModel); 
	         userDetailsModel.setUserId(newId);
    		 if(null != userDetailsModel.getUserId()) {
    			userDetailsDTO = convertUserDetailsModelToUserDetailsDTO(userDetailsModel);
    		 }
	         tx.commit();
	      } catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      } finally {
	         session.close(); 
	      }
	      return userDetailsDTO;
	 }


	private UserDetailsDTO convertUserDetailsModelToUserDetailsDTO(UserDetailsModel userDetailsModel) {
		UserDetailsDTO userDetailsDTO;
		userDetailsDTO = new UserDetailsDTO();
		userDetailsDTO.setId(userDetailsModel.getUserId());
		userDetailsDTO.setUserName(userDetailsModel.getUserName());
		userDetailsDTO.setPassword(userDetailsModel.getPassword());
		userDetailsDTO.setAddress(userDetailsModel.getAddress());
		return userDetailsDTO;
	}
	

	@Override
	public List<UserDetailsDTO> getAllUsers() {
		System.out.println("getAllUsers : using hibernate");
    	List<UserDetailsDTO> userDTOList= null;
    	Session session = HibernateUtil.getSessionFactory().openSession();
        try {
           List<UserDetailsModel> userDetailsModelList =(List<UserDetailsModel>)session.createQuery("FROM UserDetailsModel").list(); 
           if(null != userDetailsModelList) {
        	   userDTOList = new ArrayList<>();
	           for(UserDetailsModel userDetailsModel : userDetailsModelList) {
	        	   UserDetailsDTO userDetailsDTO = convertUserDetailsModelToUserDetailsDTO(userDetailsModel);
	        	   userDTOList.add(userDetailsDTO);
	           }
          }
        } catch (HibernateException e) {
           e.printStackTrace(); 
        } finally {
           session.close(); 
        }
		return userDTOList;
	}

	@Override
	public List<UserDetailsDTO> deleteUserDetails(String userId) {
		return null;
	}

	@Override
	public UserDetailsDTO getUserDetailsById(String uId) {
		UserDetailsDTO userDetails = null;
		for(UserDetailsDTO user : getAllUsers()) {
			if(null != uId && user.getId().equals(Integer.valueOf(uId))) {
				userDetails = user;
				break;
			}
		}
		return userDetails;
	}

	@Override
	public List<UserDetailsDTO> updateUserDetails(UserDetailsDTO newUserDetails) {
		return null;
	}


	@Override
	public List<UserDetailsDTO> searchUserDetails(String name, String address) {
		// TODO Auto-generated method stub
		System.out.println("searchUserDetails : using hibernate");
    	List<UserDetailsDTO> userDTOList= null;
    	Session session = HibernateUtil.getSessionFactory().openSession();
        try {
           Criteria criteria = session.createCriteria(UserDetailsModel.class);
           if(null != name && name != "") {
        	   //Criterion c1 = Restrictions.eq("userName", name);
        	   //Criterion c2 = Restrictions.like("userName", name);
        	   //criteria.add(Restrictions.or(c1, c2));
        	   criteria.add( Restrictions.eq("userName", name));
        	   
           }
           if(null != address &&  address != "") {
        	   criteria.add(Restrictions.eq("address", address));
           }
           List<UserDetailsModel> userDetailsModelList =(List<UserDetailsModel>)criteria.list(); 
           if(null != userDetailsModelList) {
        	   userDTOList = new ArrayList<>();
	           for(UserDetailsModel userDetailsModel : userDetailsModelList) {
	        	   UserDetailsDTO userDetailsDTO = convertUserDetailsModelToUserDetailsDTO(userDetailsModel);
	        	   userDTOList.add(userDetailsDTO);
	           }
          }
        } catch (HibernateException e) {
           e.printStackTrace(); 
        } finally {
           session.close(); 
        }
		return userDTOList;
	}

	
	
	/*
	 * @Override public UserDetails getUserDetailsById(String uId) { UserDetails
	 * userDetails = null; for(UserDetails user : getAllUsers()) { if(null != uId &&
	 * user.getId().equals(Integer.valueOf(uId))) { userDetails = user; break; } }
	 * return userDetails; }
	 */
	
	
	
	

}
