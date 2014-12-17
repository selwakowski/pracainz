package edu.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import edu.dao.VinylDao;
import edu.dao.db.TrackDB;
import edu.dao.db.VinylDB;

@ManagedBean(name = "vinylBean")
@SessionScoped
public class VinylBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private String artist;
    private String title;
    private int price;
    private String booked;
    private String bookedby;
	private String description;
    private List<TrackDB> sideA;
    private List<TrackDB> sideB;


    public String saveVinyl() {
        return navigationBean.toVinylList();
    }

    public String cancel() {
        return navigationBean.toVinylList();
    }

    public String doCreate() {
        VinylDao dao = new VinylDao();
        dao.createVinyl(artist, title, description);
        return navigationBean.toVinylList();
    }


    public void propagate(VinylDB vinylDB) {
    	this.artist = vinylDB.getArtist();
    	this.description = vinylDB.getDescription();
    	this.price = vinylDB.getPrice();
    	this.title = vinylDB.getTitle();
    }

    public void reset() {

    }

    @ManagedProperty(value = "#{navigationBean}")
    private NavigationBean navigationBean;

    public void setNavigationBean(NavigationBean navigationBean) {
        this.navigationBean = navigationBean;
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
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
