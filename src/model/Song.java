package model;

public class Song {

	private String name;
	private String author;
	private String genre;
	private String year;
	private boolean favorite;
	private Rating rating;
	
	
	public Song(String name, String author, String genre, String year ) {
		this.name = name;
		this.author = author;
		this.genre = genre;
		this.year = year;
		this.favorite = false;
		this.rating = Rating.None;
	}
	public Song(Song song) {
		this.name = song.name;
		this.author = song.author;
		this.genre = song.genre;
		this.year = song.year;
		this.favorite = song.favorite;
		this.rating = song.rating;
	}
	
	// Returns a string of all the Songs information
	public String getInfo() {
		String info = this.name + " by " + this.author + ". Genre: " + this.genre;
		return info;
	}
	public void setFavorite() {
		this.favorite = !this.favorite;
	}
	public void setRating(int rating) {
		this.rating = Rating.setRating(rating);
		if (this.rating == Rating.Five) {
			this.favorite = true;
		}
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
	public String getYear() {
		return this.year;
	}
	public boolean getFavorite() {
		return favorite;
	}
	public Rating getRating() {
		return rating;
	}
    @Override
    public boolean equals(Object o) {
        if (this == o) 
        	return true;
        if (o == null || this.getClass() != o.getClass()) 
        	return false;
        Song song = (Song) o;
        	return year.equals(song.getYear()) && name.equals(song.name) && 
        			song.getFavorite() == favorite && song.getAuthor().equals(author) &&
        			song.genre.equals(genre);
    }
    @Override
    public int hashCode() {
    	int result = 0;
    	String word = this.getName();
    	for (int i = 0; i < word.length(); i++) {
    		result+= word.charAt(i)-'a';
    	}
    	word = this.getAuthor();
    	for (int i = 0; i < word.length(); i++) {
    		result+= word.charAt(i)-'a';
    	}
        return result/10;
    }
}
