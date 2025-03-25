package view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.*;


public class Main {
	
	private static Users users = new Users();
	private static User currentUser = null;
	private static MusicStore store;
	
	public static void main(String[] args) {
		store = new MusicStore();
		login();
		
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
            System.out.println("3. Logout");
            
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
                	
                	library(scanner, store, currentUser);
                    break;
                case 3:
                    // Option 3: Exit
                    System.out.println("logging out. Goodbye!");
                    currentUser = null;
            		login();
                    break;
                default:
                    // Invalid choice
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
	}
	
	private static void login() {
		Scanner scanner = new Scanner(System.in);
		boolean running = true; 
        while(running) {
            System.out.println("1. Sign Up");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            
            // Get the user's choice
            System.out.print("Enter your choice (1, 2, or 3): ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character left by nextInt()
            String username;
            String password; 
    		User tempUsr = new User("Temp", "1", store);
            switch(choice) {
            	case 1:
            		System.out.println("Enter Username:");
            		username = scanner.next();
            		if(tempUsr.usernameUsed(username)) {
            			System.out.println("Username Already In use");
            			break;
            		}
            		System.out.println("Password:");
            		password = scanner.next();
            		currentUser = new User(username, password, store);
            		users.addNewUser(currentUser);
            		running = false;
            		break;
            	case 2:

            		System.out.println("\nEnter Username:");
            		username = scanner.next();
            		if (tempUsr.usernameUsed(username)) {
                		System.out.println("\nPassword:");
                		password = scanner.next();
                		if(tempUsr.correctPassword(username, password)) {
                			if(users.userExists(username))
                				currentUser = users.getUser(username);
                			else {
                        		currentUser = new User(username, password, store);
                        		users.addNewUser(currentUser);
                			}
                			running = false;
                			break;
                		}
                		System.out.println("Incorrect password!");
                		break;
            		}
            		else {
            			System.out.println("Invalid username");
            		}

            		break;
            	case 3:
            		System.exit(0);
            		break;
            }
        }
		
		
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
	
	public static void library(Scanner scanner, MusicStore store, User user) {
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
	public static void albums(Scanner scanner, MusicStore store, User user) {
		System.out.println("\nWelcome to your Albums!");
		boolean running = true;
        while (running) {
            System.out.println("1. Add An Album");
            System.out.println("2. Remove An Album");
            System.out.println("3. List Albums");
            System.out.println("4. Search For Albums by Artist or Name");
            System.out.println("5. Search For Albums Detials by Artist or Name");
            System.out.println("6. Return");
            
            // Get the user's choice
            System.out.print("Enter your choice (1, 2, 3, 4, 5 or 6): ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character left by nextInt()

            switch (choice) {
                case 1:
                    // Option 1: Add album by name or author (Adds each one it finds)
                	System.out.println("\nEnter name or artist:\n");
                	String nameAlbum = scanner.nextLine();
                	System.out.println("Found: \n" + store.albumInfo(nameAlbum));
                	if(!store.albumInfo(nameAlbum).equals("Album not found!"))
                		users.addAlbum(store.getAlbum(nameAlbum), currentUser);
                    break;
                case 2:
                	//Remove an album from library
                	System.out.println("Pick a album to remove: (Enter Album name)");
                	String nameAlbumRemove = scanner.nextLine();
                	
                	if(users.searchAbum(nameAlbumRemove, currentUser).isEmpty())
                		System.out.println("No Album Found with That Name!");
                	else {
                		ArrayList<Album> temp = users.searchAlbumInfoName(nameAlbumRemove, currentUser);
                		for(Album s : temp) {
                			System.out.println(s.getInfo());
                		}
                		System.out.println("Enter your choice (1 - "+ temp.size() +"): ");
                        int pickChoice = scanner.nextInt();
                        if (pickChoice <= 0 || pickChoice > temp.size()) {
                        	System.out.println("Not an option!");
                        	break;
                        } else {
                        	users.removeAlbum(temp.get(pickChoice-1), currentUser);;
                        	System.out.println(temp.get(pickChoice-1).getName()+" removed");
                        }  
                	}
                	break;
                case 3:
                	
                	System.out.println("\n--- ALBUMS OWNED ---\n");
                	for(Album a : users.getAlbumList(currentUser)) {
                		System.out.println("\t+" + a.getName());
                	}
                    break;
                case 4:
                	System.out.println("\nEnter name or artist:\n");
                	String nameOfAlbum = scanner.nextLine();
                	ArrayList<Album> foundAlbums = users.searchAbum(nameOfAlbum, currentUser);
                	if (foundAlbums == null || foundAlbums.size() == 0) {
                		System.out.println("Album not found! Try adding some more!");
                		break;
                	}
                	for (Album album : foundAlbums) {
                		System.out.println(album.getInfo());
                	}
                	System.out.println();
                	break;
                case 5:
                	System.out.println("\nEnter name or artist:\n");
                	String nameOfAlbumD = scanner.nextLine();
                	ArrayList<Album> foundAlbumsD = users.searchAbum(nameOfAlbumD, currentUser);
                	if (foundAlbumsD == null || foundAlbumsD.size() == 0) {
                		System.out.println("Album not found! Try adding some more!");
                		break;
                	}
                	for (Album album : foundAlbumsD) {
                		System.out.println(album.getFullInfo());
                	}
                	break;
                case 6:
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
	public static void playlists(Scanner scanner, MusicStore store, User currentUser) {
		System.out.println("\nWelcome to your PlayLists!");
		boolean running = true;
        while (running) {
            System.out.println("1. Create a New PlayList");
            System.out.println("2. Add a New Song to Existing PlayList");
            System.out.println("3. Remove a Song from An Existing Playlist");
            System.out.println("4. Search for A PlayList");
            System.out.println("5. List PlayLists");
            System.out.println("6. Suffle PlayLists");
            System.out.println("7. Return");
            
            // Get the user's choice
            System.out.print("Enter your choice (1,2,3,4,5 or 6): ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character left by nextInt()

            switch (choice) {
                case 1:
                	System.out.println("\nEnter name of PlayList:\n");
                	String nameNewPlayList = scanner.nextLine();
                	users.createNewPlayList(nameNewPlayList, currentUser);
                    break;
                case 2:
                	System.out.println("\nEnter Song name:\n");
                	String nameSong = scanner.nextLine();
                	System.out.println("Enter playlist name:\n");
                	String namePlayList = scanner.nextLine();
                	System.out.println("Found: \n" + store.songInfo(nameSong));
                	
                	if(users.getPlayList(namePlayList, currentUser) != null && store.getSong(nameSong) != null)
                		users.addSongToPlayList(namePlayList,nameSong, currentUser);
                	else if(users.getPlayList(namePlayList, currentUser) != null)
                		System.out.println("No playlist found");
                	else
                		System.out.println("No song or playlist found");
                    break;
                case 3:
                	System.out.println("Enter playlist name:\n");
                	String namePlayListRemove = scanner.nextLine();
                	System.out.println("Enter song to remove:\n");
                	String nameSongRemove = scanner.nextLine();
                	if(users.getPlayList(namePlayListRemove, currentUser) != null && users.getPlayList(namePlayListRemove, currentUser).hasSong(nameSongRemove) ) {
                		users.getPlayList(namePlayListRemove, currentUser).removeSong(nameSongRemove);
                		System.out.println("Removed!");
                	}
                	else if(users.getPlayList(namePlayListRemove, currentUser) == null) 
                		System.out.println("No playlsit found");
                	else
                		System.out.println("No song found");
                	break;
                case 4:
                	System.out.println("Enter playlist name:\n");
                	String namePlayListSearch = scanner.nextLine();
                	ArrayList<PlayList> searchResult = users.searchPlayListName(namePlayListSearch, currentUser);
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
                	for(PlayList p : users.getPlayListList(currentUser)) {
                		System.out.println("\t+" +p.getName());
                	}
                	break;
                case 6:
                	System.out.println("Enter playlist name:\n");
                	String playListSearch = scanner.nextLine();
                	ArrayList<PlayList> searchResultPlayList = users.searchPlayListName(playListSearch, currentUser);
                	if(searchResultPlayList.isEmpty())
                		System.out.println("No PlayLists Found");
                	else
                		for(PlayList p : searchResultPlayList) {
                			List<Song> tempList = p.shuffleSongs();
                        	System.out.println("Shuffling "+p.getName()+" Songs: ");
                        	for (Song s : tempList) {
                        		System.out.println("\t+" + s.getName());
                        	}
                		}
                	
                	break;
                case 7:
                    // Option 7: Exit
                    System.out.println("Returning to Library Actions");
                    running = false;
                    break;
                default:
                    // Invalid choice
                    System.out.println("Invalid choice. Please try again.");
            }
        }        
	}
	public static void songLibrary(Scanner scanner, MusicStore store, User currentUser) {
		System.out.println("\nWelcome to your Song Library!"); 
		boolean running = true;
        while (running) {
            System.out.println("1. Add a Song");
            System.out.println("2. Remove a Song");
            System.out.println("3. Favorite a Song");
            System.out.println("4. Search for a Song by Name");
            System.out.println("5. Search for a Song by Artist");
            System.out.println("6. Search for a Song by Genre");
            System.out.println("7. List Songs");
            System.out.println("8. List Artists");
            System.out.println("9. List Favorites");
            System.out.println("10.Rate a Song");
            System.out.println("11.Sort Your Songs");
            System.out.println("12.Return");
            
            // Get the user's choice
            System.out.print("Enter your choice (1, 2, 3, 4, 5, 6, 7 ,8, 9, 10 or 11): ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character left by nextInt()

            switch (choice) {
                case 1:
                    // Option 1: Add song by name (Adds each one it finds)
                	System.out.println("\nEnter name:\n");
                	String nameSong = scanner.nextLine();
                	System.out.println("Found: \n" + store.songInfo(nameSong));
                	if(store.getSong(nameSong) == null) {
                		System.out.println("No song found");
                		break;	
            		}else {
                		for(Song s : store.getSong(nameSong)) {
                			users.addSongToLib(s, currentUser);
                		}
                	}
                	System.out.println("More information? Yes or no (1 or 2)");
                    int moreInfo = scanner.nextInt();
                    if (moreInfo <= 0 || moreInfo > 2) {
                    	System.out.println("Not an option!");
                    	break;
                    } else {
                    	if (moreInfo == 1) {
                    		for(Song s : store.getSong(nameSong)) {
                    			System.out.println("From album: "+s.getAlbum().getFullInfo());
                    			if (users.searchAbum(s.getAlbum().getName(), currentUser).size() > 0 ){
                    				System.out.println("This Album is within the user library");
                    			} else {
                    				System.out.println("This Album is not within the user library");  
                    			}
                    		}
                    	}
                    }  
                    break;
                case 2:
                	//Remove a song from library
                	System.out.println("Pick a song to remove: (Enter Song name)");
                	String nameSongRemove = scanner.nextLine();
                	
                	if(users.searchSongTitle(nameSongRemove, currentUser).isEmpty())
                		System.out.println("No Songs Found with That Name!");
                	else {
                		ArrayList<Song> temp = users.searchSongTitle(nameSongRemove, currentUser);
                		for(Song s : temp) {
                			System.out.println(s.getInfo());
                		}
                		System.out.println("Enter your choice (1 - "+ temp.size() +"): ");
                        int pickChoice = scanner.nextInt();
                        if (pickChoice <= 0 || pickChoice > temp.size()) {
                        	System.out.println("Not an option!");
                        	break;
                        } else {
                        	users.removeSong(temp.get(pickChoice-1), currentUser);;
                        	System.out.println(temp.get(pickChoice-1).getName()+" removed");
                        }  
                	}
                	break;
                case 3:
                	System.out.println("\nEnter Song Name to Favorite:\n");
                	String nameSongFavorite = scanner.nextLine();
                	if(users.favoriteSong(nameSongFavorite, currentUser))
                		System.out.println("Favorited!");
                	else
                		System.out.println("Song not Found!");
                   break;
                case 4:
                	System.out.println("\nEnter Song Name:\n");
                	String nameSongSearch = scanner.nextLine();
                	
                	if(users.searchSongTitle(nameSongSearch, currentUser).isEmpty())
                		System.out.println("No Songs Found with That Name!");
                	else {
                	for(Song s : users.searchSongTitle(nameSongSearch, currentUser)) {
                		System.out.println(s.getInfo());}
                	}
                    break;
                case 5:
                	System.out.println("\nEnter Artists Name:\n");
                	String nameArtistSearch = scanner.nextLine();
                	
                	if(users.searchSongArtist(nameArtistSearch, currentUser).isEmpty())
                		System.out.println("No Songs Found with That Artist!");
                	for(Song s : users.searchSongArtist(nameArtistSearch, currentUser)) {
                		System.out.println(s.getInfo());
                	}
                    break;
                    
                case 6:
                	System.out.println("\nEnter Genre:\n");
                	String nameGenreSearch = scanner.nextLine();
                	
                	if(users.searchSongsGenre(nameGenreSearch, currentUser) == null)
                		System.out.println("No Songs Found with That Genre!");
                	else {
                    	for(Song s : users.searchSongsGenre(nameGenreSearch, currentUser)) {
                    		System.out.println(s.getInfo());
                	}
                	}
                    break;
                    
                case 7:
                	System.out.println("\n --- Songs Owned --- \n");
                	for(Song s : users.getSongs(currentUser)) {
                		System.out.println(s.getInfo());
                	}
                	break;
                case 8:
                	System.out.println("\n --- Artists Owned --- \n");
                	for(String artists : users.getArtists(currentUser)) {
                		System.out.println(artists);
                	}
                	break;
                case 9:
                	System.out.println("\n --- Favorited Songs --- \n");
                	for(Song s : users.getFavorites(currentUser)) {
                		System.out.println(s.getInfo());
                	}
                	break; 
                case 10:
                	System.out.println("\nEnter Song Name to Rate:\n");
                	String nameSongRate = scanner.nextLine();
                	System.out.println("Enter a rating:");
                	int rate = scanner.nextInt();
                	scanner.nextLine();
                	if(users.rateSongTitle(nameSongRate, rate, currentUser))
                		System.out.println("Rated!");
                	else
                		System.out.println("Song not Found!");
                	break;
                case 11:
                	sortSong(scanner, store, currentUser);
                case 12:
                	running = false;
                	break;
                default:
                    // Invalid choice
                    System.out.println("Invalid choice. Please try again.");
            }
        }        
	}	
	public static void songPlay(Scanner scanner, MusicStore store, User currentuser) {
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
                	
                	if(users.searchSongTitle(nameSongSearch, currentUser).isEmpty())
                		System.out.println("No Songs Found with That Name!");
                	else {
                		ArrayList<Song> temp = users.searchSongTitle(nameSongSearch, currentUser);
                		for(Song s : temp) {
                			System.out.println(s.getInfo());
                		}
                		System.out.println("Enter your choice (1 - "+ temp.size() +"): ");
                        int pickChoice = scanner.nextInt();
                        if (pickChoice <= 0 || pickChoice > temp.size()) {
                        	System.out.println("Not an option!");
                        	break;
                        } else {
                        	users.playSong(temp.get(pickChoice-1), currentUser);
                        	System.out.println(temp.get(pickChoice-1).getName()+" played");
                        }
                        
                	}
                	
                    break;
                case 2:
                	// Option 2: List 10 songs based on how recent
                	System.out.println("Recently played songs: ");
                	int i = 1;
                	for (Song s : users.getRecent(currentUser)) {
                		System.out.println(i + " - "+s.getName());
                		i++;
                	}
                	System.out.println();
                    break;
                case 3:
                	// Option 3: List 10 songs with counts based on how plays
                	System.out.println("Frequently played songs: ");
                	System.out.print(users.getFrqListToString(currentUser));
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
	public static void sortSong(Scanner scanner, MusicStore store, User currentUser) {
		System.out.println("\nWelcome to sort songs!");
		boolean running = true;
        while (running) {
            System.out.println("1. Sort by Name!");
            System.out.println("2. Sort by Author");
            System.out.println("3. Sort by Rating");
            System.out.println("4. Random Sorting?");
            System.out.println("5. Return");
            
            // Get the user's choice
            System.out.print("Enter your choice (1, 2, 3, 4 or 5): ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character left by nextInt()

            switch (choice) {
                case 1:
                    // Sort by name
                	ArrayList<Song> sortName = users.getSongsBy(0, currentUser);
                	System.out.println("All Songs based on Title");
                	for (Song s : sortName) {
                		System.out.println(" " + s.getInfo());
                	}
                    break;
                case 2:
                	// Sort by Author
                	ArrayList<Song> sortAuthor = users.getSongsBy(1, currentUser);
                	System.out.println("All Songs based on Author");
                	for (Song s : sortAuthor) {
                		System.out.println(" " + s.getInfo());
                	}
                    break;
                case 3:
                	// Sort by Rating
                	ArrayList<Song> sortRating = users.getSongsBy(2, currentUser);
                	System.out.println("All Songs based on Rating (High to low)");
                	for (Song s : sortRating) {
                		System.out.println(" " + s.getInfo());
                	}
                    break;
                case 4:
                	List<Song> tempList = users.shuffleSongs(currentUser);
                	System.out.println("Shuffling Library Songs: ");
                	for (Song s : tempList) {
                		System.out.println(" " + s.getName());
                	}
                	break;
                case 5:
                	running = false;
                	break;
                default:
                    // Invalid choice
                    System.out.println("Invalid choice. Please try again.");
            }
        }
	}
}