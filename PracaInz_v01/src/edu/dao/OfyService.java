package edu.dao;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;

import edu.dao.db.UserDB;

public class OfyService {
    static {
        factory().register(UserDB.class);
    }

	public static Objectify ofy() {
        return ObjectifyService.ofy();
    }

    public static ObjectifyFactory factory() {
        return ObjectifyService.factory();
    }
}
