package relationaldbs.test;

import relationaldbs.dao.UserDao;
import relationaldbs.dao.UserDaoImpl;
import relationaldbs.model.User;

public class UserDaoTest {
	public static void main(String[] args) {

		UserDao userDao = new UserDaoImpl();
		userDao.insert(new User(1, "Andrés", "Admin", 0," andres@gmail.com", "654678908", "20", "men", "Madrid"));
	}
}