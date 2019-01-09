package Services;


import java.util.List;

import Data.UsersDao;
import Pojos.Users;


public class UserService {
	
	private UsersDao userDao;

	public UserService() {}
	
	public UserService (UsersDao userDao) {
		this.userDao = userDao;
	}
	
	public List<Users> findAllUsers() {
        return this.userDao.getAll();
    }
	
public  Users findUserID(int id) {
		
		return this.userDao.getByID(id);
	}



	
}
	





