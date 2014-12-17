package edu.bean;

import edu.dao.VinylDao;
import edu.dao.db.TrackDB;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.util.List;

@ManagedBean(name = "vinylBean")
@ViewScoped
public class VinylBean {

    private String artist;
    private String title;
    private int price;
    private long booked;
    private String description;
    private List<TrackDB> sideA;
    private List<TrackDB> sideB;

    @ManagedProperty(value = "#{navigationBean}")
    private NavigationBean navigationBean;

    public void setNavigationBean(NavigationBean navigationBean) {
        this.navigationBean = navigationBean;
    }

    public String doCreate() {
        VinylDao dao = new VinylDao();
        dao.createVinyl(artist, title, description);
        return navigationBean.toVinylList();
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

    public long getBooked() {
        return booked;
    }

    public void setBooked(long booked) {
        this.booked = booked;
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
