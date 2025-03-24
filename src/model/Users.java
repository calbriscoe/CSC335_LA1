package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Users {

	private HashMap<String, User> users;
	
	public Users() {
		this.users = new HashMap<String, User>();
	}
	public void addNewUser(User u){
		users.put(u.getUsername(), u);
	}
	public User getUser(String username) {
		if(users.containsKey(username)) {
			return new User(users.get(username));
		}else {
			return null;
		}
	}
	
	public void addAlbum(ArrayList<Album> album, User u) {
		users.get(u.getUsername()).addAlbum(album);
	}
	
	public boolean userExists(String username) {
		return users.containsKey(username);
	}
	
	public boolean favoriteSong(String songname, User u) {
		return users.get(u.getUsername()).favoriteSong(songname);
	}
	
	public void createNewPlayList(String name, User u) {
		users.get(u.getUsername()).createNewPlayList(name);
	}
	
	public PlayList getPlayList(String name, User u) {
		return users.get(u.getUsername()).getPlayList(name);
	}
	
	public void addSongToPlayList(String playName, String songName, User u) {
		users.get(u.getUsername()).addSongToPlayList( playName, songName);
	}
	
	public void addSongToLib(Song s, User u) {
		users.get(u.getUsername()).addSongToLib(s);
	}
	
	public void addAlbum(Album a, User u) {
		users.get(u.getUsername()).addAlbum(a);
	}
	
	public ArrayList<Album> searchAbum(String name, User u){
		return users.get(u.getUsername()).searchAbum(name);
	}
	
	public void addToPlayList(String playlistName, Song s, User u) {
		users.get(u.getUsername()).addToPlayList(playlistName, s);
	}
	
	public ArrayList<Song> searchSongTitle(String title, User u){
		return users.get(u.getUsername()).searchSongTitle(title);
	}
	
	public boolean rateSongTitle(String title, int rating, User u) {
		return users.get(u.getUsername()).rateSongTitle(title, rating);
	}
	
	public HashSet<Song> searchSongsGenre(String genre, User u) {
		return users.get(u.getUsername()).searchSongsGenre(genre);
	}
	
	public ArrayList<Song> searchSongArtist(String artist, User u){
		return users.get(u.getUsername()).searchSongArtist(artist);
	}
	
	public ArrayList<Album> searchAlbumInfoName(String name, User u){
		return users.get(u.getUsername()).searchAlbumInfoName(name);
	}
	
	public ArrayList<Album> searchAlbumInfoArtist(String artist, User u){
		return users.get(u.getUsername()).searchAlbumInfoArtist(artist);
	}

	public ArrayList<PlayList> searchPlayListName(String name, User u){
		return users.get(u.getUsername()).searchPlayListName(name);
	}
	
	public void removeSongsByName(String name, User u) {
		users.get(u.getUsername()).removeSongsByName(name);
	}
	
	public void playSong(Song s, User u){
		users.get(u.getUsername()).playSong(s);
	}
	
	public void createFrqList(User u) {
		users.get(u.getUsername()).createFrqList();
	}
	
	public String getFrqListToString(User u) {
		return users.get(u.getUsername()).getFrqListToString();
	}
	public ArrayList<Song> getFavorites(User u) {
	    return users.get(u.getUsername()).getFavorites();
	}

	public ArrayList<Song> getSongs(User u) {
	    return users.get(u.getUsername()).getSongs();
	}

	public ArrayList<Song> getSongsBy(int i,User u) {
	    return users.get(u.getUsername()).getSongsBy(i);
	}

	public void removeSong(Song s, User u) {
		users.get(u.getUsername()).removeSong(s);
	}

	public void removeAlbum(Album a, User u) {
		users.get(u.getUsername()).removeAlbum(a);
	}

	public void addPlayList(ArrayList<Album> albums, User u) {
		users.get(u.getUsername()).addPlayList(albums);
	}
	
	public List<Song> shuffleSongs(User u) {
	    return users.get(u.getUsername()).shuffleSongs();
	}

	public Set<String> getArtists(User u) {
	    return users.get(u.getUsername()).getArtists();
	}

	public ArrayList<Album> getAlbumList(User u) {
	    return users.get(u.getUsername()).getAlbumList();
	}

	public ArrayList<PlayList> getPlayListList(User u) {
	    return users.get(u.getUsername()).getPlayListList();
	}

	public ArrayList<String> getPlayListNames(User u) {
	    return users.get(u.getUsername()).getPlayListNames();
	}

	public ArrayList<Song> getRecent(User u) {
	    return users.get(u.getUsername()).getRecent();
	}

	public HashMap<Song, Integer> getFrequency(User u) {
	    return users.get(u.getUsername()).getFrequency();
	}

	public ArrayList<Song> getFrequencyList(User u) {
	    return users.get(u.getUsername()).getFrequencyList();
	}	
}
