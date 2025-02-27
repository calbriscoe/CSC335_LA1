package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class LibraryModel {
	
	private ArrayList<Song> library;
	private ArrayList<PlayList> playList;
	private ArrayList<Album> albumList; // Specs require this, bit repetitive 
	
	public LibraryModel() {
		this.library = new ArrayList<Song>();
		this.playList = new ArrayList<PlayList>();
		this.albumList = new ArrayList<Album>();
	}
		
	public void addSongToLib(Song s) {
		library.add(s);
	}
	
	public void addAlbum(Album a) {
		albumList.add(a);
	}
	
	public void createNewPlayList(String name) {
		playList.add(new PlayList(name));
	}
	
	public ArrayList<Song> getFavorites(){
		ArrayList<Song> returnList = new ArrayList<Song>();
		for(Song s : library) {
			if(s.getFavorite())
				returnList.add(new Song(s));
		}
		return returnList;
	}
	
	public void addToPlayList(String playlistName, Song s){
		for(PlayList playlist : playList) {	
			if(playlist.getName().equals(playlistName)) {
				playlist.addSong(s);
			}
		}
	}
	
	public void addPlayList(PlayList playList) {
		this.playList.add(playList);
	}
	
	public ArrayList<Song> getSongs() {
		ArrayList<Song> deepCopies = new ArrayList<Song>();
		for(Song s: library) {
			deepCopies.add(new Song(s));
		}
		return deepCopies;
	}
	
	public ArrayList<Song> searchSongTitle(String title) {
		ArrayList<Song> returnList = new ArrayList<Song>();
		for(Song s: library) {
			if(s.getName().equals(title)) {
				returnList.add(new Song(s));
			}
		}
		return returnList;
	}
	
	public ArrayList<Song> searchSongArtist(String artist) {
		ArrayList<Song> returnList = new ArrayList<Song>();
	
		for(Song s: library) {
			if(s.getAuthor().equals(artist)) {
				returnList.add(new Song(s));
			}
		}
		return returnList;
	}
	
	public ArrayList<Album> searchAlbumInfoName(String name) {
		ArrayList<Album> returnList = new ArrayList<Album>();

		for(Album a: albumList) {
			if(a.getName().equals(name)) {
				returnList.add(new Album(a));
			}
		}
		return returnList;
	}
	
	public ArrayList<Album> searchAlbumInfoArtist(String artist) {
		ArrayList<Album> returnList = new ArrayList<Album>();

		for(Album a: albumList) {
			if(a.getAuthor().equals(artist)) {
				returnList.add(new Album(a));
			}
		}
		return returnList;
	}
	
	public ArrayList<PlayList> searchPlayListName(String name) {
		ArrayList<PlayList> returnList = new ArrayList<PlayList>();

		for(PlayList p: playList) {
			if(p.getName().equals(name)) {
				returnList.add(new PlayList(p));
			}
		}
		return returnList;
	}
	
	public Set<String> getArtists(){
		Set<String> artists = new HashSet<String>();
		
		for(Song s : library) {
			artists.add(s.getAuthor());
		}		
		return artists;
	}
	
	public ArrayList<String> getAlbumList(){
		ArrayList<String> returnList = new ArrayList<String>();
		for(Album a : albumList) {
			returnList.add(a.getName());
		}
		return returnList;
	}
	
	public ArrayList<String> getPlayListList(){
		ArrayList<String> returnList = new ArrayList<String>();
		for(PlayList p : playList) {
			returnList.add(p.getName());
		}
		return returnList;
	}
	
}