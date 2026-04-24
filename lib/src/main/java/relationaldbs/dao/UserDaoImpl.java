package relationaldbs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import relationaldbs.model.User;
import relationaldbs.util.DBHelper;

public class UserDaoImpl implements UserDao {

	
	
	String dropTableSQL = "drop table if exists users";
	String createTableSQL = "create table if not exists users(" + "id serial,"
			+ "name VARCHAR(255), " + "password VARCHAR(255)," +   "balance float," + "email VARCHAR(255)," + "phone numeric," 
			+ "age VARCHAR(255)," + "gender VARCHAR(255)," + "city VARCHAR(255),"
			+ "PRIMARY KEY (id)" + ")";

	
	@Override
	public boolean insert(User user) {  
				// insert sql

		String insertSQL = "insert into users(name,password,balance,email,phone,age,gender,city) "
				+ "values (?,?,?,?,?,?,?,?)";

		try (Connection conn = DBHelper.getConnection();
				PreparedStatement pss =
						conn.prepareStatement(insertSQL);) {
			pss.setString(1,user.getName());
			pss.setString(2,user.getPassword());
			pss.setDouble(3,user.getBalance());
			pss.setString(4, user.getEmail());
			pss.setInt(5, user.getPhone());
			pss.setString(6, user.getAge());
			pss.setString(7, user.getGender());
			pss.setString(8, user.getCity());
			pss.executeUpdate();
			
			return true;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(Long id) {
		 String deleteSQL = "DELETE FROM users WHERE id = ?";

		    try (Connection conn =  DBHelper.getConnection();
		         PreparedStatement pss = conn.prepareStatement(deleteSQL)) {

		        pss.setLong(1, id);
		        pss.executeUpdate();

		        return true;

		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return false;
		
	}

	@Override
	public boolean update(User user) {
		
		 String updateSQL = "insert into users(name,password,balance,email,phone,age,gender,city) "
					+ "values (?,?,?,?,?,?,?,?)";

		    try (Connection conn =DBHelper.getConnection();
		         PreparedStatement pss = conn.prepareStatement(updateSQL)) {

		        pss.setString(1, user.getName());
		        pss.setString(2, user.getPassword());
		        pss.setDouble(3, user.getBalance());
		        pss.setString(4, user.getEmail());
		        pss.setLong(5, user.getPhone());
		    	pss.setString(6, user.getAge());
		        pss.setString(7, user.getGender());
		        pss.setString(8, user.getCity());
		        pss.executeUpdate();

		        return true;

		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return false;
		}
	@Override
	public User find(Long id) {
		
		 String findSQL = "SELECT * FROM users WHERE id = ?";

		    try (Connection conn = DBHelper.getConnection();
		         PreparedStatement pss = conn.prepareStatement(findSQL)) {

		        pss.setLong(1, id);
		        ResultSet rs =
		        pss.executeQuery();
		      if( rs.next()) {
		    	  rs.getString("name");
		    	  System.out.println(rs.getString("name"));
		    	  
		    	  
		    	   

		      }

		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return null;
		}
		
		
		
	

	@Override
	public List<User> findall() {
		 String findSQL = "SELECT * FROM users";

		    try (Connection conn = DBHelper.getConnection();
		         PreparedStatement pss = conn.prepareStatement(findSQL)) {

		        
		        ResultSet rs =
		        pss.executeQuery();
		      while( rs.next()) {
		    	  rs.getString("name");
		    	  System.out.println(rs.getString("name"));
		      }

		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		
		
		return null;
	}

	@Override
	public boolean createTable() {
		// TODO Auto-generated method stub
		try (Connection conn = DBHelper.getConnection();
				PreparedStatement drop =
						conn.prepareStatement(dropTableSQL ); PreparedStatement create =
						conn.prepareStatement(createTableSQL );) {
			
			drop.executeUpdate();
			create.executeUpdate();
			
			return true;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		return false;
	}

}
