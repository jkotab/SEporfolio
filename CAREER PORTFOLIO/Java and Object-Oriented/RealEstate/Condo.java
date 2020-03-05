package RealEstate;

public class Condo extends Residential{
	private double floorLvl;
	
	public Condo() {
		super();
		floorLvl = 0;
		
	}
	
	public Condo(int z, int bed, int bath, int sq, double f, String a) {
		super(z, bed, bath, sq, a);
		floorLvl = f;
	
	}
	
	public double getFloorLvl() {
		return floorLvl;
	}
	
	public double setFloorLvl(double f) {
		floorLvl = f;
		return floorLvl;
	}
	

	//CONDO CALCULATION
	
	//Using our Condo specs, we calculate the Appraisal Price here, and we SET it inside here too.
	//This ensures that only those with access to the inheritable code can actually change the price. 
	public double calculateAppraisalPrice() {
		double ap = 88.00*getSize() + 8000.00*getBeds() + 10000.00*getBaths() + (floorLvl-1)*5000.00; 
		super.setAppraisalPrice(ap);
		return appraisalPrice;
	}


	
	public String toString() {
		String output = "";
		
		String line = "-------------------------------------------------------------------------------------------------------";
		
		String UpperBanner = String.format("%s\nResidence Type:" + 
				"Condo     Address: %-20s Zip Code: %d\n%s", line, getStreetAddress(), getZip(), line);

		String Body = String.format("Sq Footage: %d\nBedrooms: %d\nBathrooms: %d\nNumber of" +
				" Floors: %.1f", getSize(), getBeds(), getBaths(), getFloorLvl());

		String LowerBanner = String.format("------------------------------\nAppraisal Price: " + 
				"$%.2f\nList Price: $%.2f\n------------------------------", calculateAppraisalPrice(), getListPrice());

		output = String.format("%s\n%s\n%s\n",UpperBanner, Body, LowerBanner);
		return output;
	}
}
