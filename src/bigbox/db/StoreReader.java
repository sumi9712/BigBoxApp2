package bigbox.db;
import java.util.ArrayList;

import bigbox.business.Store;

public interface StoreReader {
	Store getStoreByDivisionandStoreNumber(String inDiv, String inStoreNbr);
	ArrayList<Store>getAllStores();
	ArrayList<Store>getAllStoresByDivision(String inDiv);
	
	
}
