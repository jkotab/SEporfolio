package RealEstate;

import java.util.HashMap;
import java.util.Set;

//import java.util.HashMap;

public abstract class Residential extends Property implements Biddable {
    private int bedCount;
    private int bathCount;
    private int sqFootage;
    private HashMap<String, Double> bids;

    public Residential() {
        super();
        bedCount = 0;
        bathCount = 0;
        sqFootage = 0;
        
    }

    public Residential(int z, int bed, int bath, int sq, String a) {
    	
        super(a, z);
        bedCount = bed;
        bathCount = bath;
        sqFootage = sq;
        bids = new HashMap<String, Double>();
    }

    public int getBeds() {
        return bedCount;
    }

    public int getBaths() {
        return bathCount;
    }

    public int getSize() {
        return sqFootage;
    }

    public int setBeds(int bed){
        bedCount = bed;
        return bedCount;
    }

    public int setBaths(int bath) {
        bathCount = bath;
        return bathCount;
    }

    public int setSize(int sq) {
        sqFootage = sq;
        return sqFootage;
    }
    
     //Inherited Methods
   
    public HashMap<String, Double> getBids() {
    	return bids;
    }
    
    public double getBid(String s) {
    	return bids.get(s);
    }
    
    public Set<String> getBidders() {
    	return bids.keySet();
    }
    
    public int getBidCount() {
    	return bids.size();
    }
    
    public void newBid(String s, Double d) {
    	if (bids.getOrDefault(s, 0.0) == 0) {
    		bids.put(s, d);
    	}
    	else bids.replace(s, d);
    }
    
    

    //This will be implemented by the House and Condo classes
    public abstract double calculateAppraisalPrice();
}
