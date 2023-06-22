package com.mahesh.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mahesh.servlets.dto.UserDetailsDTO;
import com.mahesh.utils.JDBCUtils;

public class UserDetailsJDBCDAOImpl implements UserDetailsDAO{

	@Override
	public Boolean checkUserDetailsWithDatabase(String uname, String pass) {
		Connection connection = null;
    	PreparedStatement statement = null;
    	ResultSet  resultSet = null;
    	Boolean result = false;
    	try {
            // This will load the MySQL driver, each DB has its own driver
        	connection = JDBCUtils.getConnection();
        	//connection = getConnection();
            // Statements allow to issue SQL queries to the database
        	statement = connection.prepareStatement("select * from user_details");
        	resultSet = statement.executeQuery();
        	if(null != resultSet) {
        		while (resultSet.next()) {
                    String username = resultSet.getString("username");
                    String password = resultSet.getString("password");
                    Integer id = resultSet.getInt("user_id");
                    System.out.println("Request user details - username: " + uname+" password: " + pass);
                    System.out.println("Database user details - id : " + id +" username: " + username+" password: " + password);
                    if(null != username &&  null != password){
                    	 if(username.equals(uname) && password.equals(pass)) {
                    		 result = true;
                    		 break;
                         }	
                    }
        		}
        	}
        } catch (Exception e) {
          System.out.println(e); 
        } finally {
        	JDBCUtils.close(resultSet,statement,null,connection);
        }
		return result;
	}
	
	
	@Override
	public UserDetailsDTO getUserDetailsByDatabase(String uname, String pass) {
		Connection connection = null;
    	PreparedStatement statement = null;
    	ResultSet  resultSet = null;
    	UserDetailsDTO userDetailsRef = null;
    	try {
            // This will load the MySQL driver, each DB has its own driver
        	connection = JDBCUtils.getConnection();
        	//connection = getConnection();
            // Statements allow to issue SQL queries to the database
        	statement = connection.prepareStatement("select * from user_details");
        	resultSet = statement.executeQuery();
        	if(null != resultSet) {
        		while (resultSet.next()) {
        		    Integer id = resultSet.getInt("user_id");
                    String username = resultSet.getString("username");
                    String password = resultSet.getString("password");
                    String address= resultSet.getString("address");
                    System.out.println("Database user details - id : " + id +" username: " + username+" password: " + password+" address "+address);
                    if(null != username &&  null != password){
                    	 if(username.equals(uname) && password.equals(pass)) {
                    		 userDetailsRef = new UserDetailsDTO();
                    		 userDetailsRef.setId(id);
                    		 userDetailsRef.setUserName(username);
                    		 userDetailsRef.setPassword(password);
                    		 userDetailsRef.setAddress(address);
                    		 break;
                         }	
                    }
        		}
        	}
        } catch (Exception e) {
          System.out.println(e); 
        } finally {
        	JDBCUtils.close(resultSet,statement,null,connection);
        }
		return userDetailsRef;
	}
	
	@Override
	public UserDetailsDTO addUserDetailsInDatabase(String name, String pass, String address) {
		Connection connection = null;
    	PreparedStatement statement = null;
    	ResultSet  resultSet = null;
    	UserDetailsDTO userDetailsRef = null;
    	try {
            // This will load the MySQL driver, each DB has its own driver
        	connection = JDBCUtils.getConnection();
        	//connection = getConnection();
            // Statements allow to issue SQL queries to the database
        	statement = connection.prepareStatement("insert into user_details(username,password,address) values (?,?,?)");
        	statement.setString(1, name);
        	statement.setString(2, pass);
        	statement.setString(3, address);
        	int count = statement.executeUpdate();
        	if(count > 0) {
        		userDetailsRef = getUserDetailsByDatabase(name, pass);
        	}
    	} catch (Exception e) {
          System.out.println(e); 
        } finally {
        	JDBCUtils.close(resultSet,null,statement,connection);
        }
		return userDetailsRef;
	}
	
	
	
	
	
	
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		// Setup the connection with the DB
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/stud_info?"+"user=root&password=root");
		return connection;
	}

	@Override
	public List<UserDetailsDTO> getAllUsers() {
		System.out.println("getAllUsers : using jdbc");
		Connection connection = null;
    	PreparedStatement statement = null;
    	ResultSet  resultSet = null;
    	List<UserDetailsDTO> userList= null;
    	try {
            // This will load the MySQL driver, each DB has its own driver
        	connection = JDBCUtils.getConnection();
        	//connection = getConnection();
            // Statements allow to issue SQL queries to the database
        	statement = connection.prepareStatement("select * from user_details");
        	resultSet = statement.executeQuery();
        	if(null != resultSet) {
        		userList = new ArrayList<>();
        		while (resultSet.next()) {
        		    Integer id = resultSet.getInt("user_id");
                    String username = resultSet.getString("username");
                    String password = resultSet.getString("password");
                    String address= resultSet.getString("address");
                    //System.out.println("Database user details - id : " + id +" username: " + username+" password: " + password+" address "+address);
                	UserDetailsDTO userDetailsRef = new UserDetailsDTO();
		    		 userDetailsRef = new UserDetailsDTO();
		    		 userDetailsRef.setId(id);
		    		 userDetailsRef.setUserName(username);
		    		 userDetailsRef.setPassword(password);
		    		 userDetailsRef.setAddress(address);
		    		 System.out.println(userDetailsRef);
		    		 userList.add(userDetailsRef);
        		}
        	}
        } catch (Exception e) {
          System.out.println(e); 
        } finally {
        	JDBCUtils.close(resultSet,statement,null,connection);
        }
		return userList;
	}

	@Override
	public List<UserDetailsDTO> deleteUserDetails(String userId) {
		Connection connection = null;
    	PreparedStatement statement = null;
    	ResultSet  resultSet = null;
    	List<UserDetailsDTO> userList= null;
    	try {
            // This will load the MySQL driver, each DB has its own driver
        	connection = JDBCUtils.getConnection();
        	//connection = getConnection();
            // Statements allow to issue SQL queries to the database
        	statement = connection.prepareStatement("delete from user_details where user_id=?");
        	statement.setInt(1,Integer.valueOf(userId));
        	int count = statement.executeUpdate();
        	if(count > 0) {
        		userList  = getAllUsers();
        	}
    	} catch (Exception e) {
          System.out.println(e); 
        } finally {
        	JDBCUtils.close(resultSet,null,statement,connection);
        }
		return userList;
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
		Connection connection = null;
    	PreparedStatement statement = null;
    	ResultSet  resultSet = null;
    	List<UserDetailsDTO> userList= null;
    	try {
            // This will load the MySQL driver, each DB has its own driver
        	connection = JDBCUtils.getConnection();
        	//connection = getConnection();
            // Statements allow to issue SQL queries to the database
        	statement = connection.prepareStatement("update user_details set username=?,password=?,address=? where user_id=?");
        	
        	statement.setString(1, newUserDetails.getUserName());
        	statement.setString(2, newUserDetails.getPassword());
        	statement.setString(3, newUserDetails.getAddress());
        	
        	statement.setInt(4,newUserDetails.getId());
        	int count = statement.executeUpdate();
        	if(count > 0) {
        		userList  = getAllUsers();
        	}
    	} catch (Exception e) {
          System.out.println(e); 
        } finally {
        	JDBCUtils.close(resultSet,null,statement,connection);
        }
		return userList;
	}


	@Override
	public List<UserDetailsDTO> searchUserDetails(String name, String address) {
		// TODO Auto-generated method stub
		
		
		return null;
	}
}
