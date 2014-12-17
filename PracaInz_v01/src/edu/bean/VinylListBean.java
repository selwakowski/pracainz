package edu.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import edu.dao.VinylDao;
import edu.dao.db.VinylDB;

@ManagedBean(name = "vinylListBean")
@SessionScoped
public class VinylListBean implements Serializable {
    private static final long serialVersionUID = 1L;

    private List<VinylDB> vinylList;
    private VinylDB selectedVinyl;


	public void init() {
        VinylDao dao = new VinylDao();
        List<VinylDB> vinylDBList = dao.getAll();
        vinylList = new ArrayList<VinylDB>();
        if (vinylDBList != null) {
            vinylList = vinylDBList;
        }    	
    }

    public VinylListBean() {
    	init();
    }

    @ManagedProperty(value = "#{vinylBean}")
    private NavigationBean vinylBean;

    public void setVinylBean(NavigationBean vinylBean) {
		this.vinylBean = vinylBean;
	}

	@ManagedProperty(value = "#{navigationBean}")
    private NavigationBean navigationBean;

    public void setNavigationBean(NavigationBean navigationBean) {
        this.navigationBean = navigationBean;
    }


    public List<VinylDB> getVinylList() {
    	init();
        return vinylList;
    }

    public void setVinylList(List<VinylDB> vinylList) {
        this.vinylList = vinylList;
    }

    public VinylDB getSelectedVinyl() {
		return selectedVinyl;
	}

	public void setSelectedVinyl(VinylDB selectedVinyl) {
		this.selectedVinyl = selectedVinyl;
	}

}
