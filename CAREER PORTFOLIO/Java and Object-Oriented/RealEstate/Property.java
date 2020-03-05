package RealEstate;

public abstract class Property {
    private int zip;
    double listPrice;
    double appraisalPrice;
    String streetAddress;

    public Property() {
        zip = 0;
        streetAddress = "";
    }

    public Property(String a, int z) {
        streetAddress = a;
        zip = z;
    }

    public int getZip() {
        return zip;
    }
    public int setZip(int z) {
        zip = z;
        return zip;
    }
    
    public double getListPrice() {
    	return listPrice;
    }
    
    public double setListPrice(double lp) {
    	listPrice = lp;
    	return listPrice;
    }
    
    public String getStreetAddress() {
    	return streetAddress;
    }
    
    public String setStreetAddress(String a) {
    	streetAddress = a;
    	return  streetAddress;
    }
    
    public double getAppraisalPrice() {
    	return appraisalPrice;
    }
    
    
    
    //This will be implemented by the House and Condo classes
    public abstract double calculateAppraisalPrice();
    
    //We make this protected so that not just anybody can change the Appraisal Price just because they calculated it.
    //That would make some of our buyers quite unhappy!
    protected void setAppraisalPrice(double ap) {
    	appraisalPrice = ap;
    }
}
