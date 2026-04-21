package relationaldbs.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import relationaldbs.model.Producto;

public class ProductDaoImp implements ProductDao {
	
	private final static String postgresqlURL = "jdbc:postgresql://localhost:5432/postgres";

	private static String username = "postgres";
	private static String password = "Admin";
	
	String dropTableSQL = "drop table if exists users";
	String createTableSQL = "create table if not exists users(" + "id serial,"
			+ "name VARCHAR(255), " + "password VARCHAR(255)," +   "balance float," + "email VARCHAR(255)," + "phone numeric," 
			+ "age VARCHAR(255)," + "gender VARCHAR(255)," + "city VARCHAR(255),"
			+ "PRIMARY KEY (id)" + ")";
	
	
	
	

	@Override
	public boolean insert(Producto producto) {
		// TODO Auto-generated method stub
		String insertSQL = "insert into users(name,price,category,brand,stock) "
				+ "values (?,?,?,?,?,?,?,?)";

		try (Connection conn = DriverManager.getConnection(postgresqlURL, username, password);
				PreparedStatement pss =
						conn.prepareStatement(insertSQL);) {
			pss.setString(1,producto.getName());
			pss.setString(2,producto.getPrice());
			pss.setDouble(3,producto.getCategory());
			pss.setString(4, producto.getBrand());
			pss.setInt(5, producto.getStock());
			pss.executeUpdate();
			
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		
		
		return false;
	}

	@Override
	public boolean delete(Producto producto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Producto producto) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Producto find(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> findall() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean createTable() {
		// TODO Auto-generated method stub
		return false;
	}

	 
	
}
