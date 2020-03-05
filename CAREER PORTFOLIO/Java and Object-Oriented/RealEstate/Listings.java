package RealEstate;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class Listings implements Listable {
	//Initialize HashMap
	HashMap<String, Residential> listings;
	
	//Default Constructor for HashMap
	public Listings() {
		listings = new HashMap<String, Residential>();
	}
	
	public HashMap<String, Residential> getListings() {
		return listings;
		 
	 }
	 public Residential getListing(String streetAddress) {
		return listings.get(streetAddress); 
	 }
	 
	 public Set<String> getStreetAddresses() {
		 return listings.keySet();
	 }
	 
	 public Collection<Residential> getResidences() {
		 return listings.values();
	 }
	 
	 public int getListingCount() {
		 return listings.size();
	 }
	 
	 public void addListing(String streetAddress, Residential r) {
		 listings.put(streetAddress, r);
	 }

	 
}
