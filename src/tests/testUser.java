package tests;
import model.*;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Set;

import org.junit.jupiter.api.Test;

class testUser {
	MusicStore store = new MusicStore();
    File file = new File("src/albums/19_Adele.txt");
	LibraryModel library = new LibraryModel(store);
	User user = new User("Test", "Password", store);
	
	@Test
	void testMakeNewUser() {
	    User user = new User("Test", "Password", store);
	    User user2 = new User("adfsadjfla", "Password123", store);
	    assertTrue(user.correctPassword("Test", "Password"));
	    assertFalse(user2.correctPassword("adfsadjfla", "Password1"));
	}
	@Test
	void genSalt() {
		User user = new User("Test", "Password", store);
		assertFalse(user.generateSalt().equals(""));
	}

	@Test
	void recordNewUserTest() {
		User user = new User("Test", "Password", store);
		user.recordNewUserTest("Test", "asdkfjasldkf", "askjdf");
	}


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
		assertTrue(user.getAlbumList().isEmpty());
		assertTrue(user.getArtists().isEmpty());
		assertTrue(user.getFavorites().isEmpty());
		assertTrue(user.getPlayListList().isEmpty());
		assertTrue(user.getPlayListList().isEmpty());
	}
	@Test
	void rateSongTest() {
		user.addSongToLib(song1);
		assertTrue(user.rateSongTitle("Waltzing Back", 1));
	}	
	
	@Test
	void addPlayListTest() {
		ArrayList<Album> test = new ArrayList<Album>();
		test.add(album1);
		user.addPlayList(test);
		assertEquals(user.getPlayListList().size(),1);
	}
	
	@Test
	void testCreateNewPlayList() {
		user.createNewPlayList("Test");
		assertEquals(user.getPlayListList().size(), 1);
	}
	
	@Test
	void testSearchAlbum() {
		user.addAlbum(album1);
		assertEquals(user.searchAbum("Jen").size(), 1);
		assertEquals(user.searchAbum("saf").size(), 0);
	}
	
	@Test
	void getPLTEsTS() {
		user.createNewPlayList("Test");
		store.addAlbum(file);
		user.addSongToPlayList("Test", "Tired");
		assertTrue(user.getPlayListList().get(0).hasSong("Tired"));
	}
	@Test
	void testCreatelayList() {
		user.createNewPlayList("Test");
		assertEquals(user.getPlayListList().size(), 1);
	}

	@Test
	void testAddSong() {
		user.addSongToLib(song1);
		user.addSongToLib(song2);
		user.addSongToLib(song3);
		ArrayList<Song> songs = new ArrayList<Song>();
		songs.add(song1);
		songs.add(song2);
		songs.add(song3);

		assertEquals(user.getSongs(), (songs));
	}

	@Test
	void testAddAlbum() {
		user.addAlbum(album1);
		assertEquals(user.getAlbumList().get(0), album1);
	}

	@Test
	void getFavorites() {
		user.addSongToLib(song2);
		user.favoriteSong("Yam Yam");
		assertEquals(user.getFavorites().get(0), song2);
	}
	
	@Test
	void addToPlayListTest() {
		user.createNewPlayList("Test");
		user.addToPlayList("Test", song1);
		assertEquals(user.getPlayListList().get(0).getSongs().get(0), song1);
	}
	
	@Test 
	void testGetArtists() {
        user.addSongToLib(song1);
        user.addSongToLib(song2);
        user.addSongToLib(song3);
        Set<String> artists = user.getArtists();
        assertEquals(2, artists.size());
        assertTrue(artists.contains("No Vacation"));
        assertTrue(artists.contains("Joey Bada$$"));
	}
	
	@Test
	void searchSongTitleTest() {
        user.addSongToLib(song1);
        user.addSongToLib(song2);
        user.addSongToLib(song3);
        assertEquals(1, user.searchSongTitle("Waltzing Back").size());
        assertEquals("Waltzing Back", user.searchSongTitle("Waltzing Back").get(0).getName());
	}
	@Test
	void searchSongArtistTest() {
        user.addSongToLib(song1);
        user.addSongToLib(song2);
        user.addSongToLib(song3);
        assertEquals(2, user.searchSongArtist("No Vacation").size());
        assertEquals("No Vacation", user.searchSongArtist("No Vacation").get(0).getAuthor());
        assertEquals("No Vacation", user.searchSongArtist("No Vacation").get(1).getAuthor());
	}

	@Test
	void searchAlbumInfoNameTest() {
        user.addAlbum(album1);
        user.addAlbum(album2);
        assertEquals(1, user.searchAlbumInfoName("Jen").size());
        assertEquals("Jen", user.searchAlbumInfoName("Jen").get(0).getName());
	}
	
	@Test
	void searchAlbumInfoArtistTest() {
        user.addAlbum(album1);
        user.addAlbum(album2);
        assertEquals(1, user.searchAlbumInfoArtist("Plums").size());
        assertEquals("Plums", user.searchAlbumInfoArtist("Plums").get(0).getAuthor());
	}
	
	@Test
	void serachPlayListName() {
		user.createNewPlayList("Test");
        assertEquals(1, user.searchPlayListName("Test").size());
        assertEquals("Test", user.searchPlayListName("Test").get(0).getName());
	}
	@Test
	void removeSongTest() {
		user.addSongToLib(song1);
		user.addSongToLib(song2);
		user.removeSongsByName("Waltzing Back");;
		assertEquals(user.getSongs().size(),1);
		assertTrue(!user.getSongs().contains(song1));
	}
	@Test
	void addSameSong() {
		user.addSongToLib(song1);
		user.addSongToLib(song1);
        assertEquals(1, user.searchSongTitle("Waltzing Back").size());
        assertEquals("Waltzing Back", user.searchSongTitle("Waltzing Back").get(0).getName());
	}
	@Test
	void removeFromEmptyLib() {
		user.removeSongsByName("Waltzing Back");;
		assertTrue(user.getSongs().isEmpty());
	}
	@Test
	void makePlayListOfSameName() {
		user.createNewPlayList("Test");
		user.createNewPlayList("Test");
		assertEquals(user.getPlayListList().size(),1);
	}
}
