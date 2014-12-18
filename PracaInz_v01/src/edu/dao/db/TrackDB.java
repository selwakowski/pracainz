package edu.dao.db;

import java.io.Serializable;

public class TrackDB implements Serializable {
    private static final long serialVersionUID = 1L;

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
