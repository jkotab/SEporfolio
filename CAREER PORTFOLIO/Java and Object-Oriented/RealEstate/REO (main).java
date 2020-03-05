package RealEstate;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class REO {

	public static void main(String args[]) {
		
		boolean closed = false;
		//Always open, thus will run continuously
		while (!closed) {
			System.out.println("\n-------------------------------");
			System.out.println("           Main Menu           ");
			System.out.println("-------------------------------");
			System.out.println("1: Listings\n2: Bids\n3: Parades");
			System.out.print("What would you like to do? (1-3): ");
			String choice1 = in.nextLine();
			switch (choice1) {			
	
			case "1":
				ListingMenu(); 	break;
			case "2":
				BidsMenu(); 	break;
			case "3":
				System.out.print("There is no Parades submenus. Thanks Br. Light!"); break;
				//ParadesMenu(); 	break;
			default: System.out.print("Must enter either a 1, 2, or 3");
			}
		}
	}
	
	//LISTINGS, BIDS, PARADES functionalities and MENUs thereof

	//Listings - Menu
	public static void ListingMenu() {
		boolean done = false;
		
		while (!done) {
		System.out.println("\n-------------------------------");
		System.out.println("         Listing Menu          ");
		System.out.println("-------------------------------");
		System.out.print("1: Add Listing\n2: Show Listings\n3: Auto Populate Listings (Dev tool)\n" +
		"ENTER: Exit back to the previous menu\n\nWhat would you like to do? (1-3): ");
		
		String choice = in.nextLine();
		switch (choice) {
		case "1":
			AddListing(); 			break;
		case "2":
			ShowListings(); 		break;
		case "3":
			AutoPopList(); 			break;
		case "" : done = true;		break;
			
		default: System.out.print("Must enter either a 1, 2, 3 or press ENTER");
		}
		}//End of ListingMenu Loop
	}
	
	//Bids - Menu
	public static void BidsMenu() {
		boolean done = false;
		
		if (PSAdisplaysonce == 0 )  {          //This is a ONE TIME ONLY message intended to save the user frustration/time
		System.out.println(			"\n				~ Public Service Announcement ~\n"
				+ 					"               If you have come here before adding any listings, feel free to stay\n" 
				+					"               but realize that this menu will have no functionality for you    =)");
		PSAdisplaysonce++;
		}
		
		while (!done) {
		System.out.println("\n-------------------------------");
		System.out.println("           Bids Menu           ");
		System.out.println("-------------------------------");
		System.out.print("1: Add Bid\n2: Show Bids\n3: Auto Populate Bids (Dev tool)\n" +
		"ENTER: Exit back to the previous menu\n\nWhat would you like to do? (1-3): ");
		
		String choice = in.nextLine();
		switch (choice) {
		case "1":
			AddBid();	 			break;
		case "2":
			ShowBids(); 			break;
		case "3":
			AutoPopBid(); 			break;
		case "" : done = true;		break;
			
		default: System.out.print("Must enter either a 1, 2, 3 or press ENTER");
		}
		}//End of BidsMenu Loop
	}
	
	//Parades - Menu 		// NOTE: This section was removed as per instructor request
	
	//*************************************************************************************
	//																	~ LISTINGS
	//*************************************************************************************
	
		public static void AddListing() {
			boolean done = false;
			
			while (!done) {
			System.out.println("\n-------------------------------");
			System.out.println("        Add Listing Menu       ");
			System.out.println("-------------------------------");
			System.out.print("1: Add House\n2: Add Condo\n" +
			"ENTER: Exit back to the previous menu\n\nWhat would you like to do? (1-2): ");
			
			String choice = in.nextLine();
			switch (choice) {
			case "1":	   //ADD HOUSE METHOD
				boolean errorH = true;
				
				System.out.print("Enter Street Address: ");
				String sa = in.nextLine();
				System.out.print("Enter # of Sq. Feet: ");
				int sq = in.nextInt();
				System.out.print("Enter Zip Code: ");
				int zi = in.nextInt();
				System.out.print("Enter # of Beds: ");
				int bed = in.nextInt();
				System.out.print("Enter # of Baths: ");
				int bath = in.nextInt();
				System.out.print("Enter # of Acres: ");
				double acre = in.nextDouble();
				House thishouse = new House(zi, bed, bath, sq, acre, sa);
				
				System.out.printf("\nAppraisal Price for this property is: $%.2f\n", thishouse.calculateAppraisalPrice());
				
				double listPriceH = 0;
				while (errorH) {
					System.out.print("Please enter the List Price for the property: $");
				
					String dub = in.nextLine();
				
					try { listPriceH = Double.parseDouble(dub); 	errorH = false; }
					catch (Exception e) {
						System.out.print("Invalid. . . ");
					}
				}
				
				thishouse.setListPrice(listPriceH); 
				System.out.println();
				reoListings.addListing(thishouse.getStreetAddress(), thishouse);
				System.out.println("You have added a new listing!");
				System.out.print(thishouse);
										break;
										
			case "2":      //ADD CONDO METHOD
				boolean errorC = true;
				
				System.out.print("Enter Street Address: ");
				String SA = in.nextLine();
				System.out.print("Enter # of Sq. Feet: ");
				int SQ = in.nextInt();
				System.out.print("Enter Zip Code: ");
				int ZI = in.nextInt();
				System.out.print("Enter # of Beds: ");
				int Bed = in.nextInt();
				System.out.print("Enter # of Baths: ");
				int Bath = in.nextInt();
				System.out.print("Enter # of Floors: ");
				double floor = in.nextDouble();
				
				Condo thiscondo = new Condo(ZI, Bed, Bath, SQ, floor, SA);
				
				System.out.printf("\nAppraisal Price for this property is: $%.2f\n", thiscondo.calculateAppraisalPrice());
		 
				double listPriceC = 0;					//More input validation
				while (errorC) {
					System.out.print("Please enter the List Price for the property (including cents): $");
				
					String dub = in.nextLine();
				
					try { listPriceC = Double.parseDouble(dub); 	errorC = false; }
					catch (Exception e) {
						System.out.print("Invalid. . . ");
					}
				}
				thiscondo.setListPrice(listPriceC); 
				System.out.println();
				reoListings.addListing(thiscondo.getStreetAddress(), thiscondo);
				System.out.println("You have added a new listing!");
				System.out.print(thiscondo);
										break;
			
			case "" : done = true;		break;
				
			default: System.out.print("Must enter either a 1, 2, or press ENTER");
				}
			}
		}
	
	public static void ShowListings() {
		int count = 1;
		
		System.out.print("Current Listings for REO:\n");
		for (String key: reoListings.getStreetAddresses()) {
			System.out.printf("Listing No: %d\n", count);
 			System.out.print(reoListings.getListing(key));
 			System.out.println();
			count ++;
		}
	}

	public static void AutoPopList() {
				
		House house1 = new House(95129, 3, 2, 2200, .2, "34 Elm");
		house1.setListPrice(house1.calculateAppraisalPrice() * 1.1);
		reoListings.addListing("34 Elm", house1); 
		House house2 = new House(95136, 4, 3, 2800, .3, "42 Hitchhikers");
		house2.setListPrice(house2.calculateAppraisalPrice() * 1.1);
		reoListings.addListing("42 Hitchhikers", house2);
		Condo condo1 = new Condo(95177, 3, 1, 1800, 3, "4876 Industrial");
		condo1.setListPrice(condo1.calculateAppraisalPrice() * 1.1);
		reoListings.addListing("4876 Industrial", condo1);
		House house3 = new House(84062, 5, 53, 4200, .5, "2654 Oak");
		house3.setListPrice(house3.calculateAppraisalPrice() * 1.1);
		reoListings.addListing("2654 Oak", house3);
		Condo condo2 = new Condo(84063, 2, 1, 1500, 1, "9875 Lexington");
		condo2.setListPrice(condo2.calculateAppraisalPrice() * 1.1);
		reoListings.addListing("9875 Lexington", condo2);
		Condo condo3 = new Condo(84066, 3, 1, 1800, 2, "3782 Market");
		condo3.setListPrice(condo3.calculateAppraisalPrice() * 1.1);
		reoListings.addListing("3782 Market", condo3);
		House house4 = new House(84055, 6, 3, 3900, .4, "7608 Glenwood");
		house4.setListPrice(house4.calculateAppraisalPrice() * 1.1);
		reoListings.addListing("7608 Glenwood", house4);
		House house5 = new House(84057, 8, 7, 7900, 1, "1220 Apple");
		house5.setListPrice(house5.calculateAppraisalPrice() * 1.1);
		reoListings.addListing("1220 Apple", house5);
		
		int currentSize = reoListings.getListings().size();
		System.out.println("There are now " + currentSize + " listings!");
		PSAdisplaysonce++;
	}
	
	//*************************************************************************************
	//																		~ BIDS
	//*************************************************************************************
	
	public static void AddBid() {
		
	
		boolean done = false;
		//We will display our listings
		
		while (!done) {
		
			int count = 1;
			System.out.println("Current Listings for REO:");
			System.out.println("No.         Property (bids)\n-----------------------------");
			for (String key: reoListings.getStreetAddresses()) {
					System.out.printf("%d:(%s)   %s (%d)\n", count, reoListings.getListing(key).getClass().getSimpleName(), key, reoListings.getListing(key).getBidCount());
					count ++;
			}
		
			int choice = 0;
			boolean error1 = true;
		
			while (error1) {					//input validation, any error will kick the user out
				System.out.println("\nTo escape, enter a non-integer\n");
				System.out.print("For which property would you like to add a bid?: ");		
				String input = in.nextLine(); 
				try { choice = Integer.parseInt(input); 		error1 = false;	}
				catch (Exception e) {
					System.out.print("\nYou entered a non-integer\n");	done = true; 	break;
				}
			}
		//We will now search through listings for that associated with the user entry (choice)
		//   And then display
		
		int scancounter = 1;
		boolean listingnotfound = true;
		for (String key: reoListings.getStreetAddresses()) {
			if (scancounter == choice) {
				 
				System.out.print(reoListings.getListing(key));
				listingnotfound = false;		
				//done = true;
				System.out.print("Your name/bidders name please: ");
				String s = in.nextLine();
				boolean error2 = true;
				
				double d = 0;					//More input validation
				while (error2) {
					System.out.print("Please enter the new bid (including cents): ");
				
					String dub = in.nextLine();
				
					try { d = Double.parseDouble(dub); 	error2 = false; }
					catch (Exception e) {
						System.out.print("Invalid. . . ");
					}
				}
				//Finally, we have iterated through the appropriate listing of reoListings, validated all input, and added our bid
				reoListings.getListing(key).newBid(s, d);
				System.out.println("\nNew bid for property '" + key + "' was added.\n");
			}
			scancounter ++;	
		}
		if (listingnotfound && done == false) {System.out.print("Try again: that number didn't match any numbered listing\n");		}
		}
}
	
	public static void ShowBids() {
		
		boolean done = false;
		
		while (!done) {
			
			int count = 1;
			System.out.println("Current Listings for REO:");
			System.out.println("No.           Property (bids)\n-----------------------------");
			
			for (String key: reoListings.getStreetAddresses()) {
				System.out.printf("%d:(%s)     %s (%d)\n", count, reoListings.getListing(key).getClass().getSimpleName(), key, reoListings.getListing(key).getBidCount());
				count ++;
				}	
			
			int choice = 0;
			boolean error3 = true;
			while (error3) {						//More input validation
				System.out.println("\nTo escape, enter a non-integer\n");
				System.out.print("For which property would you like to see the current bids?: ");
				String input = in.nextLine();
				try 		{ choice = Integer.parseInt(input);		error3 = false; }
				catch (Exception  e) {
					System.out.print("\nYou entered a non-integer\n");  done = true;		break;  }
				}
			//We will now search through listings for that associated with the user entry (choice)
			//   And then display
			
			int scancounter = 1;
			String spacer   = "";
			boolean listingnotfound = true;
			for (String atAddress: reoListings.getStreetAddresses()) {
				if (scancounter == choice) {
					 
					System.out.print(reoListings.getListing(atAddress));
					listingnotfound = false;		
					System.out.print("\n\nCurrent Bids for this Listing:\n" + 
					"-------------------------------------\n" +
					"    Bidder                Bid       \n" +
					"-------------------------------------\n" );
					for (String ofBidder: reoListings.getListing(atAddress).getBidders()) {
						if (ofBidder.length() > 20) {
							System.out.printf("%s\n%-21s$%,.2f\n", ofBidder, spacer, reoListings.getListing(atAddress).getBid(ofBidder));	
						}
						else System.out.printf("%-21s$%,.2f\n", ofBidder, reoListings.getListing(atAddress).getBid(ofBidder));
					}
					System.out.println();
				}
				scancounter ++;	
			}
			if (listingnotfound && done == false) {System.out.print("Try again: that number didn't match any numbered listing\n");}
			}
		}
	
	public static void AutoPopBid() {
		String[] autoBidders= {"Van Morrison", "Joel Salatin", "Mark Shepherd", "Elaine Ingham", "Geoff Kessner", "William Shatner","Leonard Nimoy","DeForect Kelley","James Doohan","George Takei","Majel Barrett","Nichelle Nichol","Jonathan Frank", "Mahonri Jaredite Moriancumr"
                ,"Marina Sirtis", "Dougie McHouser", "Ryan Seagull", "Tupac", "Scooby Doo", "Richard Nixon", "Fred Flintstone", "Jack Sparrow", "David Tennant", "Everett James", "Brent Spiner","Gates McFadden", "The Great Gatsby", "Michael Dorn","LeVar Burton","Wil Wheaton","Colm Meaney"
                ,"Michelle Forbes", "Gordon Sumner", "Sherlock Holmes", "John Hamish Watson", "Tracy Chapman", "Allan Savory", "Rob Greenfield", "Vandana Shiva", "Suzanna Lein", "Dale Batty", "Wilson Alvarez", "Ben Weiss", "Eric Toensmeyer", "Dave Jacke", "Sepp Holzer", "Byron Joel", "Rebecca Cutter"
                ,"Akiva Silver", "M. Kat Anderson", "Charles Eisenstein", "Steve Gabriel", "Karryn Olson-Ramanujan", "Andrew Faust", "Jim French", "Jeff Lowenfels", "Gabe Brown", "Scott Mann", "David Holmgren", "Fred Provenza", "Hunter Lovins", "John Coffey", "Euell Theophillus Gibbons", "Paul Staetts"};

		System.out.println();
		for (String key : reoListings.getStreetAddresses() ) {
			//This will form the basis for how many bids we add to each Listing, with a potentially-different number of bids for each
		Random p = new Random();
		int numberofbids = p.nextInt(9) + 1;

		for (int i = 0; i < numberofbids; i++) {
			
			//Randomly select a number between 0 and the length of the autoBidders list - 1.  This will be our random index into the array
			Random r = new Random();
			
			int index = r.nextInt((autoBidders.length - 1) +1);
			double increment = 1 + i * (.05 + index * 0.00075);			//this ensures that the bids are larger with each successive bidder
			
			reoListings.getListing(key).newBid(autoBidders[index], reoListings.getListing(key).calculateAppraisalPrice()*increment);
			}
		
			//We will now display the results
		System.out.printf("%d new bids have been added to the listing %s.\n", numberofbids, key);
		}
	}
			
	//Here are STATICS, supplement/inner METHODS, and others. . . 
	
	public static Listings reoListings = new Listings();
	
	public static Scanner in = new Scanner(System.in);
	
	public static int PSAdisplaysonce = 0; 
	
}
