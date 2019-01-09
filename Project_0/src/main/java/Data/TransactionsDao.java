package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import Pojos.Transactions;
import Utility.ConnectionUtil;

public class TransactionsDao {
	ConnectionUtil connectionUtil;
	Transactions transactions;

	public TransactionsDao () {}
	
	public  TransactionsDao(ConnectionUtil connectionUtil) {
		this.connectionUtil = connectionUtil;
	}
		
		public Transactions getTransactionsbyAccountId(int id) {
//			String out = "";
			Connection c = null;
			Transactions transactions = null;
				try {
					c = this.connectionUtil.newConnection();
					c.setAutoCommit(false);
					String sql = "select * from project_0.transactiontable where account_id =?";
					PreparedStatement ps = c.prepareStatement(sql);
					ps.setInt(1, id);
					ResultSet rs = ps.executeQuery();
					while(rs.next()) {
					    transactions = new Transactions();
			            transactions.setTransaction_id(rs.getInt("transaction_id"));
					    transactions.setAccount_id(rs.getInt("account_id"));
					    transactions.setTransaction_type(rs.getString("transaction_type"));
					    transactions.setAmount(rs.getInt("amount"));
						System.out.println("Transaction ID = " + rs.getInt("Transaction_id") + ", Account_ID = " + rs.getInt("account_id") + ", Transaction Type = " + rs.getString("transaction_type") + ", $" + rs.getInt("amount"));
						}
					System.out.println("Your MOST PREVIOUS Transaction is...");
					ps.close();
					c.commit();
					c.setAutoCommit(true);
					return transactions;
					} catch  (SQLException ex) {
					ex.printStackTrace();
					}finally {
					if (c !=null) {
						try { 
							c.close();
							}catch (SQLException e) {
							e.printStackTrace();
						}}}
			return transactions;
		}
}
		
		

	
	


