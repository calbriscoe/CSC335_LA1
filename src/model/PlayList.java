package model;

import java.util.ArrayList;

public class PlayList {

	private String name;
	private ArrayList<Song> songList;
	
	public PlayList(String name) {
		this.name = name;
		this.songList = new ArrayList<Song>();
	}
	
	public PlayList(PlayList playlist) {
		this.name = playlist.getName();
		this.songList = (ArrayList<Song>) playlist.getSongs().clone();
	}
	
	public void addSong(Song song) {
		if(!songList.contains(song))
			songList.add(song);
	}
	public void removeSong(Song song) {
		songList.remove(song);
	}
	
	public String getName() {
		return this.name;
	}
	
	public ArrayList<Song> getSongs() {
		ArrayList<Song> returnList = new ArrayList<Song>();
		for(Song s: songList) {
			returnList.add(new Song(s));
		}
		return returnList;
	}
	
	public int numSongs() {
		return this.songList.size();
	}
	
	
	
}