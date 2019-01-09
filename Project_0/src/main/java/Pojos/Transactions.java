package Pojos;

import Data.TransactionsDao;

public class Transactions {
	
	private int transaction_id;
	private int account_id;
	private String transaction_type;
	private int amount;
	
	
	
	
	@Override
	public String toString() {
		return "Transactions [transaction_id=" + transaction_id + ", account_id=" + account_id + ", transaction_type="
				+ transaction_type + ", amount=" + amount + "]";
	}
	public Transactions () {}


	public int getTransaction_id() {
		return transaction_id;
	}


	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}


	public int getAccount_id() {
		return account_id;
	}


	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}


	public String getTransaction_type() {
		return transaction_type;
	}


	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}


	public int getAmount() {
		return amount;
	}


	public void setAmount(int amount) {
		this.amount = amount;
	}
}
	
	
//	public String viewTransactions () {
//		String out = "";
//		TransactionsDao transaction = new TransactionsDao();
//		out = transaction.getTransactionsbyAccountId(this);
//		return out;
	