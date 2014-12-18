package edu.dao.db;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

import javax.persistence.Embedded;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class VinylDB implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id long id;
	String artist;
	String title;
	String description;
	int price;
	String booked;
	String bookedby;

	@Embedded List<TrackDB> sideA;
	@Embedded List<TrackDB> sideB;

	private VinylDB () {}
	
	public VinylDB (long id, String artist, String title, String description) {
		this.id = id;
		this.artist = artist;
		this.title = title;
		this.description = description;
		this.price = 0;
		this.booked = "NIE";
		this.bookedby = "";
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
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

	public String getBooked() {
		return booked;
	}

	public void setBooked(String booked) {
		this.booked = booked;
	}

	public String getBookedby() {
		return bookedby;
	}

	public void setBookedby(String bookedby) {
		this.bookedby = bookedby;
	}

}
