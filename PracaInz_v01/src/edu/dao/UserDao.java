package edu.dao;

import java.util.ArrayList;
import java.util.List;

import edu.dao.db.UserDB;

public class UserDao {

	public List<UserDB> getExistingUsers() {
		List<UserDB> userList = OfyService.ofy().load().type(UserDB.class).chunkAll().list();
		if (userList == null) {
			userList = new ArrayList<UserDB>();			
		}
		return userList;
	}

	public void createUser (String name, int typeId) {
		Object userDB = new UserDB(name, typeId);
		OfyService.ofy().save().entity(userDB).now();
	}

	public UserDB getUser(String name) {
		UserDB userDB = OfyService.ofy().load().type(UserDB.class).id(name).now();
		return userDB;
	}
}
