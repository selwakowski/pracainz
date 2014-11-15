package edu.dao.db;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class VinylDB {
	@Id long id;
	String name;

	private VinylDB () {}
	
	public VinylDB (long id, String name) {
		
	}
	
	public long getId() {
		return id;
	}

}
