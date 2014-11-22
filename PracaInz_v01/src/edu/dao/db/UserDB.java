package edu.dao.db;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class UserDB {

	@Id String name;
	String password;
	int typeId;
	
	@SuppressWarnings("unused")
	private UserDB() {}
	
	public UserDB(String name, int typeId) {
		this.name = name;
		this.typeId = typeId;
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

}
