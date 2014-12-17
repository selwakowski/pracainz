package edu.dao.db;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class UserDB {

	@Id String name;

	String realName;
	String password;
	int typeId;
	String mobile;
	String email;
	
	@SuppressWarnings("unused")
	private UserDB() {}
	
	public UserDB(String name, String realName, int typeId, String password, String mobile, String email) {
		this.name = name;
		this.realName = realName;
		this.typeId = typeId;
		this.password = password;
		this.mobile = mobile;
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}
}
