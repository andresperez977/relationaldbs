package relationaldbs.test;

import relationaldbs.dao.UserDao;
import relationaldbs.dao.UserDaoImpl;
import relationaldbs.model.User;

public class UserDaoTest {
	public static void main(String[] args) {

		UserDao userDao = new UserDaoImpl();
		userDao.createTable();
		userDao.insert(new User(1L, "Andrés", "Admin", 0," andres@gmail.com", 654678908, "20", "men", "Madrid"));
		System.out.println(userDao.insert(new User(1L, "Andrés", "Admin", 0," andres@gmail.com", 654678908, "20", "men", "Madrid")));
		//System.out.println(userDao.delete(1L));
		
		
		System.out.println(userDao.update(new User(1L, "Andréss", "Adminn", 0," andres@gmail.com", 654678908, "20", "men", "Madrid")));
		System.out.println(userDao.find(1L));
		System.out.println(userDao.findall());
	} 
}  