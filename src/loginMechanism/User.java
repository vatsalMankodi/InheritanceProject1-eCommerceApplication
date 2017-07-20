package loginMechanism;

import java.util.*;


public abstract class User {
	protected String userId; 
	protected String password; 
	public User(){
		
	}
	public abstract void loggedIn();
	
	public User(String uid, String pwd){
		userId = uid;
		password = pwd;	
	}
	public boolean equals(User a){
		if((this.userId.equals(a.userId)) && (this.password.equals(a.password)) )
			return true;
		else return false;
	}
	void setUserId(String uid){
		userId = uid;
	}
	void setPassword(String pwd){
		password = pwd;
	}
	public String getUserId(){
		return userId;
	}
	public String getPassword(){
		return password;
	}
	
}
