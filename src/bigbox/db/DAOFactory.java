package bigbox.db;

import bigbox.business.Store;

public class DAOFactory {
	
	public static StoreDAO getStoreDAO ()
	{
		StoreDAO sDAO = new StoreTextFile();
		return sDAO;
		
	}

}
