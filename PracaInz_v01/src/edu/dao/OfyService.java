package edu.dao;

import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyFactory;
import com.googlecode.objectify.ObjectifyService;

import edu.dao.db.SequenceGenerator;
import edu.dao.db.UserDB;
import edu.dao.db.VinylDB;

public class OfyService {
	
	private static String sequenceGeneratorId = "sequenceGenerator";
	private static SequenceGenerator sequenceGenerator;
	
    static {
        factory().register(UserDB.class);
        factory().register(VinylDB.class);
        factory().register(SequenceGenerator.class);
        
        sequenceGenerator = ofy().load().type(SequenceGenerator.class).id(sequenceGeneratorId).now();
        if (sequenceGenerator == null) {
        	sequenceGenerator = new SequenceGenerator(sequenceGeneratorId);
        	ofy().save().entity(sequenceGenerator).now();
        }
    }

	public static Objectify ofy() {
        return ObjectifyService.ofy();
    }

    public static ObjectifyFactory factory() {
        return ObjectifyService.factory();
    }

    
    public static long getNextVinylId () {
    	long vinylId = sequenceGenerator.getNextVinylId();
    	ofy().save().entity(sequenceGenerator).now();
    	return vinylId;
    }
}
