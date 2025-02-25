package model;

import java.io.File;
import java.util.ArrayList;
import model.Song;

public class LibraryModel {

	private ArrayList<PlayList> playList;
	private ArrayList<Album> albumList; // Specs require this, bit repetitive
	public  MusicStore musicStore;      
	// Is the music store public or should it be built in Library?
	
	public LibraryModel() {
		this.playList = new ArrayList<PlayList>();
		this.albumList = new ArrayList<Album>();
	}
	
	public void addPlayList(Album album) {
		this.playList.add(new PlayList(album));
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
		PlayList playList = getPlayList(playName);
		//playList.addSong(musicStore.findSong());
	}
	
	public String songInfo(String name) {
		return "";
	}
	
}
