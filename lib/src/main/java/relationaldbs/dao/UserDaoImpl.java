package relationaldbs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import relationaldbs.model.User;

public class UserDaoImpl implements UserDao {

	private final static String postgresqlURL = "jdbc:postgresql://localhost:5432/postgres";

	private static String username = "postgres";
	private static String password = "Admin";

	@Override
	public boolean insert(User user) {
		// insert sql

		String insertSQL = "insert into users(name,password,balance,email,phone,age,gender,city) "
				+ "values (?,?,?,?,?,?,?,?)";

		try (Connection conn = DriverManager.getConnection(postgresqlURL, username, password);
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
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean delete(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User find(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> findall() {
		// TODO Auto-generated method stub
		return null;
	}

}
