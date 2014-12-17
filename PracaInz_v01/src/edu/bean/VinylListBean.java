package edu.bean;

import edu.dao.VinylDao;
import edu.dao.db.TrackDB;
import edu.dao.db.VinylDB;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean(name = "vinylListBean")
@ViewScoped
public class VinylListBean {

    private List<VinylDB> vinylList;

    @ManagedProperty(value = "#{navigationBean}")
    private NavigationBean navigationBean;

    public VinylListBean() {
        VinylDao dao = new VinylDao();
        List<VinylDB> vinylDBList = dao.getAll();
        vinylList = new ArrayList<VinylDB>();
        if (vinylDBList != null) {
            vinylList = vinylDBList;
        }
    }

    public void setNavigationBean(NavigationBean navigationBean) {
        this.navigationBean = navigationBean;
    }




    public List<VinylDB> getVinylList() {
        return vinylList;
    }

    public void setVinylList(List<VinylDB> vinylList) {
        this.vinylList = vinylList;
    }

}
