package edu.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import edu.dao.db.UserDB;
import edu.type.UserType;
 
@ManagedBean(name="userBean")
@SessionScoped
public class UserBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;
	private UserType userType;
	private String email;
	private String mobile;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public void propagate(UserDB userDB) {
		setUserTypeId(userDB.getTypeId());
		this.name = userDB.getName();
		this.mobile = userDB.getMobile();
		this.email = userDB.getEmail();
		
	}
	public void setUserTypeId(int userTypeId) {
		
		for (UserType userType : UserType.values()) {
			if (userType.getId() == userTypeId) {
				this.userType = userType;
			}
		}
	}	


}