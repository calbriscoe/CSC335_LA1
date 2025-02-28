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
		if(!songs.contains(s))
			songs.add(s);
	}

	
	// Searches for a Song within album
	public ArrayList<Song> searchSong(String name) {
		ArrayList<Song> songList = new ArrayList<Song>();
		
		for(Song s : songs) {
			if(s.getName().equals(name))
				songList.add(new Song(s));
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

    @Override
    public boolean equals(Object o) {
        if (this == o) 
        	return true;
        if (o == null || this.getClass() != o.getClass()) 
        	return false;
        Album album = (Album) o;
        	return year == album.getYear() && name.equals(album.name) && 
        			author.equals(author) &&
        			album.getGenre().equals(genre) && album.getSongs().equals(this.getSongs());
    }
}
