package bigbox.presentation;
import java.util.ArrayList;
import java.util.Scanner;

import bigbox.business.Store;
import bigbox.db.DAOFactory;
import bigbox.db.StoreDAO;

import bigbox.util.Validator;

public class BigBoxApp {
		private static final String sales = null;

		public static Scanner sc = null;

		private static StoreDAO storeDAO = null;
				
	public static void main(String[] args) 
	{
		
		System.out.println("Welcome to Big Box App\n");
		
		Scanner sc = new Scanner (System.in);
		
		storeDAO= DAOFactory.getStoreDAO();

		
		String division ="";
		String store = "";
		String choice = "Y";
		//while (choice.equalsIgnoreCase("Y"))
		
		
	/*	{
			division = Validator.getStringNumeric(sc,"Enter division number", 3);
			store = Validator.getStringNumeric(sc,"Enter store number",5);
			
			Store s = StoreDB.getStoreByDivisionStore(division, store);
			System.out.println("store found for division"+s.getDivision()+"  and storeNbr"+s.getStore());
			System.out.println("Store : store#="+ s.getStore()+", div#="+ s.getDivision()+ ", sales ="+ s.getSales());
			System.out.println("id="+s.getId()+", name ="+ s.getName()+", address= "+s.getAddress()+ 
					", city = "+s.getCity()+ ",state ="+s.getState()+", zipcode ="+s.getZipcode());
			 System.out.print("Continue? (y/n): ");
	            choice = sc.nextLine();
	            System.out.println();
	        
	            
		}*/
		displayMenu();
		String action ="";
		while(!action.equalsIgnoreCase("exit"))
		{
			action = Validator.getString(sc, "Enter an Option ");
			
			System.out.println();
			
			if (action.equalsIgnoreCase("list"))
				displayAllStores();
			else if (action.equalsIgnoreCase("div"))
				displayAllStoresforDivision();
			else if (action.equalsIgnoreCase("Add")||
					(action.equalsIgnoreCase("add")))
				addStore();
			else if (action.equalsIgnoreCase("del")||
					(action.equalsIgnoreCase("delete")))
					deleteStore();
			else if (action.equalsIgnoreCase("help")||
					(action.equalsIgnoreCase("menu")))
				displayMenu();
			else if (action.equalsIgnoreCase("exit"))
				System.out.println("Bye\n");
			else 
				System.out.println("Error!! Not a valid Command.\n ");
		
		}

	}

	private static void deleteStore() 
	{
		Scanner sc = new Scanner (System.in);
		String division = Validator.getString(sc, "Enter a division number ");
		String store = Validator.getString(sc,"Enter a store number ");
		Store s = storeDAO.getStoreByDivisionandStoreNumber(division, store);
		
		System.out.println();
		if (s != null)
		{
			storeDAO.deleteStore(s);
			System.out.println(s.getStore() + " has been deleted.\n");
		}
		else
		{
			System.out.println("No Store matches ");
		}
		
	}

	private static void addStore() 
	{	
		Scanner sc = new Scanner (System.in);
		
		int id = Validator.getInt(sc, "Enter an Id ");
		String division = Validator.getStringNumeric(sc, "Enter a division number ", 3);
		String store = Validator.getStringNumeric(sc,"Enter a store number ", 5);
		double sales = Validator.getDouble(sc, "Enter sales amount ");
		String Name = Validator.getString(sc,"Enter Name of Store ");
		String Address = Validator.getString(sc, "Enter Address of Store ");
		String City = Validator.getString(sc,"Enter City ");
		String State = Validator.getString(sc,"Enter State ");
		String Zipcode = Validator.getString(sc,"Enter zipcode ");
		
		
		
	/*	System.out.println("Enter an ID");
		int id = 0;	
		id = sc.nextInt();
		
		System.out.println("Enter a division number");
		String division = "";	
		division = sc.next();
		
		System.out.println("Enter a store number");
		String store = "";
		store = sc.next();
		
		System.out.println("Enter sales");
		String division = "";	
		division = sc.next();*/
				
				Store s = new Store(id,division,store,sales,Name,Address,City,State,Zipcode);
				
				storeDAO.addStore(s);
				
				System.out.println();
				System.out.println(store +"has been added.\n");
		
		
	}

	private static void displayAllStoresforDivision() 
	{
		String division = Validator.getString(sc, "Enter a division number");
		System.out.println("Store List");
		System.out.println();
		System.out.println(storeDAO.getAllStoresByDivision(division));
	}

	private static void displayAllStores() {
		System.out.println(" STORE LIST");
		
		ArrayList<Store> storelist = storeDAO.getAllStores();
		
		for (Store s : storelist)
		{
			System.out.println(s.getId()+"\t"+ s.getDivision()+"\t"+s.getStore()+
					"\t"+ s.getSales()+"\t"+ s.getName()+"\t"+ s.getAddress()+
					"\t"+s.getCity()+"\t"+s.getState()+"\t"+s.getZipcode());
			
			}	
		
	//	System.out.println(storelist);
		
	}

	private static void displayMenu() {
		 System.out.println("COMMAND MENU");
	        System.out.println("list    - List all stores");
	        System.out.println("Div    - List of all stores for this division");
	        System.out.println("add     - Add a store");

	        System.out.println("del     - Delete a store");
	        System.out.println("help    - Show this menu");
	        System.out.println("exit    - Exit this application\n");
	}

}

