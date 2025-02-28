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
	
	public PlayList(PlayList playlist) {
		this.name = playlist.getName();
		this.songList = (ArrayList<Song>) playlist.getSongs().clone();
	}
	
	public void removeSong(String name) {
		for(int i = songList.size() - 1; i >=0; i--) {
			if(songList.get(i).getName().equals(name))
				songList.remove(i);
		}
	}
	
	
	public void addSong(Song song) {
		if(!songList.contains(song))
			songList.add(song);
	}
	public void addSong(ArrayList<Song> songs) {
		if (songs == null) { return;}
		for (Song song : songs) {
			songList.add(song);
		}
	}
	public void removeSong(ArrayList<Song> song) {
		for (Song son : song) {
			songList.remove(son);
		}
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
	public boolean hasSong(String name) {
		for (Song song : songList) {
			if(song.getName().equals(name))
				return true;
		}
		return false;
	}
	
}
