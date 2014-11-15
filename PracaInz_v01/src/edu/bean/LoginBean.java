package edu.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import edu.dao.UserDao;
import edu.dao.db.UserDB;
import edu.type.UserType;

@ManagedBean(name="loginbean")
@RequestScoped
public class LoginBean {
		
	public List<SelectItem> getUserTypes() {
		List<SelectItem> userTypes = new ArrayList<SelectItem>();
		
		for (UserType userType : UserType.values()) {
			SelectItem selectItem = new SelectItem(userType.getId(), userType.getName());
			userTypes.add(selectItem);
		}
		return userTypes;
	}
	
	public List<SelectItem> getExistingUsers() {
		List<SelectItem> existingUsers = new ArrayList<SelectItem>();
		
		UserDao userDao = new UserDao();
		List<UserDB> existingUsersDB = userDao.getExistingUsers();
		for (UserDB userDB : existingUsersDB) {
			SelectItem selectItem = new SelectItem(userDB.getName());
			existingUsers.add(selectItem);
		}
		return existingUsers;
	}
	
}
