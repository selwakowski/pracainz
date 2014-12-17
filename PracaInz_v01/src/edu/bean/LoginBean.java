package edu.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;

import edu.dao.UserDao;
import edu.dao.db.UserDB;
import edu.type.UserType;
import edu.util.PasswordUtils;

@ManagedBean(name = "loginBean")
//@Named("loginBean")
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private String realName;
	private String email;
	private String mobile;
	private String password;
	private UserType userType;

	@ManagedProperty(value = "#{userBean}")
	private UserBean userBean;

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	@ManagedProperty(value = "#{navigationBean}")
	private NavigationBean navigationBean;

	public void setNavigationBean(NavigationBean navigationBean) {
		this.navigationBean = navigationBean;
	}

	public String doCreate() {
		UserDao userDao = new UserDao();
		UserDB userDB = userDao.getUser(name);
		if (userDB != null) {
			return loginError("user.exists");
		}
		userDB = userDao.createUser(name, realName, password, userType, mobile,
				email);
		userBean.propagate(userDB);
		return navigationBean.toWelcome();
	}

	public String doLogin() {
		if (name == null || "".equals(name)) {
			return loginError("user.name.required");
		}
		if (password == null || "".equals(password)) {
			return loginError("password.required");
		}
		
		UserDao userDao = new UserDao();
		UserDB userDB = userDao.getUser(name);

		if (userDB != null) {
			if (PasswordUtils.isPasswordMatch(password, userDB.getPassword())) {
				userBean.propagate(userDB);
				return navigationBean.toWelcomeRedirect();
			}
		}
		return loginError("login.invalid");
		// String userName = (String) component.getAttributes().get("userName");
	}

	private String loginError(String message) {
		ResourceBundle bundle = ResourceBundle.getBundle("resources/message");
		FacesMessage msg = new FacesMessage(bundle.getString(message),
				"ERROR MSG");
		msg.setSeverity(FacesMessage.SEVERITY_ERROR);
		FacesContext.getCurrentInstance().addMessage(null, msg);
		return navigationBean.toLogin();
	}

	public List<SelectItem> getUserTypes() {
		List<SelectItem> userTypes = new ArrayList<SelectItem>();

		for (UserType userType : UserType.values()) {
			SelectItem selectItem = new SelectItem(userType.getId(),
					userType.getName());
			userTypes.add(selectItem);
		}
		return userTypes;
	}

	public List<SelectItem> getExistingUsers() {
		List<SelectItem> existingUsers = new ArrayList<SelectItem>();

		UserDao userDao = new UserDao();
		List<UserDB> existingUsersDB = userDao.getExistingUsers();
		for (UserDB userDB : existingUsersDB) {
			SelectItem selectItem = new SelectItem(userDB.getName());
			existingUsers.add(selectItem);
		}
		return existingUsers;
	}

	public void checkUserExists(FacesContext ctx, UIComponent component,
			Object value) throws ValidatorException {
		String userName = value.toString();
		UserDao userDao = new UserDao();
		if (userDao.getUser(userName) != null) {
			ResourceBundle bundle = ResourceBundle.getBundle("message");
			throw new ValidatorException(new FacesMessage(
					bundle.getString("user.exists")));
		}
	}

	public void checkUserPassword(FacesContext ctx, UIComponent component,
			Object value) throws ValidatorException {
	}

	public void setUserTypeId(int typeId) {
		for (UserType type : UserType.values()) {
			if (type.getId() == typeId) {
				this.userType = type;
			}
		}
	}

	public int getUserTypeId() {
		return 2;
	}

	public String getPassword() {
		return "";
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}
}
