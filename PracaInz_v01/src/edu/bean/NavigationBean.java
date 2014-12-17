package edu.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="navigationBean")
@SessionScoped

public class NavigationBean implements Serializable {


	private static final String REDIRECT = "?faces-redirect=true";

	private static final long serialVersionUID = 1L;

	@ManagedProperty(value="#{userBean}")
	private UserBean userBean;
	
	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	public String toLogin() {
		return "/pages/login/login.xhtml";
	}
	public String toLoginRedirect() {
		return toLogin()+REDIRECT;
	}
	
	public String toNewUser() {
		return "/pages/login/newUser.xhtml";
	}
	
	public String toNewUserRedirect() {
		return toNewUser()+REDIRECT;
	}

	public String toWelcome() {
		switch (userBean.getUserType()) {
		case ADMIN:
			return "/pages/admin/vinylList.xhtml";
		case CUSTOMER:
			return "/pages/customer/welcome.xhtml";

		default:
			return "/pages/login/login.xhtml";
		}
	}
	public String toVinylEdit() {
		return "/pages/admin/editVinyl.xhtml";
	}

	public String toUserList() {
		return "/pages/admin/userList.xhtml";
	}
	public String toVinylList() {
		return "/pages/admin/VinylList.xhtml";
	}
	public String toWelcomeRedirect() {
		return toWelcome()+REDIRECT;
	}

}
