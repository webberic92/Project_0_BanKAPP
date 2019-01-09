package Pojos;

import Data.TransactionsDao;

public class Users {

	private int userID;
	private String username;
	private String password;
	private int creditscore;

	
	@Override
	public String toString() {
		return "Users [userID=" + userID + ", username=" + username + ", password=" + password + ", creditscore="
				+ creditscore + "]";
	}





	



	public Users() {}
	
	
	

	
		public int getUserID() {
		return userID;
	}


	public void setUserID(int userID) {
		this.userID = userID;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	public int getCreditscore() {
		return creditscore;
	}


	public void setCreditscore(int creditscore) {
		this.creditscore = creditscore;
	}
	
	
}

	
		
		

	
	



		