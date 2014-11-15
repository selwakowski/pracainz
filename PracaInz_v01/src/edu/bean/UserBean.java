package edu.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import edu.dao.UserDao;
import edu.dao.db.UserDB;
import edu.type.UserType;
 
@ManagedBean(name="user")
@SessionScoped
public class UserBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private UserType userType;

	

	public int getUserTypeId() {
		return 0;
	}

	public void setUserTypeId(int userTypeId) {
		
		for (UserType userType : UserType.values()) {
			if (userType.getId() == userTypeId) {
				this.userType = userType;
			}
		}
		System.out.println("set userType: "+userType);

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setExistingUser(String name) {
		
	}

	public String getExistingUser() {
		return "";
	}

	public void create() {
		UserDao userDao = new UserDao();
		System.out.println("userType: "+userType);
		userDao.createUser(name, userType.getId());
	}

	public void login() {
		UserDao userDao = new UserDao();
		UserDB userDB = userDao.getUser(name);
		if (userDB != null) {
			setUserTypeId(userDB.getTypeId());
		}
	}
}