package edu.dao.db;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class SequenceGenerator {
	
	@Id String id;
	
	long nextVinylId;
	
	public long getNextVinylId() {
		return nextVinylId++;
	}

	public String getId() {
		return id;
	}

	private SequenceGenerator() {}
	
	public SequenceGenerator(String id) {
		this.id = id;
	}
}
