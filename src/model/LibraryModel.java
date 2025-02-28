package model;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class LibraryModel {

	private ArrayList<Song> library;
	private ArrayList<PlayList> playList;
	private ArrayList<Album> albumList; // Specs require this, bit repetitive
	public  MusicStore musicStore;      
	// Is the music store public or should it be built in Library?
	
	public LibraryModel() {
		this.library = new ArrayList<Song>();
		this.playList = new ArrayList<PlayList>();
		this.albumList = new ArrayList<Album>();
	}

	public void favoriteSong(String songName) {
		for (Song s : library) {
			if (s.getName().equals(songName)) {
				s.setFavorite();
			}
		}
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
	public void addSongToPlayList(String playName, String songName, MusicStore store) {
		for (PlayList playList : this.playList) {
			if (playList.getName().equals(playName)) {
				playList = getPlayList(playName);
				playList.addSong(store.getSong(songName));
				return;
			}
		}
		PlayList playList = new PlayList(playName);
		this.playList.add(playList);
		playList.addSong(musicStore.getSong(songName));
	}
    
	public void addSongToLib(Song s) {
		if(!library.contains(s))
			library.add(s);
	}

	public void addAlbum(Album a) {
		if(!albumList.contains(a))
		  albumList.add(a);
	}

	public void createNewPlayList(String name) {
		if(!getPlayListNames().contains(name))
			playList.add(new PlayList(name));
	}

	public void addToPlayList(String playlistName, Song s) {
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
	
	public void removeSongs(String name) {
		for (PlayList playlist : this.playList) {
			for (Song songs : playlist.getSongs()) {
				if (songs.getName().equals(name)) {
					playlist.getSongs().remove(songs);
				}
			}
		}
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
}