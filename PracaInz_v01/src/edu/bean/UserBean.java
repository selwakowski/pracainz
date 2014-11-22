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

	private String login;
	private UserType userType;
	private String email;
	private String mobile;

	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public UserType getUserType() {
		return userType;
	}
	public void setUserType(UserType userType) {
		this.userType = userType;
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