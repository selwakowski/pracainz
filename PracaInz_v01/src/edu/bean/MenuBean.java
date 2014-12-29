package edu.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "menuBean")
@SessionScoped
public class MenuBean implements Serializable {
    private static final long serialVersionUID = 1L;


    @ManagedProperty(value = "#{vinylListBean}")
    private VinylListBean vinylListBean;


	public void setVinylListBean(VinylListBean vinylListBean) {
		this.vinylListBean = vinylListBean;
	}

    @ManagedProperty(value = "#{navigationBean}")
    private NavigationBean navigationBean;

    public void setNavigationBean(NavigationBean navigationBean) {
        this.navigationBean = navigationBean;
    }

    @ManagedProperty(value = "#{vinylBean}")
    private VinylBean vinylBean;

    public void setVinylBean(VinylBean vinylBean) {
		this.vinylBean = vinylBean;
	}
    
    public String toVinylList() {
    	vinylListBean.init();
    	return navigationBean.toVinylList();
    }

    public String toVinylSaleList() {
    	vinylListBean.init();
    	return navigationBean.toVinylListRedirect();
    }

    public String createVinyl() {
    	vinylBean.reset();
    	return navigationBean.toVinylEdit();
    }
}
