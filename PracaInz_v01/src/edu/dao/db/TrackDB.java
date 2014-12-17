package edu.dao.db;

public class TrackDB {
    String title;
    String length;

    public TrackDB(String title, String length) {
        this.title = title;
        this.length = length;
    }

    TrackDB(){}

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
