package view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import model.Album;
import model.LibraryModel;
import model.MusicStore;
import model.PlayList;
import model.Song;


public class Main {
	public static void main(String[] args) {
		MusicStore store = new MusicStore();
		LibraryModel user = new LibraryModel();
		
		// Path of the specific directory 
	    String directoryPath = "src/albums";
	    File directory = new File(directoryPath);
	    File[] files = directory.listFiles();
	      
	    // Add all files in directory to the 
	    if (files != null) {
	    	for (File file : files) {
	          store.addAlbum(file);
	        }
	    }
	    
	    user.musicStore = store;
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
            System.out.println("1. Search for album by Artist or Name");
            System.out.println("2. Search for song by Artist or Name");
            System.out.println("3. Display Avalible Albums and Songs");
            System.out.println("4. Return");
            
            // Get the user's choice
            System.out.print("Enter your choice (1, 2, 3, or 4): ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character left by nextInt()

            switch (choice) {
                case 1:
                    // Option 1: Brings user to store
                	System.out.println("\nEnter name:\n");
                	String nameAlbum = scanner.nextLine();
                	System.out.println("Let's see:");
                	//System.out.println(store.albumInfo(nameAlbum));
                	if (store.getAlbum(nameAlbum) == null || store.getAlbum(nameAlbum).isEmpty()) {
                		System.out.println("No album found!");
                	}
                	else {
                	for (Album album : store.getAlbum(nameAlbum)) {
                		System.out.println(album.getInfo());
                		System.out.println("-Songs within Album:");
                		for (Song song : album.getSongs()) {
                			System.out.println("\t+" + song.getName());
                		}
                		System.out.println("--- End of Album ---");
                	}
                	System.out.println();}
                    break;
                case 2:
                	System.out.println("\nEnter name:\n");
                	String nameSong = scanner.nextLine();
                	store.songInfo(nameSong);
                	System.out.println("Let's see:\n");
                	System.out.println(store.songInfo(nameSong));
                    break;
                case 3:
                	for(Album a: store.getAlbumList()) {
                		System.out.println("--- " + a.getName() + " ---");
                		for(Song s : a.getSongs()) {
                			System.out.println("\t+" + s.getName());
                		}
                	}
                	break;
                
                case 4:
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
            System.out.println("1. Manage Albums");
            System.out.println("2. Manage PlayLists");
            System.out.println("3. Manage Song Library");
            System.out.println("4. Search for Song or Album");
            System.out.println("5. Play and track Songs");
            System.out.println("6. Return");
            
            // Get the user's choice
            System.out.print("Enter your choice (1, 2, 3, 4, 5 or 6): ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character left by nextInt()

            switch (choice) {
                case 1:
                	albums(scanner,store, user);
                	break;
                case 2:
                	playlists(scanner, store, user);
                    break;
                case 3:
                	songLibrary(scanner, store, user);
                	break;
                case 4:
                	System.out.println("\nEnter name or artist:\n");
                	String name = scanner.nextLine();
                	if(!store.albumInfo(name).equals("Album not found!"))
                		System.out.println("Found Albums: \n" + store.albumInfo(name));
                	else
                		System.out.println(store.albumInfo(name));
                	
                	if(!store.songInfo(name).equals("Song not found!"))
                		System.out.println("Found Albums: \n" + store.songInfo(name));
                	else
                		System.out.println(store.songInfo(name));
                    break;
                case 5:
                	songPlay(scanner, store, user);
                    break;
                case 6:
                    // Option 6: Exit
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
	public static void albums(Scanner scanner, MusicStore store, LibraryModel user) {
		System.out.println("\nWelcome to your Albums!");
		boolean running = true;
        while (running) {
            System.out.println("1. Add An Album");
            System.out.println("2. List Albums");
            System.out.println("3. Search For Albums by Artist or Name");
            System.out.println("4. Search For Albums Detials by Artist or Name");
            System.out.println("5. Return");
            
            // Get the user's choice
            System.out.print("Enter your choice (1, 2, 3, 4 or 5): ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character left by nextInt()

            switch (choice) {
                case 1:
                    // Option 1: Add album by name or author (Adds each one it finds)
                	System.out.println("\nEnter name or artist:\n");
                	String nameAlbum = scanner.nextLine();
                	System.out.println("Found: \n" + store.albumInfo(nameAlbum));
                	if(!store.albumInfo(nameAlbum).equals("Album not found!"))
                		user.addAlbum(store.getAlbum(nameAlbum));
                    break;
                case 2:
                	
                	System.out.println("\n--- ALBUMS OWNED ---\n");
                	for(Album a : user.getAlbumList()) {
                		System.out.println("\t+" + a.getName());
                	}
                    break;
                case 3:
                	System.out.println("\nEnter name or artist:\n");
                	String nameOfAlbum = scanner.nextLine();
                	ArrayList<Album> foundAlbums = user.searchAbum(nameOfAlbum);
                	if (foundAlbums == null || foundAlbums.size() == 0) {
                		System.out.println("Album not found! Try adding some more!");
                		break;
                	}
                	for (Album album : foundAlbums) {
                		System.out.println(album.getInfo());
                	}
                	System.out.println();
                	break;
                case 4:
                	System.out.println("\nEnter name or artist:\n");
                	String nameOfAlbumD = scanner.nextLine();
                	ArrayList<Album> foundAlbumsD = user.searchAbum(nameOfAlbumD);
                	if (foundAlbumsD == null || foundAlbumsD.size() == 0) {
                		System.out.println("Album not found! Try adding some more!");
                		break;
                	}
                	for (Album album : foundAlbumsD) {
                		System.out.println(album.getFullInfo());
                	}
                	break;
                case 5:
                    // Option 3: Exit
                    System.out.println("Returning To Library Actions");
                    running = false;
                    break;
                default:
                    // Invalid choice
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        
	}
	public static void playlists(Scanner scanner, MusicStore store, LibraryModel user) {
		System.out.println("\nWelcome to your PlayLists!");
		boolean running = true;
        while (running) {
            System.out.println("1. Create a New PlayList");
            System.out.println("2. Add a New Song to Existing PlayList");
            System.out.println("3. Remove a Song from An Existing Playlist");
            System.out.println("4. Search for A PlayList");
            System.out.println("5. List PlayLists");
            System.out.println("6. Return");
            
            // Get the user's choice
            System.out.print("Enter your choice (1,2,3,4,5 or 6): ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character left by nextInt()

            switch (choice) {
                case 1:
                	System.out.println("\nEnter name of PlayList:\n");
                	String nameNewPlayList = scanner.nextLine();
                	user.createNewPlayList(nameNewPlayList);
                    break;
                case 2:
                	System.out.println("\nEnter Song name:\n");
                	String nameSong = scanner.nextLine();
                	System.out.println("Enter playlist name:\n");
                	String namePlayList = scanner.nextLine();
                	System.out.println("Found: \n" + store.songInfo(nameSong));
                	
                	if(user.getPlayList(namePlayList) != null && store.getSong(nameSong) != null)
                		user.addSongToPlayList(namePlayList,nameSong);
                	else if(user.getPlayList(namePlayList) != null)
                		System.out.println("No playlist found");
                	else
                		System.out.println("No song or playlist found");
                    break;
                case 3:
                	System.out.println("Enter playlist name:\n");
                	String namePlayListRemove = scanner.nextLine();
                	System.out.println("Enter song to remove:\n");
                	String nameSongRemove = scanner.nextLine();
                	if(user.getPlayList(namePlayListRemove) != null && user.getPlayList(namePlayListRemove).hasSong(nameSongRemove) ) {
                		user.getPlayList(namePlayListRemove).removeSong(nameSongRemove);
                		System.out.println("Removed!");
                	}
                	else if(user.getPlayList(namePlayListRemove) == null) 
                		System.out.println("No playlsit found");
                	else
                		System.out.println("No song found");
                	break;
                case 4:
                	System.out.println("Enter playlist name:\n");
                	String namePlayListSearch = scanner.nextLine();
                	ArrayList<PlayList> searchResult = user.searchPlayListName(namePlayListSearch);
                	if(searchResult.isEmpty())
                		System.out.println("No PlayLists Found");
                	else
                		for(PlayList p : searchResult) {
                			System.out.println(p.getName());
                			for(Song s :p.getSongs()) {
                				System.out.println("\t+" + s.getInfo());
                			}
                		}
            
                	break;
                case 5:
                	System.out.println("\n---PLAYLISTS---\n");
                	for(PlayList p : user.getPlayListList()) {
                		System.out.println("\t+" +p.getName());
                	}
                	break;
                case 6:
                    // Option 3: Exit
                    System.out.println("Returning to Library Actions");
                    running = false;
                    break;
                default:
                    // Invalid choice
                    System.out.println("Invalid choice. Please try again.");
            }
        }        
	}
	public static void songLibrary(Scanner scanner, MusicStore store, LibraryModel user) {
		System.out.println("\nWelcome to your Song Library!");
		boolean running = true;
        while (running) {
            System.out.println("1. Add a Song");
            System.out.println("2. Favorite a Song");
            System.out.println("3. Search for a Song by Name");
            System.out.println("4. Search for a Song by Artist");
            System.out.println("5. List Songs");
            System.out.println("6. List Artists");
            System.out.println("7. List Favorites");
            System.out.println("8. Rate a Song");
            System.out.println("9. Return");
            
            // Get the user's choice
            System.out.print("Enter your choice (1, 2, 3, 4, 5, 6, 7 ,8 or 9): ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character left by nextInt()

            switch (choice) {
                case 1:
                    // Option 1: Add song by name (Adds each one it finds)
                	System.out.println("\nEnter name:\n");
                	String nameSong = scanner.nextLine();
                	System.out.println("Found: \n" + store.songInfo(nameSong));
                	if(store.getSong(nameSong) == null)
                		System.out.println("No song found");
                	else {
                	for(Song s : store.getSong(nameSong)) {
                			user.addSongToLib(s);
                		}}
                    break;
                case 2:
                	System.out.println("\nEnter Song Name to Favorite:\n");
                	String nameSongFavorite = scanner.nextLine();
                	if(user.favoriteSong(nameSongFavorite))
                		System.out.println("Favorited!");
                	else
                		System.out.println("Song not Found!");
                   break;
                case 3:
                	System.out.println("\nEnter Song Name:\n");
                	String nameSongSearch = scanner.nextLine();
                	
                	if(user.searchSongTitle(nameSongSearch).isEmpty())
                		System.out.println("No Songs Found with That Name!");
                	else {
                	for(Song s : user.searchSongTitle(nameSongSearch)) {
                		System.out.println(s.getInfo());}
                	}
                    break;
                case 4:
                	System.out.println("\nEnter Artists Name:\n");
                	String nameArtistSearch = scanner.nextLine();
                	
                	if(user.searchSongArtist(nameArtistSearch).isEmpty())
                		System.out.println("No Songs Found with That Artist!");
                	for(Song s : user.searchSongArtist(nameArtistSearch)) {
                		System.out.println(s.getInfo());
                	}
                    break;
                case 5:
                	System.out.println("\n --- Songs Owned --- \n");
                	for(Song s : user.getSongs()) {
                		System.out.println(s.getInfo());
                	}
                	break;
                case 6:
                	System.out.println("\n --- Artists Owned --- \n");
                	for(String artists : user.getArtists()) {
                		System.out.println(artists);
                	}
                	break;
                case 7:
                	System.out.println("\n --- Favorited Songs --- \n");
                	for(Song s : user.getFavorites()) {
                		System.out.println(s.getInfo());
                	}
                	break;
                	
                case 8:
                	System.out.println("\nEnter Song Name to Rate:\n");
                	String nameSongRate = scanner.nextLine();
                	System.out.println("Enter a rating:");
                	int rate = scanner.nextInt();
                	scanner.nextLine();
                	if(user.rateSongTitle(nameSongRate, rate))
                		System.out.println("Rated!");
                	else
                		System.out.println("Song not Found!");
                	break;
                case 9:
                	running = false;
                	break;
                default:
                    // Invalid choice
                    System.out.println("Invalid choice. Please try again.");
            }
        }        
	}	
	public static void songPlay(Scanner scanner, MusicStore store, LibraryModel user) {
		System.out.println("\nWelcome to manage songs!");
		boolean running = true;
        while (running) {
            System.out.println("1. Play a Song!");
            System.out.println("2. Recent Songs");
            System.out.println("3. Frequent Songs");
            System.out.println("4. Return");
            
            // Get the user's choice
            System.out.print("Enter your choice (1, 2, 3 or 4): ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character left by nextInt()

            switch (choice) {
                case 1:
                    // Option 1: 'Play' a song
                	System.out.println("Pick a song to play: (Enter Song name)");
                	String nameSongSearch = scanner.nextLine();
                	
                	if(user.searchSongTitle(nameSongSearch).isEmpty())
                		System.out.println("No Songs Found with That Name!");
                	else {
                		ArrayList<Song> temp = user.searchSongTitle(nameSongSearch);
                		for(Song s : temp) {
                			System.out.println(s.getInfo());
                		}
                		System.out.println("Enter your choice (1 - "+ temp.size() +"): ");
                        int pickChoice = scanner.nextInt();
                        if (pickChoice <= 0 || pickChoice > temp.size()) {
                        	System.out.println("Not an option!");
                        	break;
                        } else {
                        	user.playSong(temp.get(pickChoice-1));
                        	System.out.println(temp.get(pickChoice-1).getName()+" played");
                        }
                        
                	}
                	
                    break;
                case 2:
                	// Option 2: List 10 songs based on how recent
                	System.out.println("Recently played songs: ");
                	int i = 1;
                	for (Song s : user.getRecent()) {
                		System.out.println(i + " - "+s.getName());
                		i++;
                	}
                	System.out.println();
                    break;
                case 3:
                	// Option 3: List 10 songs with counts based on how plays
                	System.out.println("Frequently played songs: ");
                	System.out.print(user.getFrqListToString());
                	break;
                case 4:
                	running = false;
                	break;
                default:
                    // Invalid choice
                    System.out.println("Invalid choice. Please try again.");
            }
        }
	}
}