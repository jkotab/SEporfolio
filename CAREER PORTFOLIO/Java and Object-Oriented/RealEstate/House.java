package RealEstate;

public class House extends Residential {
	private double yardAcres;
	//private House access = new House();
	
	public House() {
		super();
		yardAcres = 0;
		
	}
	
	public House(int z, int bed, int bath, int sq, double y, String a) {
		super(z, bed, bath, sq, a);
		yardAcres = y;
		
	}
	
	public double getYardAcres() {
		return yardAcres;
	}
	
	public double setYardAcres(double y) {
		yardAcres = y;
		return yardAcres;
	}
	
	//HOUSE CALCULATION
	
	//Using our Condo specs, we calculate the Appraisal Price here, and we SET it inside here too.
	//This ensures that only those with access to the inheritable code can actually change the price. 
	public double calculateAppraisalPrice() {
		double ap = 97.00*getSize() + 10000.00*getBeds() + 12000.00*getBaths() + (yardAcres)*460000.00; 
		super.setAppraisalPrice(ap);
		return appraisalPrice;
	}

	/*
	@Override
	public double calculateAppraisalPrice() {
		return 0;
	}
	*/
	public String toString() {
		String output;		
		
		String line = "-------------------------------------------------------------------------------------------------------";
		
		String UpperBanner = String.format("%s\nResidence Type: House    Address: %-20s Zip Code: %d\n%s", line, getStreetAddress(), getZip(), line);

		String Body = String.format("Sq Footage: %d\nBedrooms: %d\nBathrooms: %d\nYardSize (Acres): %.2f", getSize(), getBeds(), getBaths(), getYardAcres());

		String LowerBanner = String.format("------------------------------\nAppraisal Price: $%.2f\nList Price: $%.2f\n------------------------------", getAppraisalPrice(), getListPrice());

		output = String.format("%s\n%s\n%s\n",UpperBanner, Body, LowerBanner);
		return output;
	}

}
