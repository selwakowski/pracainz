package edu.bean;

import edu.dao.UserDao;
import edu.dao.db.UserDB;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Selwacz on 2014-12-10.
 */
@ManagedBean(name = "userListBean")
@ViewScoped
public class UserListBean implements Serializable {
    private static final long serialVersionUID = 1L;

    public List<UserDB> getUserList() {
        List<UserDB> userList = new ArrayList<UserDB>();
        UserDao dao = new UserDao();
        return dao.getExistingUsers();
    }
}
