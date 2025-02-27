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
		
		// Path of the specific directory 
	    String directoryPath = "C:/Users/sonny/Documents/albums";
	    File directory = new File(directoryPath);
	    File[] files = directory.listFiles();
	      
	    // Add all files in directory to the 
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
                	store(scanner, store);
                    break;
                case 2:
                    // Option 2; Brings to own library
                	library(scanner, store, user);
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
	
	public static void store(Scanner scanner, MusicStore store) {
		System.out.println("\nWelcome to the store!");
		boolean running = true;
        while (running) {
            System.out.println("1. Search for album");
            System.out.println("2. Search for song");
            System.out.println("3. Return");
            
            // Get the user's choice
            System.out.print("Enter your choice (1, 2, or 3): ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character left by nextInt()

            switch (choice) {
                case 1:
                    // Option 1: Brings user to store
                	System.out.println("\nEnter name:\n");
                	String nameAlbum = scanner.nextLine();
                	System.out.println("Let's see:\n");
                	System.out.println(store.albumInfo(nameAlbum));
                    break;
                case 2:
                	System.out.println("\nEnter name:\n");
                	String nameSong = scanner.nextLine();
                	store.songInfo(nameSong);
                	System.out.println("Let's see:\n");
                	System.out.println(store.songInfo(nameSong));
                    break;
                case 3:
                    // Option 3: Exit
                    System.out.println("Exiting the Store");
                    running = false;
                    break;
                default:
                    // Invalid choice
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        return;
        
	}
	
	public static void library(Scanner scanner, MusicStore store, LibraryModel user) {
		System.out.println("\nWelcome to your library!");
		boolean running = true;
        while (running) {
            System.out.println("1. Add album to library");
            System.out.println("2. Add song to playlist");
            System.out.println("3. Return");
            
            // Get the user's choice
            System.out.print("Enter your choice (1, 2, or 3): ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character left by nextInt()

            switch (choice) {
                case 1:
                    // Option 1: Add album by name or author (Adds each one it finds)
                	System.out.println("\nEnter name or artist:\n");
                	String nameAlbum = scanner.nextLine();
                	System.out.println("Found: \n" + store.albumInfo(nameAlbum));
                	user.addPlayList(store.getAlbum(nameAlbum));
                    break;
                case 2:
                	System.out.println("\nEnter name:\n");
                	String nameSong = scanner.nextLine();
                	System.out.println("Enter playlist name:\n");
                	String namePlayList = scanner.nextLine();
                	System.out.println("Found: \n" + store.songInfo(nameSong));
                	user.addSongToPlayList(nameSong, namePlayList);
                	
                    break;
                case 3:
                    // Option 3: Exit
                    System.out.println("Exiting the Store");
                    running = false;
                    break;
                default:
                    // Invalid choice
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        return;
        
	}
}
