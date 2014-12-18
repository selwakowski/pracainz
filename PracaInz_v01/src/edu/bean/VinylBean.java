package edu.bean;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import edu.dao.VinylDao;
import edu.dao.db.TrackDB;
import edu.dao.db.VinylDB;
import org.primefaces.event.RowEditEvent;

@ManagedBean(name = "vinylBean")
@SessionScoped
public class VinylBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;
    private String artist;
    private String title;
    private int price;
    private String booked;
    private String bookedby;
	private String description;
    private List<TrackDB> sideA;
    private List<TrackDB> sideB;

    private String titleA;
    private String titleB;
    private String lenA;
    private String lenB;


    public String saveVinyl() {
        VinylDao dao = new VinylDao();
        VinylDB vinyl = null;
        if (id == 0) {
            vinyl = dao.createVinyl();
        } else {
            vinyl = dao.getVinyl(id);
        }
        vinyl.setArtist(artist);
        vinyl.setDescription(description);
        vinyl.setTitle(title);
        vinyl.setPrice(price);
        vinyl.setSideA(sideA);
        vinyl.setSideB(sideB);

        dao.save(vinyl);

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
        this.sideA = vinylDB.getSideA();
        this.sideB = vinylDB.getSideB();
        this.id = vinylDB.getId();

        System.out.println(sideA.size());
    }

    public void onCancelA(RowEditEvent event) {
        sideA.remove(event.getObject());
    }

    public void onCancelB(RowEditEvent event) {
        sideB.remove(event.getObject());
    }

    public String addTrackA() {
        TrackDB newTrack = new TrackDB(titleA, lenA);
        sideA.add(newTrack);
        resetNewTrack();
        return null;
    }
    public String addTrackB() {
        TrackDB newTrack = new TrackDB(titleB, lenB);
        sideB.add(newTrack);
        resetNewTrack();
        return null;
    }

    private void resetNewTrack() {
        titleA = "";
        lenA = "";
        titleB = "";
        lenB = "";
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

    public String getTitleA() {
        return titleA;
    }

    public void setTitleA(String titleA) {
        this.titleA = titleA;
    }

    public String getTitleB() {
        return titleB;
    }

    public void setTitleB(String titleB) {
        this.titleB = titleB;
    }

    public String getLenA() {
        return lenA;
    }

    public void setLenA(String lenA) {
        this.lenA = lenA;
    }

    public String getLenB() {
        return lenB;
    }

    public void setLenB(String lenB) {
        this.lenB = lenB;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
