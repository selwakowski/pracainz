package edu.dao;

import edu.dao.db.VinylDB;

import java.util.List;

public class VinylDao {

	public VinylDB getVinyl(long id) {
		return OfyService.ofy().load().type(VinylDB.class).id(id).now();
	}

	public VinylDB createEmptyVinyl() {
		return new VinylDB(0, "", "", "");
	}

	public VinylDB createVinyl() {
		return createVinyl("", "", "");
	}

	public VinylDB createVinyl(String artist, String title, String description) {
		long vinylId = OfyService.getNextVinylId();
		VinylDB vinyl = new VinylDB(vinylId, artist, title, description);
		OfyService.ofy().save().entity(vinyl).now();
		return vinyl;
	}

	public List<VinylDB> getAll() {
		return OfyService.ofy().load().type(VinylDB.class).chunkAll().list();
	}

	public void save(VinylDB vinyl) {
		OfyService.ofy().save().entity(vinyl).now();
	}
}
