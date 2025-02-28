package view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import model.LibraryModel;
import model.MusicStore;
import model.Song;


public class Main {
	public static void main(String[] args) {
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
	            System.out.println("3. Rate a song");
	            System.out.println("4. Favorite a song?");
	            System.out.println("5. Remove song");
	            System.out.println("6. Return");
	            
	            // Get the user's choice
	            System.out.print("Enter your choice (1, 2, or 3): ");
	            int choice = scanner.nextInt();
	            scanner.nextLine();  // Consume the newline character left by nextInt()
	        	String nameSong;
	        	
	            switch (choice) {
	                case 1:
	                    // Option 1: Add album by name or author (Adds each one it finds)
	                	System.out.println("\nEnter name or artist:\n");
	                	String nameAlbum = scanner.nextLine();
	                	System.out.println("Found: \n" + store.albumInfo(nameAlbum));
	                	user.addPlayList(store.getAlbum(nameAlbum));
	                    break;
	                case 2:
	                	// Option 2: Add Song to playlist
	                	System.out.println("\nEnter song name:\n");
	                	nameSong = scanner.nextLine();
	                	System.out.println("Enter playlist new or existing name:\n");
	                	String namePlayList = scanner.nextLine();
	                	System.out.println("Found: \n" + store.songInfo(nameSong));
	                	user.addSongToPlayList(namePlayList, nameSong, store);
	                	
	                    break;
	                case 3:
	                    // Option 3: Rate a Song
	                	System.out.println("\nEnter song name:\n");
	                	nameSong = scanner.nextLine();
	                	System.out.println("Current rating(s): ");
	                	ArrayList<Song> songs = user.searchSongTitle(nameSong);
	                	for (int i = 0; i < songs.size(); i++) {
	                		System.out.println((i+1)+" "+songs.get(i).getName()+": "+
	                					songs.get(i).getRating());
	                	}
	                	System.out.println("Pick number in range to change (0 for back out)");
	                	String whichSong = scanner.nextLine();
	                	int tempValue = Integer.getInteger(whichSong);
	                	if (0 < tempValue && tempValue < songs.size()) {
	                		System.out.println("Pick rating 1-5");
	                    	whichSong = scanner.nextLine();
	                    	int tempRating = Integer.getInteger(whichSong);
	                    	songs.get(tempValue).setRating(tempRating);
	                	} else {
	                		System.out.println("No changes");
	                	}
	                	
	                    break;
	                case 4:
	                    // Option 4: Fave a Song
	                	System.out.println("\nEnter song name:\n");
	                	nameSong = scanner.nextLine();
	                	System.out.println("Which song to switch? ");
	                	ArrayList<Song> songs2 = user.searchSongTitle(nameSong);
	                	for (int i = 0; i < songs2.size(); i++) {
	                		System.out.println((i+1)+" "+songs2.get(i).getName()+": "+
	                					songs2.get(i).getRating());
	                	}
	                	System.out.println("Pick number in range to change (0 for back out)");
	                	String whichSong2 = scanner.nextLine();
	                	int tempValue2 = Integer.getInteger(whichSong2);
	                	if (0 < tempValue2 && tempValue2 < songs2.size()) {
	                    	songs2.get(tempValue2).setFavorite();
	                	} else {
	                		System.out.println("No changes");
	                	}
	                    break;
	                case 5:
	                    // Option 5: Remove Song
	                    System.out.println("Enter song name");
	                    nameSong = scanner.nextLine();
	                    user.removeSongs(nameSong);
	                    
	                    break;
	                case 6:
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