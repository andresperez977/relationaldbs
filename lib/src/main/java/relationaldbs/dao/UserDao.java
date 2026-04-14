package relationaldbs.dao;


import java.util.List;

import relationaldbs.model.User;

public interface UserDao {

	public boolean insert(User user);
	
	
	public boolean delete(User user);
	
	
	public boolean update(User user);
	
	
	public User find(Long id);
	
	public List<User> findall();
	
	
}
