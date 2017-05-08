package bigbox.db;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import bigbox.business.Store;

public class StoreTextFile implements StoreDAO {
		private ArrayList<Store> stores = null;
		private Path storesPath = null;
		private File storesFile = null;
		
		private final String Field_SEP ="\t";
		private final String Next_LINE = "\n";
		 
		private ArrayList<Store> arrayofstores = null;
		public StoreTextFile ()
		{
			storesPath = Paths.get("stores.txt");
			storesFile = storesPath.toFile();
			stores = this.getAllStores();
		}
	
	

	@Override
	public ArrayList<Store> getAllStores() {
		//if (stores != null)
			
		//return stores;
		
		
		stores = new ArrayList<>();
		
		if (Files.exists(storesPath))
		{
			try (BufferedReader in =
				new BufferedReader (
			new FileReader(storesFile)))
			{
				String line = in.readLine();
				while (line != null)
				{
					String[] columns = line.split(Field_SEP);
					String division = columns [1];
					String store = columns [2];
					String sales = columns [3];
					String id = columns [0];
					String name = columns [4];
					String address = columns [5];
					String city = columns [6];
					String state = columns [7];
					String zipcode = columns [8];
					
				Store s = new Store (division,store,Double.parseDouble(sales));
				s.setId(Integer.parseInt(id));
				s.setDivision(division);
				s.setStore(store);
				s.setSales(Double.parseDouble(sales));
				s.setName(name);
				s.setAddress(address);
				s.setCity(city);
				s.setState(state);
				s.setZipcode(zipcode);
				
					stores.add(s);
					
					line = in.readLine();
				}
				
				}
			catch (IOException e)
			{
				System.out.println(e);
				return null;
				}
			}
		return stores;
		
		
			
	}

	@Override
	public ArrayList<Store> getAllStoresByDivision(String inDiv) 
	{
		//if (stores != null)
			
			//return stores;
			
			
			stores = new ArrayList<>();
			
			if (Files.exists(storesPath))
			{
				try (BufferedReader in =
					new BufferedReader (
				new FileReader(storesFile)))
				{
					String line = in.readLine();
					while (line != null)
					{
						String[] columns = line.split(Field_SEP);
						String division = columns [1];
						String store = columns [2];
						String sales = columns [3];
						String id = columns [0];
						String name = columns [4];
						String address = columns [5];
						String city = columns [6];
						String state = columns [7];
						String zipcode = columns [8];
						if (division.equalsIgnoreCase(inDiv))
						{
				
					Store s = new Store (division,store,Double.parseDouble(sales));
					s.setId(Integer.parseInt(id));
					s.setDivision(division);
					s.setSales(Double.parseDouble(sales));
					s.setStore(store);
					s.setName(name);
					s.setAddress(address);
					s.setCity(city);
					s.setState(state);
					s.setZipcode(zipcode);
					
						stores.add(s);
						}
						line = in.readLine();
					}
					
					}
				catch (IOException e)
				{
					System.out.println(e);
					return null;
					}
				}
			return stores;
			
		
	}
	public Store getStore (String store)
	{
		for (Store s : stores)
		{
			
			if (s.getStore().equals(store))
				return s;
		}
		return null;
	}
	private boolean saveStores()
	{
		try (PrintWriter out = new PrintWriter(
							   new BufferedWriter(
							   new FileWriter(storesFile))))
			{
			for (Store s : stores)
			{
				out.print(s.getId() +Field_SEP);
				out.print(s.getDivision() + Field_SEP);
				out.print(s.getStore() + Field_SEP);
				out.print(s.getSales() + Field_SEP);
				out.print(s.getName() + Field_SEP);
				out.print(s.getAddress() + Field_SEP);
				out.print(s.getCity() + Field_SEP);
				out.print(s.getState() + Field_SEP);
				out.print(s.getZipcode()+ Next_LINE);
			
			}
			}
			
		catch (IOException e)
		{
			System.out.println(e);
			return false ;
		
	
		}
		return true;
				}

	@Override
	public boolean addStore(Store inStore) 
	{
		stores = this.getAllStores();
		stores.add(inStore);
		return this.saveStores();
	}

	@Override
	public boolean updateStore(Store inStore) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteStore(Store inStore)
	{
		int arraynumbertodelete = 0;
		
		for (Store s : stores)
		{
			if (s.getDivision().equals(inStore.getDivision()) &&
			s.getStore().equals(inStore.getStore()))
			{
				break;
			}
			arraynumbertodelete++;
		}
		
		stores = this.getAllStores();
		stores.remove(arraynumbertodelete);
		return this.saveStores();
	
	}

	@Override
	public Store getStoreByDivisionandStoreNumber(String inDiv, String inStoreNbr) 
	{
		//stores = new ArrayList<>();
		
		if (Files.exists(storesPath))
		{
			try (BufferedReader in =
				new BufferedReader (
			new FileReader(storesFile)))
			{
				String line = in.readLine();
				while (line != null)
				{
					String[] columns = line.split(Field_SEP);
					String division = columns [1];
					String store = columns [2];
					String sales = columns [3];
					String id = columns [0];
					String name = columns [4];
					String address = columns [5];
					String city = columns [6];
					String state = columns [7];
					String zipcode = columns [8];
					
					if (division.equalsIgnoreCase(inDiv) && (store.equalsIgnoreCase(inStoreNbr)))
						
					{
						
				Store s = new Store (division,store, Double.parseDouble(sales));
				s.setId(Integer.parseInt(id));
				s.setDivision(division);
				s.setStore(store);
				s.setSales(Double.parseDouble(sales));
				s.setName(name);
				s.setAddress(address);
				s.setCity(city);
				s.setState(state);
				s.setZipcode(zipcode);
				
					//stores.add(s);
				return s;
					}
					line = in.readLine();
				}
				
				}
			catch (IOException e)
			{
				System.out.println(e);
				return null;
				}
			
			return null;
			}
		
		
		
	
		return null;
	}

}
