package tests;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import model.Album;
import model.LibraryModel;
import model.MusicStore;
import model.Song;

public class testRemove {
	LibraryModel library = new LibraryModel();

    File file = new File("src/albums/19_Adele.txt");
    MusicStore store = new MusicStore();
    
	Song song1 = new Song("Waltzing Back", "No Vacation", "Indie", "2021");
	Song song2 = new Song("Yam Yam", "No Vacation", "Indie", "2017");
	Song song3 = new Song("Survival Tactics", "Joey Bada$$", "Hip-Hop", "2012");
	Song song4 = new Song("Telephones", "Vacations", "Indie", "2018");
	Song song5 = new Song("Magnetic", "ILLIT", "K-Pop", "2024");

	Song song6 = new Song("Parking Lots", "Plums", "Indie", "2015");
	Song song7 = new Song("Julia Gloria", "Plums", "Indie", "2015");
	Song song8 = new Song("Jen", "Plums", "Indie", "2015");
	Song song9 = new Song("Lounger", "Plums", "Indie", "2015");
	Song song10 = new Song("Fine Madeline", "Plums", "Indie", "2015");
	Song song11 = new Song("Room Song", "Plums", "Indie", "2015");
	Song song12 = new Song("They Love Me They Love Me", "Plums", "Indie", "2015");

	@Test
	void testSongRemoveOneAndNone() {
		assertTrue(library.getSongs().isEmpty());
		library.removeSong(song1);
		library.removeSong(null);
		assertTrue(library.getSongs().isEmpty());
		
		library.addSongToLib(song1); //"Waltzing Back", "No Vacation", "Indie", "2021"
		assertTrue(library.getSongs().size() == 1);

		library.removeSong(song1);
		assertTrue(library.getSongs().size() == 0);
	}
	
	@Test
	void testSongRemoveFromMany() {
		assertTrue(library.getSongs().isEmpty());
		library.addSongToLib(song1); //"Waltzing Back", "No Vacation", "Indie", "2021"
		library.addSongToLib(song2); //"Yam Yam", "No Vacation", "Indie", "2017"
		library.addSongToLib(song3); //"Survival Tactics", "Joey Bada$$", "Hip-Hop", "2012"
		library.addSongToLib(song4); //"Telephones", "Vacations", "Indie", "2018"
		assertTrue(library.getSongs().size() == 4);
		
		library.removeSong(song3);
		assertTrue(library.getSongs().size() == 3);
		library.removeSong(song4);
		assertTrue(library.getSongs().size() == 2);
		library.removeSong(song1);
		assertTrue(library.getSongs().size() == 1);
		library.removeSong(song2);
		assertTrue(library.getSongs().size() == 0);
	
	}
	
	@Test
	void testSongRemoveFromLots() {
		assertTrue(library.getSongs().isEmpty());
		library.addSongToLib(song1); //"Waltzing Back", "No Vacation", "Indie", "2021"
		library.addSongToLib(song2); //"Yam Yam", "No Vacation", "Indie", "2017"
		library.addSongToLib(song3); //"Survival Tactics", "Joey Bada$$", "Hip-Hop", "2012"
		library.addSongToLib(song4); //"Telephones", "Vacations", "Indie", "2018"
		library.addSongToLib(song7); //"Julia Gloria", "Plums", "Indie", "2015"
		library.addSongToLib(song8); //"Jen", "Plums", "Indie", "2015"
		library.addSongToLib(song9); //"Lounger", "Plums", "Indie", "2015"
		library.addSongToLib(song10);//"Fine Madeline", "Plums", "Indie", "2015"
		library.addSongToLib(song11);//"Room Song", "Plums", "Indie", "2015"
		assertTrue((library.getSongs().size() == 9));
		
		library.removeSong(song9);
		assertTrue(library.getSongs().size() == 8);
		library.removeSong(song1);
		assertTrue(library.getSongs().size() == 7);
		library.removeSong(song7);
		assertTrue(library.getSongs().size() == 6);
		library.removeSong(song10);
		assertTrue(library.getSongs().size() == 5);
	}
	
	// Album Tests
	Album album1 = new Album("Jen", "Plums");
	Album album2 = new Album("Summer Break Mixtape", "No Vacation");
	Album album3 = new Album("Begin Again", "Norah Jones");
	Album album4 = new Album("Mission Bell", "Amos Lee");
	Album album5 = new Album("Sons", "The Heavy");
	Album album6 = new Album("Tapestry", "Carol King");
	
	Song aSong1 = new Song("Parking Lots", "Plums", "Indie", "2015");
	Song aSong2 = new Song("Julia Gloria", "Plums", "Indie", "2015");
	Song bSong1 = new Song("Jen", "Plums", "Indie", "2015");
	
	@Test
	void testAlbumRemoveOneAndNone() {	
		album1.addSong(aSong1);
		album1.addSong(aSong2);
		
		assertTrue(library.getAlbumList().size() == 0);
		library.removeAlbum(album1);
		assertTrue(library.getAlbumList().size() == 0);
		library.removeAlbum(null);
		assertTrue(library.getAlbumList().size() == 0);
		
		library.addAlbum(album1);
		assertTrue(library.getAlbumList().size() == 1);
		library.removeAlbum(album1);
		assertTrue(library.getAlbumList().size() == 0);
	}
	
	@Test
	void testAlbumRemoveFromMany() {	
		album1.addSong(aSong1);
		album2.addSong(aSong1);
		album3.addSong(aSong1);
		
		library.addAlbum(album1);
		library.addAlbum(album2);
		library.addAlbum(album3);
		assertTrue(library.getAlbumList().size() == 3);
		library.removeAlbum(album1);
		assertTrue(library.getAlbumList().size() == 2);
		library.removeAlbum(album2);
		assertTrue(library.getAlbumList().size() == 1);
		library.removeAlbum(album3);
		assertTrue(library.getAlbumList().size() == 0);
	}
	
	@Test
	void testAlbumRemoveFromLots() {	
		album1.addSong(aSong1);
		album2.addSong(aSong1);
		album3.addSong(aSong1);
		album4.addSong(aSong1);
		album5.addSong(aSong1);
		album6.addSong(aSong1);
		
		library.addAlbum(album1);
		library.addAlbum(album2);
		library.addAlbum(album3);
		library.addAlbum(album4);
		library.addAlbum(album5);
		library.addAlbum(album6);
		assertTrue(library.getAlbumList().size() == 6);
		library.removeAlbum(album5);
		assertTrue(library.getAlbumList().size() == 5);
		library.removeAlbum(album2);
		assertTrue(library.getAlbumList().size() == 4);
		library.removeAlbum(album6);
		assertTrue(library.getAlbumList().size() == 3);
	}
	
}
