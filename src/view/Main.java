package view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import model.LibraryModel;
import model.MusicStore;


public class Main {
	public static void main(String[] args) {
		MusicStore store = new MusicStore();
		LibraryModel user = new LibraryModel();
		
		// Path of the specific directory for me
		// Wouldn't work on gitHub so not sure what to
		//    replace it with. Also gitHub still bugging
	    String directoryPath = "C:/Users/sonny/Documents/albums";
	    File directory = new File(directoryPath);
	    File[] files = directory.listFiles();
	      
	    // Print name of the all files present in that path
	    System.out.println("Print: ");
	    if (files != null) {
	    	for (File file : files) {
	          store.addAlbum(file);
	        }
	    }
	    
	    
	 // User face
	    Scanner scanner = new Scanner(System.in);

        // Welcome message
        System.out.println("Welcome to the Music Store!");
        
        // Display menu options
        boolean running = true;
        while (running) {
            System.out.println("\nPlease choose an option:");
            System.out.println("1. Search Store");
            System.out.println("2. Search Your Own Library");
            System.out.println("3. Exit");
            
            // Get the user's choice
            System.out.print("Enter your choice (1, 2, or 3): ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character left by nextInt()

            switch (choice) {
                case 1:
                    // Option 1: Brings user to store
                    break;
                case 2:
                    // Option 2; Brings to own library
                    break;
                case 3:
                    // Option 3: Exit
                    System.out.println("Exiting the program. Goodbye!");
                    running = false;
                    break;
                default:
                    // Invalid choice
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
	}
}
