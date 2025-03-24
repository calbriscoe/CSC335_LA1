package model;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.io.FileWriter; 
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class User {

	private String username;
	private final String PASSWORDPATH = "src/model/passwords.txt";
	private LibraryModel library; 
	
	public User(String username, String password, MusicStore store){
		if(usernameUsed(username)) {
			this.username = username;
			this.library = new LibraryModel(store); 
		}
		this.username = username;
		String salt = generateSalt();
		recordNewUser(username, salt, generateHashedPassword(password, salt));
		this.library = new LibraryModel(store); 
		
	}
	
	public User(User u) {
		this.username = u.getUsername();
		this.library = u.getLib();
	}
	
	
	private String generateHashedPassword(String password, String salt) {
		MessageDigest md = null;
		try {
				md = MessageDigest.getInstance("SHA-256");
		} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		
		String passwordWithSalt = salt + password;
		byte [] passwordAsBytes = passwordWithSalt.getBytes();
		byte[] hashedPasswordBytes = md.digest(passwordAsBytes);
		StringBuilder sb = new StringBuilder();
		for(byte b: hashedPasswordBytes) {
			sb.append(b);
		}
		return sb.toString();
	}
	
	public String generateSalt() {
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
		StringBuilder salt = new StringBuilder();
		Random random = new Random();
		for(int i = 0; i < 16; i++) {
			salt.append(chars.charAt(random.nextInt(62)));
		}
		return salt.toString();
	}
	public boolean usernameUsed(String username) {
		try (BufferedReader br = new BufferedReader(new FileReader(PASSWORDPATH))) {
			String line;
			while ((line = br.readLine()) != null) {
				String storedUsername = line.split(",")[0];
				if(storedUsername.equals(username))
					return true;
			}
			return false;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean correctPassword(String username, String password) {
		try (BufferedReader br = new BufferedReader(new FileReader(PASSWORDPATH))) {
			String line;
			 while ((line = br.readLine()) != null) {
				String hashedPassword = line.split(",")[2];
				String salt = line.split(",")[1];
				if(hashedPassword.equals(generateHashedPassword(password, salt)))
					return true;
			}
			return false;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	private void recordNewUser(String username, String salt, String password){
		try (FileWriter fw = new FileWriter(PASSWORDPATH, true)){
			fw.write("\n"+ username + "," + salt + "," + password);
		
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean recordNewUserTest(String username, String salt, String password) {
		recordNewUser(username, salt, password);
		return true;
	}
	
	public boolean favoriteSong(String songname) {
		return this.library.favoriteSong(songname);
	}
	
	public void createNewPlayList(String name) {
		this.library.createNewPlayList(name);
	}
	
	public PlayList getPlayList(String name) {
		return this.library.getPlayList(name);
	}
	
	public void addSongToPlayList(String playName, String songName) {
		this.library.addSongToPlayList( playName, songName);
	}
	
	public void addSongToLib(Song s) {
		this.library.addSongToLib(s);
	}
	
	public void addPlayList(ArrayList<Album> albums) {
		this.library.addPlayList(albums);
	}
	
	public void addAlbum(Album a) {
		this.library.addAlbum(a);
	}
	
	public ArrayList<Album> searchAbum(String name){
		return this.library.searchAbum(name);
	}
	
	public void addToPlayList(String playlistName, Song s) {
		this.library.addToPlayList(playlistName, s);
	}
	
	public ArrayList<Song> searchSongTitle(String title){
		return this.library.searchSongTitle(title);
	}
	
	public boolean rateSongTitle(String title, int rating) {
		return this.library.rateSongTitle(title, rating);
	}
	
	public ArrayList<Song> searchSongArtist(String artist){
		return this.library.searchSongArtist(artist);
	}
	
	public ArrayList<Album> searchAlbumInfoName(String name){
		return this.library.searchAlbumInfoName(name);
	}
	
	public ArrayList<Album> searchAlbumInfoArtist(String artist){
		return this.library.searchAlbumInfoArtist(artist);
	}

	public ArrayList<PlayList> searchPlayListName(String name){
		return this.library.searchPlayListName(name);
	}
	
	public void removeSongsByName(String name) {
		this.library.removeSongsByName(name);
	}
	
	public void playSong(Song s){
		this.library.playSong(s);
	}
	
	public void createFrqList() {
		this.library.createFrqList();
	}
	
	public String getFrqListToString() {
		return this.library.getFrqListToString();
	}
	public ArrayList<Song> getFavorites() {
	    return this.library.getFavorites();
	}

	public ArrayList<Song> getSongs() {
	    return this.library.getSongs();
	}

	public ArrayList<Song> getSongsBy(int i) {
	    return this.library.getSongsBy(i);
	}

	public void removeSong(Song s) {
	    this.library.removeSong(s);
	}

	public void removeAlbum(Album a) {
	    this.library.removeAlbum(a);
	}

	public List<Song> shuffleSongs() {
	    return this.library.shuffleSongs();
	}

	public Set<String> getArtists() {
	    return this.library.getArtists();
	}

	public HashSet<Song> searchSongsGenre(String genre) {
		return this.library.getGenres().get(genre);
	}
	
	public ArrayList<Album> getAlbumList() {
	    return this.library.getAlbumList();
	}

	public ArrayList<PlayList> getPlayListList() {
	    return this.library.getPlayListList();
	}

	public ArrayList<String> getPlayListNames() {
	    return this.library.getPlayListNames();
	}

	public ArrayList<Song> getRecent() {
	    return this.library.getRecent();
	}

	public HashMap<Song, Integer> getFrequency() {
	    return this.library.getFrequency();
	}

	public ArrayList<Song> getFrequencyList() {
	    return this.library.getFrequencyList();
	}
	
	public String getUsername() {
		return this.username;
	}
	public void addAlbum(ArrayList<Album> album) {
		this.library.addAlbum(album);
	}
	
	public LibraryModel getLib() {
		return new LibraryModel(this.library);
	}
	
}
