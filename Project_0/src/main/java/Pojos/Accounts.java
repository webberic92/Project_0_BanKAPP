package Pojos;

public class Accounts {
	
	private int account_id;
	private int user_id;
	private String account_type;
	private double balance;
	
	
	
	
	
	@Override
	public String toString() {
		return "Accounts [account_id=" + account_id + ", user_id=" + user_id + ", account_type=" + account_type
				+ ", balance=$" + balance + "]";
	}


	public Accounts() {}




	public int getAccount_id() {
		return account_id;
	}




	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}




	public int getUser_id() {
		return user_id;
	}




	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}




	public String getAccount_type() {
		return account_type;
	}




	public void setAccount_type(String account_type) {
		this.account_type = account_type;
	}




	public double getBalance() {
		return balance;
	}




	public double setBalance(double d) {
		return this.balance = d;
	}

	
}
