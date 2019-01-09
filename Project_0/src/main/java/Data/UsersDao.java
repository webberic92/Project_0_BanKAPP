package Data;
import Utility.ConnectionUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Pojos.Users;

	public class UsersDao  {
		
		ConnectionUtil connectionUtil;
		
	public UsersDao () {}
	
public UsersDao(ConnectionUtil connectionUtil) {
	this.connectionUtil = connectionUtil;
			// TODO Auto-generated constructor stub
		}

	public Users getByID(int id) {
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
					a.setUserID(rs.getInt("user_id"));
					a.setUsername(rs.getString("username"));
					a.setPassword(rs.getString("password"));
					a.setCreditscore(rs.getInt("creditscore"));

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



//LIST ALL USERS
	public List<Users> getAll() {
		Connection c = null;
		List <Users> users = null;
			try {
				c = connectionUtil.newConnection();
				c.setAutoCommit(false);
				users = new ArrayList<Users>();
				String sql = "select Project_0.userlogintable. \"user_id\", Project_0.userlogintable. \"username\", Project_0.userlogintable. \"password\", Project_0.userlogintable. \"creditscore\" "+"from Project_0.userlogintable";
//				String sql ="select  from Project_0.userlogintable";
				PreparedStatement ps = c.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					Users temp = new Users();
					temp.setUserID(rs.getInt("user_id"));
					temp.setUsername(rs.getString("username"));
					temp.setPassword(rs.getString("password"));
					temp.setCreditscore(rs.getInt("creditscore"));
					users.add(temp);}
				ps.close();
				c.commit();
				c.setAutoCommit(true);
				return users;
				} catch  (SQLException ex) {
				ex.printStackTrace();
			try {
				c.rollback();}
			catch (SQLException e) {
				e.printStackTrace();
			}}
		finally {
				if (c !=null) {
					try { 
						c.close();}
					catch (SQLException e) {
						e.printStackTrace();
					}}}
		return users;
		
	}
	}
	
	
