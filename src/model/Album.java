package model;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Album {

	private ArrayList<Song> songs;
	private String name;
	private String author;
	
	// Are these needed?
	private String genre;
	private int year;
	// -------------
	
	// Add way to read in files 
	public Album(String name, String author) {
		this.songs = new ArrayList<Song>();
		this.name = name;
		this.author = author;
	}
	
	public Album(Album album) {
		this.songs = album.songs;
		this.name = album.name;
		this.author = album.author;
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
	
	public void addSongs(File file) {
		try {
	        Scanner myReader = new Scanner(file);
	        String info = myReader.nextLine();
	        String[] infoArr = info.split(",");
	        
	        String author = infoArr[1];
	        String genre  = infoArr[2];
	        String year   = infoArr[3];
	        
	        while (myReader.hasNextLine()) {
	        	String data = myReader.nextLine();
	        	songs.add(new Song(data, author, genre, year));
	        }
	        myReader.close();
	    	} catch (Exception e) {
	    		System.out.println("File error occurred.");
	    		e.printStackTrace();
	    	}
	}
	
	//Basic Getters
	public String getName() {
		return this.name;
	}
	public String getAuthor() {
		return this.author;
	}
	public String getInfo() {
		String info = this.name + " by " + this.author;
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
