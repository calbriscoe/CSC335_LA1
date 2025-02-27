package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import model.Album;
import model.LibraryModel;
import model.Song;


class libraryTests {


	LibraryModel library = new LibraryModel();
	
	Song song1 = new Song("Waltzing Back", "No Vacation", "Indie", 2021);
	Song song2 = new Song("Yam Yam", "No Vacation", "Indie", 2017);
	Song song3 = new Song("Survival Tactics", "Joey Bada$$", "Hip-Hop", 2012);
	Song song4 = new Song("Telephones", "Vacations", "Indie", 2018);
	Song song5 = new Song("Magnetic", "ILLIT", "K-Pop", 2024);

	Song song6 = new Song("Parking Lots", "Plums", "Indie", 2015);
	Song song7 = new Song("Julia Gloria", "Plums", "Indie", 2015);
	Song song8 = new Song("Jen", "Plums", "Indie", 2015);
	Song song9 = new Song("Lounger", "Plums", "Indie", 2015);
	Song song10 = new Song("Fine Madeline", "Plums", "Indie", 2015);
	Song song11= new Song("Room Song", "Plums", "Indie", 2015);
	Song song12 = new Song("They Love Me They Love Me", "Plums", "Indie", 2015);
	
	Album album1 = new Album("Jen", "Plums", "Indie", 2015);

	
	
	@Test 
	void testEmpty() {
		assertTrue(library.getAlbumList().isEmpty());
		assertTrue(library.getArtists().isEmpty());
		assertTrue(library.getFavorites().isEmpty());
		assertTrue(library.getPlayListList().isEmpty());
		assertTrue(library.getPlayListList().isEmpty());
	}
	
	
	@Test
	void testCreateNewPlayList() {
		library.createNewPlayList("Test");
		assertEquals(library.getPlayListList().size(),1);
	}
	
	@Test
	void testAddSong(){
		library.addSongToLib(song1);
		library.addSongToLib(song2);
		library.addSongToLib(song3);
		ArrayList<Song> songs = new ArrayList<Song>();
		songs.add(song1);
		songs.add(song2);
		songs.add(song3);
		
		assertEquals(library.getSongs(),(songs));
	}
	
	

}
