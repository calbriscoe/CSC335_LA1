package model;

import java.util.ArrayList;
import model.Song;

public class LibraryModel {
	
	private ArrayList<PlayList> playList;
	private ArrayList<Album> albumList; // Specs require this, bit repetitive 
	
	public LibraryModel() {
		this.playList = new ArrayList<PlayList>();
		this.albumList = new ArrayList<Album>();
	}
	
	public void addPlayList(Album album) {
		this.albumList.add(album);
	}
	public void addPlayList(PlayList playList) {
		this.playList.add(playList);
	}
	
	public String songInfo(String name) {
		return "";
	}
	
}