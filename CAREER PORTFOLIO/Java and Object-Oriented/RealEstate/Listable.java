package RealEstate;

import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public interface Listable {
 //public HashMap<String, Double> getBids();
 //public double getBid(String s); // uses offers.get(s) and returns a double value associated with that String s (the bidder)
 //public Set<String> getBidders(); //returns a Set<String> of keys from a HashMap offers
 //public void newBid(String s, double d); //Takes a key/value pair and updates the value for the key or adds a new key/value pair in a HashMap offers
 
	HashMap<String, Residential> getListings();     		//Gets the HashMap
 
	Residential getListing(String streetAddress);			//Gets the Residential Object (VALUE) associated with the provided streetAddress (KEY)
 
	Set<String> getStreetAddresses();						//Gets all the keys
 
	Collection<Residential> getResidences();				//Gets all the values
 
	int getListingCount();									//Gets the number of keys/values
 
	void addListing(String streetAddress, Residential r);	//Adds to the Hashmap
 
}
