package edu.dao.db;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

import javax.persistence.Embedded;
import java.util.ArrayList;
import java.util.List;

@Entity
public class VinylDB {
	@Id long id;
	String artist;
	String title;
	String description;
	int price;
	@Embedded List<TrackDB> sideA;
	@Embedded List<TrackDB> sideB;

	private VinylDB () {}
	
	public VinylDB (long id, String artist, String title, String description) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.price = 0;
		this.sideA = new ArrayList<TrackDB>();
		this.sideB = new ArrayList<TrackDB>();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<TrackDB> getSideA() {
		return sideA;
	}

	public void setSideA(List<TrackDB> sideA) {
		this.sideA = sideA;
	}

	public List<TrackDB> getSideB() {
		return sideB;
	}

	public void setSideB(List<TrackDB> sideB) {
		this.sideB = sideB;
	}

}
