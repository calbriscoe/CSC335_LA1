package model;

import java.util.ArrayList;

public class Album {

	private ArrayList<Song> songs;
	private String name;
	private String author;
	private String genre;
	private int year;
	
	// Add way to read in files 
	public Album(String name, String author, String genre, int year) {
		this.songs = new ArrayList<Song>();
		this.name = name; //Replace
		this.author = author;
		this.genre = genre;
		this.year = year;
	}
	
	public Album(Album album) {
		this.songs = (ArrayList<Song>) album.getSongs().clone();
		this.name = album.getName();
		this.author = album.getAuthor();
		this.genre = album.getGenre();
		this.year = album.getYear();
		
	}
	
	public int getYear() {
		return this.year;
	}
	
	
	public void addSong(Song s) {
		songs.add(s);
	}
	
	
	// Searches for a Song within album
	public ArrayList<String> searchSong(String name) {
		ArrayList<String> songList = new ArrayList<String>();
		
		// In case multiple same named songs in one Album
		for (int i = 0; i < songs.size(); i++) {
			if (songs.get(i).getName().equals(name)){
				songList.add(songs.get(i).getInfo());
			} else if (songs.get(i).getAuthor().equals(name)){
				songList.add(songs.get(i).getInfo());
			}
		}
		return songList;
	}
	
	public String getGenre(){
		return this.genre;
	}
	//Basic Getters
	public String getName() {
		return this.name;
	}
	public String getAuthor() {
		return this.author;
	}
	public String getInfo() {
		String info = this.name + " by " + this.author + " Genre: " + this.genre + " Year: " + this.year;
		return info;
	}
	public ArrayList<Song> getSongs() {
		// Is this a escaping references?
		ArrayList<Song> temp = (ArrayList<Song>) songs.clone();
		return temp;
	}
}
