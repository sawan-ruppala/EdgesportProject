package Edge;

import java.util.Scanner;

public class StoreUI {

	public static void main(String[] args) {
		
		boolean automaticControl = true;
		
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
			System.out.println("   8- Employee swipes card...");

		 
		    String usersChoice = input.nextLine();
		    if (usersChoice == "")
		    	continue;
            System.out.println();
            
		    switch (usersChoice.charAt(0)) {
		        case '1': {
	                System.out.println("Current customer count: " + "some referenced value...");
	                break;
		        }
		        case '2': {
	                System.out.println("Current maximum limit: " + "some referenced value...");
		        	System.out.println("Enter a new maximum limit: ");
		        	Scanner scanner = new Scanner(System.in);
					int tempValue = scanner.nextInt();
		        	System.out.println(tempValue);
		        	break;
		        }
		        
		        case '3': {
	                automaticControl = !automaticControl; // Flips boolean value
		        	System.out.println(automaticControl ? "Automatic control enabled" : "Automatic control disabled");
	                break;
		        }
		        case '4': {
		        	if (automaticControl) break;
	                System.out.println("Barrier has been opened.");
	                
	                // Code for opening barrier
		        	
	                break;
		        }
		        case '5': {
		        	if (automaticControl) break;
	                System.out.println("Barrier has been closed.");
	                
	                // Code for closing barrier
	                
		        	break;
		        }
		        case '6': {
		        	// Code for simulating customer entering store
		        	break;
		        }
		        case '7': {
		        	// Code for simulating customer exiting store
		        	break;
		        }
		        case '8': {
			        // Code for simulating employee swiping card (Bypass barrier one time, but keep automaticControl status the same)
		        	break;
		        }   
		    }
		}
	}	
}
