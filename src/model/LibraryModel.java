package model;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class LibraryModel {

	private ArrayList<Song> library;
	private ArrayList<PlayList> playList;
	private ArrayList<Album> albumList; // Specs require this, bit repetitive
	private ArrayList<Song> recentList;
	private HashMap<Song, Integer> frequency;
	private HashMap<String, HashSet<Song>> genres;
	private ArrayList<Song> frequencyList;
	public  MusicStore musicStore;      
	// Is the music store public or should it be built in Library?
	
	public LibraryModel(MusicStore store) {
		this.library = new ArrayList<Song>();
		this.playList = new ArrayList<PlayList>();
		playList.add(new PlayList("favorites"));
		playList.add(new PlayList("top rated"));
		this.albumList = new ArrayList<Album>();
		this.recentList = new ArrayList<Song>();
		this.frequency = new HashMap<Song, Integer>();

		this.genres = new HashMap<String, HashSet<Song>> ();
		
		this.frequencyList = new ArrayList<Song>();
		this.musicStore = store;
	}
	
	public LibraryModel(LibraryModel other) {
		this.library = other.getLibrary();
		this.playList = other.getPlayListList();
		this.albumList = other.getAlbumList();
		this.recentList = other.getRecent();
		this.frequency = other.getFrequency();
		this.frequencyList = other.getFrequencyList();
	}

	
	public boolean favoriteSong(String songName) {
		boolean returnval = false;
		for (Song s : library) {
			if (s.getName().equals(songName)) {
				s.setFavorite();
				playList.get(0).addSong(s);;
				returnval = true;
			}
		}
		return returnval;
	}
    
	public void addPlayList(ArrayList<Album> albums) {
		if (albums == null) { return; }
		for (Album album : albums) {
			this.playList.add(new PlayList(album));
		}
	}
	public void createPlayList(String name) {
		this.playList.add(new PlayList(name));
	}
	
	public PlayList getPlayList(String name) {
		for (PlayList names : playList) {
			if (names.getName().equals(name)) {
				return names;
			}
		}
		return null;
	}
	
	// Adds song from Store to playlist
	public void addSongToPlayList(String playName, String songName) {
		for (PlayList playlist : this.playList) {
			if (playlist.getName().equals(playName)) {
				playlist = getPlayList(playName);
				playlist.addSong(musicStore.getSong(songName));
				return;
			}
		}
		PlayList playlist = new PlayList(playName);
		playlist.addSong(musicStore.getSong(songName));
		this.playList.add(playlist);
	}
    
	public void addSongToLib(Song s) {
	    if(!library.contains(s)) {
	        library.add(s);
	        
	        if(!genres.containsKey(s.getGenre())) {
	            genres.put(s.getGenre(), new HashSet<Song>());
	        }
	        genres.get(s.getGenre()).add(s);
	        if(!hasPlayList(s.getGenre())) {
	            if(genres.get(s.getGenre()).size() >= 9) {
	                playList.add(new PlayList(s.getGenre()));
	                addSongsToPlayListGenre(s.getGenre());
	            }
	        } else if(genres.get(s.getGenre()).size() >= 10) {
	            addSongsToPlayListGenre(s.getGenre());
	        }
	    }
	}
	
	private void addSongsToPlayListGenre(String genre) {
		for(Song s : genres.get(genre)) {
			for(PlayList p : playList) {
				if(p.getName().equals(genre) && !p.hasSong(s.getName())) {
					p.addSong(s);
				}
			}
		}
	}
	
	public boolean hasPlayList(String name) {
		for(PlayList p : playList) {
			if(p.getName().equals(name))
				return true;
		}
		return false;
	}

	public void addAlbum(ArrayList<Album> album) {
		for (Album a : album) {
			this.addAlbum(a);
		}
	}
	public void addAlbum(Album a) {
		if(!albumList.contains(a))
		  albumList.add(a);
	}
	public ArrayList<Album> searchAbum(String name){
		ArrayList<Album> tempList = new ArrayList<Album>();
		for (Album album : this.albumList) {
			if (album.getAuthor().equals(name)) {
				tempList.add(album);
			} else if (album.getName().equals(name)) {
				tempList.add(album);
			}
		}
		return tempList;
	}

	public void createNewPlayList(String name) {
		if(!getPlayListNames().contains(name))
			playList.add(new PlayList(name));
	}

	public void addToPlayList(String playlistName, Song s) {
		if(!library.contains(s)) {
			library.add(s);
		}
		for (PlayList playlist : playList) {
			if (playlist.getName().equals(playlistName)) {
				playlist.addSong(s);
			}
		}
	}

	public ArrayList<Song> searchSongTitle(String title) {
		ArrayList<Song> returnList = new ArrayList<Song>();
		for (Song s : library) {
			if (s.getName().equals(title)) {
				returnList.add(new Song(s));
			}
		}
		return returnList;
	}
	
	public boolean rateSongTitle(String title, int rating) {
		boolean returnVal = false;
		for (Song s : library) {
			if (s.getName().equals(title)) {
				s.setRating(rating);
				playList.get(1).addSong(s);
				returnVal = true;
			}
		}
		return returnVal;
	}
	
	public HashSet<Song> searchSongsGenre(String genre) {
	    if (genres.containsKey(genre)) {
	        return new HashSet<>(genres.get(genre));
	    } else {
	        return new HashSet<>();
	    }
	}

	public ArrayList<Song> searchSongArtist(String artist) {
		ArrayList<Song> returnList = new ArrayList<Song>();

		for (Song s : library) {
			if (s.getAuthor().equals(artist)) {
				returnList.add(new Song(s));
			}
		}
		return returnList;
	}

	public ArrayList<Album> searchAlbumInfoName(String name) {
		ArrayList<Album> returnList = new ArrayList<Album>();

		for (Album a : albumList) {
			if (a.getName().equals(name)) {
				returnList.add(new Album(a));
			}
		}
		return returnList;
	}

	public ArrayList<Album> searchAlbumInfoArtist(String artist) {
		ArrayList<Album> returnList = new ArrayList<Album>();

		for (Album a : albumList) {
			if (a.getAuthor().equals(artist)) {
				returnList.add(new Album(a));
			}
		}
		return returnList;
	}

	public ArrayList<PlayList> searchPlayListName(String name) {
		ArrayList<PlayList> returnList = new ArrayList<PlayList>();

		for (PlayList p : playList) {
			if (p.getName().equals(name)) {
				returnList.add(new PlayList(p));
			}
		}
		return returnList;
	}
	
	public void removeSongsByName(String name) {
		for(int i = library.size() - 1; i >=0; i--) {
			if(library.get(i).getName().equals(name))
				library.remove(i);
		}
	}

	public void playSong(Song s) {
		if (recentList.contains(s)) {
			recentList.remove(s);
			recentList.add(0, s);
		} else {
			recentList.add(0,s);
		}
		
		if (recentList.size() > 10) {
			recentList.remove(10);
		}
		if (!frequency.containsKey(s)){
			frequency.put(s, 1);
		} else {
			frequency.put(s, frequency.get(s)+1);
		}
	}
	
	public void createFrqList() {
		frequencyList.clear();
		Song maxSong = null;
		
		int i = 0;
		while (i < frequency.size() && i < 10) {
			int  maxInt = -1;
			for (Song s : frequency.keySet()) {
				if (!frequencyList.contains(s) && frequency.get(s) >= maxInt) {
					maxSong = s;
					maxInt = frequency.get(s);
				}
			}
		
			if (maxSong != null) {
				frequencyList.add(maxSong);
			}
			i++;
		}
	}
	
	public String getFrqListToString() {
		String result = "";
		this.createFrqList();
		for (Song s : frequencyList) {
			result+=s.getName() + " : " + frequency.get(s)+"\n";
		}
		return result;
	}

	// GETTERS AND SETTERS
	public ArrayList<Song> getFavorites() {
		ArrayList<Song> returnList = new ArrayList<Song>();
		for (Song s : library) {
			if (s.getFavorite())
				returnList.add(new Song(s));
		}
		return returnList;
	}

	public ArrayList<Song> getSongs() {
		ArrayList<Song> deepCopies = new ArrayList<Song>();
		for (Song s : library) {
			deepCopies.add(new Song(s));
		}
		return deepCopies;
	}
	public ArrayList<Song> getSongsBy(int i){
		ArrayList<Song> sortedCopy = new ArrayList<Song>();
		for (Song s : library) {
			// Empty List
			if (sortedCopy.size() == 0) {
				sortedCopy.add(new Song(s));
			} else {
				sortHelper(sortedCopy, s, i);
			} 
		}
		return sortedCopy;
	}
	public void sortHelper(ArrayList<Song> sorted, Song s, int i) {
		for (int x = 0; x < sorted.size() ; x++) {
			int comp = sorted.get(x).compareToBy(i, s);
			if (comp > -1) {
				sorted.add(x, new Song(s));
				return;
			}
		}
		sorted.add(new Song(s));
	}
	
	public void removeSong(Song s) {
		if (s == null) { return; }
		for (Song libSong : library) {
			if (libSong.equals(s)) {
				library.remove(libSong);
				return;
			}
		}
	}
	public void removeAlbum(Album a) {
		if (a == null) { return; }
		for (Album userAlbums : albumList) {
			if (userAlbums.equals(a)) {
				albumList.remove(userAlbums);
				return;
			}
		}
	}
	
	public List<Song> shuffleSongs() {
		List<Song> tempList = new ArrayList<Song>();
		for (Song s : getSongs()) {
			tempList.add(s);
		}
		java.util.Random rnd = new java.util.Random();
		Collections.shuffle(tempList, rnd);
		return tempList;
	}

	public Set<String> getArtists() {
		Set<String> artists = new HashSet<String>();

		for (Song s : library) {
			artists.add(s.getAuthor());
		}
		return artists;
	}

	public ArrayList<Album> getAlbumList() {
		ArrayList<Album> returnList = new ArrayList<Album>();
		for (Album a : albumList) {
			returnList.add(new Album(a));
		}
		return returnList;
	}

	public ArrayList<PlayList> getPlayListList() {
		ArrayList<PlayList> returnList = new ArrayList<PlayList>();
		for (PlayList p : playList) {
			returnList.add(new PlayList(p));
		}
		return returnList;
	}

	public ArrayList<String> getPlayListNames() {
		ArrayList<String> returnList = new ArrayList<String>();
		for (PlayList p : playList) {
			returnList.add(p.getName());
		}
		return returnList;
	}
	
	public ArrayList<Song> getRecent(){
		if (this.recentList == null) {
			return new ArrayList<Song>();
		}
		ArrayList<Song> tempList = new ArrayList<Song>();
		for (Song s : recentList) {
			tempList.add(new Song(s));
		}
		return tempList;
	}
	public HashMap<Song, Integer> getFrequency(){
		if (this.frequency instanceof HashMap<Song, Integer>) {
			return (HashMap<Song, Integer>) this.frequency.clone();
		} else {
			return null;
		}
	}
	public ArrayList<Song> getFrequencyList() {
		ArrayList<Song> tempList = new ArrayList<Song>();
		for (Song s : frequencyList) {
			tempList.add(new Song(s));
		}
		return tempList;
	}
	public ArrayList<Song> getLibrary(){
		return (ArrayList<Song>) this.library.clone();
	}
	
	public HashMap<String, HashSet<Song>> getGenres(){
		return (HashMap<String, HashSet<Song>>) genres.clone();
	}
}