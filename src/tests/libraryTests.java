package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Set;
import org.junit.jupiter.api.Test;
import model.Album;
import model.LibraryModel;
import model.MusicStore;
import model.PlayList;
import model.Song;

class libraryTests {

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

	Album album1 = new Album("Jen", "Plums");
	Album album2 = new Album("Summer Break Mixtape", "No Vacation");

	@Test
	void testEmpty() {
		assertTrue(library.getAlbumList().isEmpty());
		assertTrue(library.getArtists().isEmpty());
		assertTrue(library.getFavorites().isEmpty());
		assertTrue(library.getPlayListList().isEmpty());
		assertTrue(library.getPlayListList().isEmpty());
	}
	@Test
	void rateSongTest() {
		library.addSongToLib(song1);
		assertTrue(library.rateSongTitle("Waltzing Back", 1));
	}	
	
	@Test
	void addPlayListTest() {
		ArrayList<Album> test = new ArrayList<Album>();
		test.add(album1);
		library.addPlayList(test);
		assertEquals(library.getPlayListList().size(),1);
	}
	
	@Test
	void testCreateNewPlayList() {
		library.createNewPlayList("Test");
		assertEquals(library.getPlayListList().size(), 1);
	}
	
	@Test
	void testSearchAlbum() {
		library.addAlbum(album1);
		assertEquals(library.searchAbum("Jen").size(), 1);
		assertEquals(library.searchAbum("saf").size(), 0);
	}
	
	@Test
	void getPLTEsTS() {
		library.createNewPlayList("Test");
		store.addAlbum(file);
	    library.musicStore = store;
		library.addSongToPlayList("Test", "Tired");
		assertTrue(library.getPlayListList().get(0).hasSong("Tired"));
	}
	@Test
	void testCreatelayList() {
		library.createPlayList("Test");
		assertEquals(library.getPlayListList().size(), 1);
	}

	@Test
	void testAddSong() {
		library.addSongToLib(song1);
		library.addSongToLib(song2);
		library.addSongToLib(song3);
		ArrayList<Song> songs = new ArrayList<Song>();
		songs.add(song1);
		songs.add(song2);
		songs.add(song3);

		assertEquals(library.getSongs(), (songs));
	}

	@Test
	void testAddAlbum() {
		library.addAlbum(album1);
		assertEquals(library.getAlbumList().get(0), album1);
	}

	@Test
	void getFavorites() {
		library.addSongToLib(song2);
		library.favoriteSong("Yam Yam");
		assertEquals(library.getFavorites().get(0), song2);
	}
	
	@Test
	void addToPlayListTest() {
		library.createNewPlayList("Test");
		library.addToPlayList("Test", song1);
		assertEquals(library.getPlayListList().get(0).getSongs().get(0), song1);
	}
	
	@Test 
	void testGetArtists() {
        library.addSongToLib(song1);
        library.addSongToLib(song2);
        library.addSongToLib(song3);
        Set<String> artists = library.getArtists();
        assertEquals(2, artists.size());
        assertTrue(artists.contains("No Vacation"));
        assertTrue(artists.contains("Joey Bada$$"));
	}
	
	@Test
	void searchSongTitleTest() {
        library.addSongToLib(song1);
        library.addSongToLib(song2);
        library.addSongToLib(song3);
        assertEquals(1, library.searchSongTitle("Waltzing Back").size());
        assertEquals("Waltzing Back", library.searchSongTitle("Waltzing Back").get(0).getName());
	}
	@Test
	void searchSongArtistTest() {
        library.addSongToLib(song1);
        library.addSongToLib(song2);
        library.addSongToLib(song3);
        assertEquals(2, library.searchSongArtist("No Vacation").size());
        assertEquals("No Vacation", library.searchSongArtist("No Vacation").get(0).getAuthor());
        assertEquals("No Vacation", library.searchSongArtist("No Vacation").get(1).getAuthor());
	}

	@Test
	void searchAlbumInfoNameTest() {
        library.addAlbum(album1);
        library.addAlbum(album2);
        assertEquals(1, library.searchAlbumInfoName("Jen").size());
        assertEquals("Jen", library.searchAlbumInfoName("Jen").get(0).getName());
	}
	
	@Test
	void searchAlbumInfoArtistTest() {
        library.addAlbum(album1);
        library.addAlbum(album2);
        assertEquals(1, library.searchAlbumInfoArtist("Plums").size());
        assertEquals("Plums", library.searchAlbumInfoArtist("Plums").get(0).getAuthor());
	}
	
	@Test
	void serachPlayListName() {
		library.createNewPlayList("Test");
        assertEquals(1, library.searchPlayListName("Test").size());
        assertEquals("Test", library.searchPlayListName("Test").get(0).getName());
	}
	@Test
	void removeSongTest() {
		library.addSongToLib(song1);
		library.addSongToLib(song2);
		library.removeSongsByName("Waltzing Back");;
		assertEquals(library.getSongs().size(),1);
		assertTrue(!library.getSongs().contains(song1));
	}
	@Test
	void addSameSong() {
		library.addSongToLib(song1);
		library.addSongToLib(song1);
        assertEquals(1, library.searchSongTitle("Waltzing Back").size());
        assertEquals("Waltzing Back", library.searchSongTitle("Waltzing Back").get(0).getName());
	}
	@Test
	void removeFromEmptyLib() {
		library.removeSongsByName("Waltzing Back");;
		assertTrue(library.getSongs().isEmpty());
	}
	@Test
	void makePlayListOfSameName() {
		library.createNewPlayList("Test");
		library.createNewPlayList("Test");
		assertEquals(library.getPlayListList().size(),1);
	}
}
