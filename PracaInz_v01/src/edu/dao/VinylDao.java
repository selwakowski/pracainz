package edu.dao;

import edu.dao.db.VinylDB;

public class VinylDao {

	public VinylDB getVinyl(long id) {
		//todo
		
		return null;
	}
	
	public void createVinyl(String name) {
		long vinylId = OfyService.getNextVinylId();
		VinylDB vinyl = new VinylDB(vinylId, name);
		OfyService.ofy().save().entity(vinyl).now();
	}
}
