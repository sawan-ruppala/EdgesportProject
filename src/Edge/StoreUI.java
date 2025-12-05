package Edge;

import java.util.Scanner;

public class StoreUI {

	public static void main(String[] args) {
		
		boolean automaticControl = true;
		Store store = new Store(10);
		CentralSystem system = store.system;
	


		Scanner input = new Scanner(System.in);

		while (true) {
			System.out.println();
		    System.out.println("  EdgeSport Innovations Ltd. Barrier Control System");
		    System.out.println("*****************************************************");
		    System.out.println("   1- Show current customer count");
		    System.out.println("   2- Change maximum limit");
		    System.out.println(automaticControl ? "   3- Disable automatic control" : "   3- Enable automatic control");
		    if (!automaticControl) {
			    System.out.println("   4- Open barrier");
			    System.out.println("   5- Close barrier");
		    }
		    System.out.println();
			System.out.println("Simulate store activity");
			System.out.println("   6- Customer enters store...");
			System.out.println("   7- Customer exits store...");
			System.out.println("   8- Employee swipes card in...");
			System.out.println("   9- Employee swipes card out...");

		 
		    String usersChoice = input.nextLine();
		    if (usersChoice == "")
		    	continue;
            System.out.println();
            
		    switch (usersChoice.charAt(0)) {
		        case '1': {
	                System.out.println("Current customer count: " + store.getCustomerCount());
	                break;
		        }
		        case '2': {
	                System.out.println("Current maximum limit: " + store.getMaxCustomers());
		        	System.out.println("Enter a new maximum limit: ");
		        	Scanner scanner = new Scanner(System.in);
		        	store.setMaxCustomers(scanner.nextInt());
		        	break;
		        }
		        
		        case '3': {
	                automaticControl = !automaticControl; // Flips boolean value
		        	System.out.println(automaticControl ? "Automatic control enabled" : "Automatic control disabled");
	                break;
		        }
		        case '4': {
					// Code for manually opening barrier
		        	if (automaticControl) break;
	                System.out.println("Barrier has been opened.");
	                system.barrier.open();
					
	                

		        	
	                break;
		        }
		        case '5': {
					// Code for manually closing barrier
		        	if (automaticControl) break;
	                System.out.println("Barrier has been closed.");
	                system.barrier.closed();
	                
	                
		        	break;
		        }
		        case '6': {
		        	// Code for simulating customer entering store

					//barriers automatically close/open based off total customers in store
					if(automaticControl){
						if(system.viewCount() >= store.getMaxCustomers()){
							system.controlBarrier();
							break;
						}
						system.controlBarrier();
						system.addCount();
						break;
					}

					//If a customer tries to come in when the doors are manually closed
					if(system.barrier.isOpen != true){
						System.out.println("Customer cannot come in right now doors are manually closed");
						break;
					}
					//If the doors are open the customer is allowed to come in
					system.addCount();
					System.out.println("Customer has entered");
					break;
				}

		        case '7': {
		        	// Code for simulating customer exiting store
					//Checking if there are no customers in the store nobody can leave otherwise deducts a person
					if(automaticControl){
					if(system.viewCount() <= 0){
						System.out.println("Nobody left the store because nobody is in the store!");
						break;
					}
		        	system.minusCount();
					System.out.println("A customer left the store");
					break;
					}
					
					//manual control where the doors are manually opened or shut and there might be 0 customers in the store if otherwise then a customer leaves
					if(system.viewCount() <= 0){
						System.out.println("Nobody left the store because nobody is in the store!");
						break;
					}
					system.minusCount();
					System.out.println("A customer left the store");
					break;

					
		        }
		 
		    }
		}
	}	
}
