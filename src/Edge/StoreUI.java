package Edge;

import java.util.Scanner;

public class StoreUI {

	public static void main(String[] args) {
		
		Store store = new Store(10);
		CentralSystem system = store.system;

		Scanner input = new Scanner(System.in);

		while (true) {
			System.out.println();
		    System.out.println("  EdgeSport Innovations Ltd. Barrier Control System");
		    System.out.println("*****************************************************");
		    
		    System.out.println("Barrier status: " + (system.barrier.isOpen ? "Open" : "Closed"));
            System.out.println("Current customer count: " + store.getcustomerCount());
            System.out.println("Barrier message: " + system.barrier.notice_message);
			System.out.println();

		    System.out.println("   1- Change maximum limit");
		    System.out.println(system.barrier.automaticControl ? "   2- Disable automatic control" : "   2- Enable automatic control");
		    if (!system.barrier.automaticControl) {
			    System.out.println("   3- Open barrier");
			    System.out.println("   4- Close barrier");
		    }
		    System.out.println();
			System.out.println("Simulate store activity");
			System.out.println("   5- Customer enters store...");
			System.out.println("   6- Customer exits store...");
			System.out.println("   7- Employee swipes card in...");

		 
		    String usersChoice = input.nextLine();
		    if (usersChoice == "")
		    	continue;
            System.out.println();
            
		    switch (usersChoice.charAt(0)) {
		        case '1': {
	                System.out.println("Current maximum limit: " + store.getMaxCustomers());
		        	System.out.println("Enter a new maximum limit: ");
		        	Scanner scanner = new Scanner(System.in);
		        	store.setMaxCustomers(scanner.nextInt());
		        	break;
		        }
		        
		        case '2': {
		        	system.barrier.automaticControl = !system.barrier.automaticControl; // Flips boolean value
		        	System.out.println(system.barrier.automaticControl ? "Automatic control enabled" : "Automatic control disabled");
					system.controlBarrier();
		        	break;
		        }
		        case '3': {
					// Code for manually opening barrier
		        	if (system.barrier.automaticControl) break;
	                system.barrier.open();
		        	System.out.println("Barrier has been opened.");
		        	system.barrier.notice_message = "Open for business";
	                break;
		        }
		        case '4': {
					// Code for manually closing barrier
		        	if (system.barrier.automaticControl) break;
	                system.barrier.closed();
	                System.out.println("Barrier has been closed.");
	                system.barrier.notice_message = "Barrier has been manually closed";      
		        	break;
		        }
		        case '5': {
		        	// Code for simulating customer entering store

					//barriers automatically close/open based off total customers in store
					if(system.barrier.automaticControl) {
						if(system.viewCount() >= store.getMaxCustomers()) {
							system.controlBarrier();
							break;
						}
						system.addCount();
						system.controlBarrier();
						break;
					}

					//If a customer tries to come in when the doors are manually closed
					if(system.barrier.isOpen != true) {
						System.out.println("Customer cannot come in right now doors are manually closed");
						break;
					}
					//If the doors are open the customer is allowed to come in
					system.addCount();
					System.out.println("Customer has entered");
					break;
				}

		        case '6': {
		        	// Code for simulating customer exiting store
					//Checking if there are no customers in the store nobody can leave otherwise deducts a person
					if(system.barrier.automaticControl) {
						if(system.viewCount() <= 0) {
							System.out.println("Nobody left the store because nobody is in the store!");
							break;
						}
				        system.minusCount();
						system.controlBarrier();
						System.out.println("A customer left the store");
						break;
					}
					
					//manual control where the doors are manually opened or shut and there might be 0 customers in the store if otherwise then a customer leaves
					if(system.viewCount() <= 0) {
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
