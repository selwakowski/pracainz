package edu.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.model.SelectItem;

import edu.dao.UserDao;
import edu.dao.db.UserDB;
import edu.type.UserType;

@ManagedBean(name="loginBean")
@RequestScoped
public class LoginBean {
		
	private String login;
	private String email;
	private String mobile;
	private String password;
	private UserType userType;
	
	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	public void create() {
		UserDao userDao = new UserDao();
		System.out.println("userType: "+userType);
		userDao.createUser(login, userType.getId());
	}

	public void login() {
		UserDao userDao = new UserDao();
		UserDB userDB = userDao.getUser(login);
		if (userDB != null) {
			setUserTypeId(userDB.getTypeId());
		}
	}

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

	public void setUserTypeId(int userTypeId) {
		
		for (UserType userType : UserType.values()) {
			if (userType.getId() == userTypeId) {
				this.userType = userType;
			}
		}
	}	

	public int getUserTypeId() {
		return 0;
	}

	
	public String getPassword() {
		return "";
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
}
