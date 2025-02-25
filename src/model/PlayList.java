package model;

import java.util.ArrayList;

public class PlayList {
	private String name;
	private ArrayList<Song> songList;
	
	public PlayList(String name) {
		this.name = name;
		this.songList = new ArrayList<Song>();
	}
	public PlayList(Album album) {
		this.name = album.getName();
		this.songList = new ArrayList<Song>(album.getSongs());
	}
	
	public void addSong(Song song) {
		songList.add(song);
	}
	public void removeSong(Song song) {
		songList.remove(song);
	}
	
	
	// Getters
	public String getName() {
		return this.name;
	}
}