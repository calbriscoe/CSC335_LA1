package model;

public class Song {

	private String name;
	private String author;
	private String genre;
	private int year;
	private boolean favorite;
	
	
	public Song(String name, String author, String genre, int year ) {
		this.name = name;
		this.author = author;
		this.genre = genre;
		this.year = year;
		this.favorite = false;
	}
	
	public Song(Song s) {
		this.name = s.getName();
		this.author = s.getAuthor();
		this.genre = s.getGenre();
		this.year = s.getYear();
		this.favorite = s.getFavorite();
	}
	
	// Returns a string of all the Songs information
	public String getInfo() {
		String info = this.name + " by " + this.author + ". Genre: " + this.genre;
		return info;
	}
	public void setFavorite() {
		this.favorite = !this.favorite;
	}
	
	// Basic Getters (No references, all primitive)
	public String getName() {
		return this.name;
	}
	public String getAuthor() {
		return this.author;
	}
	public String getGenre() {
		return this.genre;
	}
	public int getYear() {
		return this.year;
	}
	public boolean getFavorite() {
		return favorite;
	}
	
    @Override
    public boolean equals(Object o) {
        if (this == o) 
        	return true;
        if (o == null || this.getClass() != o.getClass()) 
        	return false;
        Song song = (Song) o;
        	return year == song.getYear() && name.equals(song.name) && 
        			song.getFavorite() == favorite && author.equals(author) &&
        			song.genre.equals(genre);
    }
}