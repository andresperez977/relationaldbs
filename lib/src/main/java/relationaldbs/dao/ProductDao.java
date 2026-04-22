package relationaldbs.dao;

import java.util.List;

import relationaldbs.model.Producto;
import relationaldbs.model.User;

public interface ProductDao {
public boolean insert(Producto producto);
	
	
	public boolean delete(Long id);
	
	
	public boolean update(Producto producto);
	
	
	public Producto find(Long id);
	
	public List<Producto> findall();
	 
	public  boolean createTable();
}
