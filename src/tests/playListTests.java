package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import model.PlayList;
import model.Song;

class playListTests {

	Song song1 = new Song("Waltzing Back", "No Vacation", "Indie", "2021");
	Song song2 = new Song("Yam Yam", "No Vacation", "Indie", "2017");
	Song song3 = new Song("Survival Tactics", "Joey Bada$$", "Hip-Hop", "2012");
	Song song4 = new Song("Telephones", "Vacations", "Indie", "2018");
	Song song5 = new Song("Magnetic", "ILLIT", "K-Pop", "2024");
	
	PlayList playlist = new PlayList("Test");
	
	@Test
	void createNewPlayList(){
		assertEquals(playlist.getSongs().size(),0);
	}
	@Test
	void addSongTest() {
		playlist.addSong(song1);
		assertEquals(playlist.getSongs().indexOf(song1),0);
	}
	@Test
	void addSongMultipleTest() {
		playlist.addSong(song1);
		playlist.addSong(song1);
		assertEquals(playlist.getSongs().size(), 1);
		assertEquals(playlist.getSongs().indexOf(song1),0);
	}
	@Test
	void removeSongTest() {
		playlist.addSong(song1);
		playlist.addSong(song2);
		playlist.removeSong(song1);
		assertEquals(playlist.getSongs().size(), 1);
		assertEquals(playlist.getSongs().indexOf(song2),0);
	}
	@Test
	void getNameTest(){
		assertEquals(playlist.getName(), "Test");
	}
	@Test
	void getSongsTest() {
		ArrayList<Song> oracle = new ArrayList<Song>();
		playlist.addSong(song1);
		oracle.add(song1);
		playlist.addSong(song2);
		oracle.add(song2);
		playlist.addSong(song3);
		oracle.add(song3);
		assertEquals(oracle,playlist.getSongs());
	}
	@Test
	void numSongs() {
		playlist.addSong(song1);
		playlist.addSong(song2);
		playlist.addSong(song3);
		assertEquals(3, playlist.numSongs());
	}
}
