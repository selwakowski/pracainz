package edu.dao;

import java.util.ArrayList;
import java.util.List;

import edu.dao.db.UserDB;
import edu.type.UserType;
import edu.util.PasswordUtils;

public class UserDao {

	public List<UserDB> getExistingUsers() {
		List<UserDB> userList = OfyService.ofy().load().type(UserDB.class).chunkAll().list();
		if (userList == null) {
			userList = new ArrayList<UserDB>();			
		}
		return userList;
	}

	public UserDB getUser(String name) {
		UserDB userDB = OfyService.ofy().load().type(UserDB.class).id(name).now();
		return userDB;
	}

	public UserDB createUser(String name, String realName, String password, UserType userType,
			String mobile, String email) {
		String hash = PasswordUtils.hashPassword(password);
		UserDB userDB = new UserDB(name, realName, userType.getId(), hash, mobile, email);
		OfyService.ofy().save().entity(userDB).now();
		return userDB;
		
	}
}
