package RealEstate;

import java.util.HashMap;
import java.util.Set;

public interface Biddable {

	HashMap<String, Double> getBids();
	
	double getBid(String s);
	
	Set<String> getBidders();
	
	int getBidCount();
	
	void newBid(String s, Double d);
}
