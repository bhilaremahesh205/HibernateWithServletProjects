package com.mahesh.constants;

public enum UserActionEnum {

	EDIT("edit"), DELETE("delete"), MODIFY_USER_DETAILS("modifyUserDetails"), SEARCH("search"); 
	  
    // declaring private variable for getting values 
    private String action; 
  
    // getter method 
    public String getAction() 
    { 
        return this.action; 
    } 
  
    // enum constructor - cannot be public or protected 
    private UserActionEnum(String action) 
    { 
        this.action = action; 
    } 
}
