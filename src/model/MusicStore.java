// Class - CSC 335 - LA1


package model;
import java.io.File;
import java.util.ArrayList;

//import model.Song;


public class MusicStore {

public ArrayList<Album> albumList;
	


public MusicStore() {
	this.albumList = new ArrayList<Album>();
}

public void addAlbum(File file) {
	String fileName = file.getName();
	String[] split = fileName.split("_");
	if (split.length > 1) {
		Album added = new Album(split[0], split[1].substring(0,split[1].length() - 4));
		added.addSongs(file);
		albumList.add(added);
	}
	
}

// Return Song information
public String songInfo(String name) {
	ArrayList<String> foundSongs = new ArrayList<String>();
	for (int i = 0; i < albumList.size(); i++) {
		ArrayList<Song> temp = albumList.get(i).searchSong(name);
		for (Song songs : temp) {
			foundSongs.add(songs.getInfo());
		}
	}
	if (foundSongs.size() > 0) {
		String list = "";
		for (String info : foundSongs) {
			list += info + '\n';
		}
		return list;
	} else {
		return "Song not found!";
	}
}
// Return Song object
public ArrayList<Song> getSong(String name) {
	ArrayList<Song> foundSongs = new ArrayList<Song>();
	for (Album album : albumList) {
		for (Song song : (album.searchSong(name))){
			foundSongs.add(song);
		}
	}
	if (foundSongs.size() > 0) {
		return foundSongs;
	} else {
		return null;
	}
}

// Return Album Information
public String albumInfo(String name) {
	String found = "";
	for (int i = 0; i < albumList.size(); i++) {
		if (albumList.get(i).getName().equals(name)){
			found += albumList.get(i).getInfo() + '\n';
		} else if (albumList.get(i).getAuthor().equals(name)){
			found += albumList.get(i).getInfo() + '\n';
		}
	}
	if (found.length() > 0) {
		return found;
	}
	return "Album not found!";
}
// Return Album Information
public ArrayList<Album> getAlbum(String name) {
	ArrayList<Album> found = new ArrayList<Album>();
	for (int i = 0; i < albumList.size(); i++) {
		if (albumList.get(i).getName().equals(name)){
			found.add(new Album(albumList.get(i)));
		} else if (albumList.get(i).getAuthor().equals(name)){
			found.add(new Album(albumList.get(i)));
		}
	}
	if (found.size() > 0) {
		return found;
	}
	return null;
}

public ArrayList<Album>getAlbumList(){
	ArrayList<Album> albums = new ArrayList<Album>();
	for(Album a: albumList) {
		albums.add(new Album(a));
	}
	return albums;
}
}
