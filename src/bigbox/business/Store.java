package bigbox.business;

import java.text.NumberFormat;

public class Store extends Facility {

	private String store;
	private String division;
	private double sales;

	{
	     store= "";
	     division = "";
	     sales = 0.0;
	}

	 public String getStore() {
		return store;
	}

	public void setStore(String store) {
		this.store = store;
	}

	public String getDivision() {
		return division;
	}

	public void setDivision(String division) {
		this.division = division;
	}

	public double getSales() {
		return sales;
	}

	public void setSales(double sales) {
		this.sales = sales;
	}

	public String getFormmatedSales()
	{
		NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(sales);
	}
	
	public boolean equals (Object object)
	{
		if (object instanceof Store)
		{
			Store store2 = (Store )object;
			if
			(
				
				division.equals(store2.getDivision())&&
				store.equals(store2.getStore())&&
				sales == store2.getSales() 
				
				)
				return true;
				
		}
		return false;
	}
	public String toString ()
	{
		return "Division  "+ division + "\n" +
				"Store  "+ store +"\n"+
				"Sales " + this.getFormmatedSales() + "\n";
	}
	
	public Store(int inid, String inDiv, String inStore,double insales, String inname, String inaddress, String incity, String instate,String inzipcode) {
		 setId(inid);
		 setDivision(inDiv);
		 setStore(inStore);
		 setSales(insales);
		 setName(inname);
		 setAddress(inaddress);
		 setCity(incity);
		 setState(instate);
		 setZipcode(inzipcode);
		 
	 }


		public Store(String division, String store, double parseDouble) {
		// TODO Auto-generated constructor stub
	}

		public Store(String division2, String store2) {
			// TODO Auto-generated constructor stub
		}

/*	@Override
//	public Store getStoreByDivisionandStoreNumber(String inDiv, String inStoreNbr) {
		// TODO Auto-generated method stub
	//	return null;
//	}

	@Override
	public ArrayList<Store> getAllStores() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Store> getAllStoresByDivision(String inDiv) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean addStore(Store inStore) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateStore(Store inStore) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteStore(Store inStore) {
		// TODO Auto-generated method stub
		return false;
	}
	 
	
*/


	
	
	
}


