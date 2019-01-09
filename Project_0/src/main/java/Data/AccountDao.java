package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Pojos.Accounts;
import Pojos.Transactions;
import Pojos.Users;
import Utility.ConnectionUtil;

public class AccountDao {
	ConnectionUtil connectionUtil;
	
public AccountDao() {}
	
	public AccountDao(ConnectionUtil connectionUtil) {
		this.connectionUtil = connectionUtil;
	}
	
	
	public Accounts getByID(int id) {
		
		Connection connection = null;
		Accounts a = null;		
		try {
			connection = this.connectionUtil.newConnection();
			connection.setAutoCommit(false);
			String sql = "select * from project_0.useraccounttable where \"account_id\" = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				a = new Accounts();
				a.setAccount_id(rs.getInt("account_id"));
				a.setUser_id(rs.getInt("user_id"));
				a.setAccount_type(rs.getString("account_type"));	
				a.setBalance(rs.getDouble("balance"));
			}
			 ps.close();
			connection.commit();
			connection.setAutoCommit(true);
			return a;
		}	catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}}}
		return a;
	}

	public Accounts withdrawCash(int id, int withdrawlAmount) {
		Connection connection = null;
		Accounts a = null;		
		try {
			connection = this.connectionUtil.newConnection();
			connection.setAutoCommit(false);
			String sql = "select * from project_0.useraccounttable where \"account_id\" = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				a = new Accounts();
				a.setAccount_id(rs.getInt("account_id"));
				a.setUser_id(rs.getInt("user_id"));
				a.setAccount_type(rs.getString("account_type"));	
				a.setBalance(rs.getDouble("balance"));
				
				
				if((rs.getDouble("balance") - withdrawlAmount) >= 0){
					System.out.println("This does NOT make your account go negative");
					System.out.println("Processing Withdrawl of :$ " + withdrawlAmount + " From ACCOUNT# " + id );
					//a.setBalance(rs.getDouble("balance")- withdrawlAmount);
					sql = "Update project_0.useraccounttable set balance = ? where account_id=?";
					ps = connection.prepareStatement(sql);
			           
					ps.setInt(1, (int) a.setBalance(rs.getDouble("balance") - withdrawlAmount));
					//ps.setInt(1, withdrawlAmount);
			           ps.setInt(2,id);
			           
			           ps.executeUpdate();
			           connection.commit();
			           
			           sql = "insert into project_0.transactiontable (account_id, transaction_type, amount) values (?,'LOST',?)";
						ps = connection.prepareStatement(sql);
				           
						ps.setInt(1, id);
				       ps.setInt(2,withdrawlAmount);
			           ps.executeUpdate();
			           connection.commit();
				}else System.out.println("You can not subtract what you do not have.");
			}
			ps.close();
			connection.commit();
			connection.setAutoCommit(true);
			return a;

		}	catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}}}
		return a;
	}

	public Accounts depositCash(int id, int depositAmount) {
		
			Connection connection = null;
			Accounts a = null;		
			try {
				connection = this.connectionUtil.newConnection();
				connection.setAutoCommit(false);
				String sql = "select * from project_0.useraccounttable where \"account_id\" = ?";
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setInt(1, id);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					a = new Accounts();
					a.setAccount_id(rs.getInt("account_id"));
					a.setUser_id(rs.getInt("user_id"));
					a.setAccount_type(rs.getString("account_type"));	
					a.setBalance(rs.getDouble("balance"));
					
			
						System.out.println("Processing DEPOSIT of :$" + depositAmount + " To ACCOUNT# " + id );
						sql = "Update project_0.useraccounttable set balance=? where account_id=?";
						ps = connection.prepareStatement(sql);
				           
						ps.setInt(1, (int) a.setBalance(rs.getDouble("balance")+ depositAmount));
				           ps.setInt(2,id);
				           
				           ps.executeUpdate();
				           connection.commit();

				           
				           sql = "insert into project_0.transactiontable (account_id, transaction_type, amount) values (?,'GAINED',?)";
							ps = connection.prepareStatement(sql);
					           
							ps.setInt(1, id);
					       ps.setInt(2,depositAmount);
				           ps.executeUpdate();
				                     
						connection.commit();
				 ps.close();
				connection.commit();
				connection.setAutoCommit(true);
				return a;
				}
			}	catch (SQLException e) {
				e.printStackTrace();
			}finally {
				if (connection != null) {
					try {
						connection.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}}}
			return a;
		}

	public Users requestCreditcard(int id) {
		Connection connection = null;
		Users a = null;		
		try {
			connection = this.connectionUtil.newConnection();
			connection.setAutoCommit(false);
			String sql = "select * from project_0.userlogintable where \"user_id\" = ?";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				a = new Users();
				
//				a.setUserID(rs.getInt("user_id"));
//				a.setUsername(rs.getString("username"));	
				a.setCreditscore(rs.getInt("creditscore"));
				
				if((rs.getDouble("creditscore")  >= 700)){
					System.out.println("CONGRATULATIONS YOU HAVE BEEN APPROVED !");
					System.out.println("YOUR CREDIT SCORE WAS : " + rs.getDouble("creditscore") );

				}	
					if((rs.getDouble("creditscore") <=700 && rs.getDouble("creditscore") >500)){
						System.out.println("YOUR APPLICATION IS UNDER REVIEW !");	
						System.out.println("YOUR SCORE OF : " + rs.getDouble("creditscore") + " IS NOT THAT GREAT BUT NOT HORRIBLE.");	
	
					}			
						else if ((rs.getInt("creditscore")  <= 500)){
							System.out.println("SORRY YOU HAVE BEEN DENIED!");	
							System.out.println("YOUR SCORE OF : " + rs.getDouble("creditscore") + " IS HORRIBLE.");	

					
			    
					connection.commit();
			 ps.close();
			connection.commit();
			connection.setAutoCommit(true);
			return a;
			}}}
			catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if (connection != null) {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}}}
		return a;
	}

	public Accounts transferMoney(int you, int me, int amount) {

		
		
		 System.out.println("Hello, you chose to TRANSFER the amount of:  $" + amount + " To AccountID : " + you);


		 Connection connection = null;
			Accounts a = null;		
			try {
				connection = this.connectionUtil.newConnection();
				connection.setAutoCommit(false);
				String sql = "select * from project_0.useraccounttable where \"account_id\" = ?";
				PreparedStatement ps = connection.prepareStatement(sql);
				ps.setInt(1, me);
				ResultSet rs = ps.executeQuery();
				while (rs.next()) {
					a = new Accounts();
					a.setAccount_id(rs.getInt("account_id"));
					a.setUser_id(rs.getInt("user_id"));
					a.setAccount_type(rs.getString("account_type"));	
					a.setBalance(rs.getDouble("balance"));
					
					sql = "insert into project_0.transactiontable (account_id, transaction_type, amount) values (?,'LOST',?)";
					ps = connection.prepareStatement(sql);
			           
					ps.setInt(1, me);
			       ps.setInt(2,amount);
		           ps.executeUpdate();
			       connection.commit();


					
					
			
						System.out.println("Processing DEPOSIT of :$" + amount );
						sql = "Update project_0.useraccounttable set balance=? where account_id=?";
						ps = connection.prepareStatement(sql);
				           
						ps.setInt(1, (int) a.setBalance(rs.getDouble("balance")+ amount));
				           ps.setInt(2,me);
				           ps.executeUpdate();
					       connection.commit();
				           
				           sql = "insert into project_0.transactiontable (account_id, tranasaction_type, amount) values (?,'Gained',?)";
							ps = connection.prepareStatement(sql);
					           
							ps.setInt(1, you);
					       ps.setInt(2,amount);
					       ps.executeUpdate();
					       connection.commit();
				           
				           
						connection.commit();
				 ps.close();
				connection.commit();
				connection.setAutoCommit(true);
				return a;
				}
			}	catch (SQLException e) {
				e.printStackTrace();
			}finally {
				if (connection != null) {
					try {
						connection.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}}}
			return a;
		}

}

