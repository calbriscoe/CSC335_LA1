package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Set;

import org.junit.jupiter.api.Test;

import model.*;

class testUsers {
	MusicStore store = new MusicStore();
    File file = new File("src/albums/19_Adele.txt");
	LibraryModel library = new LibraryModel(store);
	User user = new User("Test", "Password", store);
	Users users = new Users();

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
		users.addNewUser(user);
		assertTrue(user.getAlbumList().isEmpty());
		assertTrue(user.getArtists().isEmpty());
		assertTrue(user.getFavorites().isEmpty());
		assertTrue(user.getPlayListList().isEmpty());
		assertTrue(user.getPlayListList().isEmpty());
	}
	@Test
	void rateSongTest() {
		users.addNewUser(user);
		users.addSongToLib(song1, user);
		assertTrue(user.rateSongTitle("Waltzing Back", 1));
	}	
	
	@Test
	void addPlayListTest() {
		users.addNewUser(user);
		ArrayList<Album> test = new ArrayList<Album>();
		test.add(album1);
		users.addPlayList(test, user);
		assertEquals(user.getPlayListList().size(),1);
	}
	
	@Test
	void testCreateNewPlayList() {
		users.addNewUser(user);
		users.createNewPlayList("Test", user);
		assertEquals(user.getPlayListList().size(), 1);
	}
	
	@Test
	void testSearchAlbum() {
		users.addNewUser(user);
		users.addAlbum(album1, user);
		assertEquals(user.searchAbum("Jen").size(), 1);
		assertEquals(user.searchAbum("saf").size(), 0);
	}
	
	@Test
	void getPLTEsTS() {
		users.addNewUser(user);
		users.createNewPlayList("Test", user);
		store.addAlbum(file);
		users.addSongToPlayList("Test", "Tired", user);
		assertTrue(user.getPlayListList().get(0).hasSong("Tired"));
	}
	@Test
	void testCreatelayList() {
		users.addNewUser(user);
		user.createNewPlayList("Test");
		assertEquals(user.getPlayListList().size(), 1);
	}

	@Test
	void testAddSong() {
		users.addNewUser(user);
		users.addSongToLib(song1, user);
		users.addSongToLib(song2, user);
		users.addSongToLib(song3, user);
		ArrayList<Song> songs = new ArrayList<Song>();
		songs.add(song1);
		songs.add(song2);
		songs.add(song3);

		assertEquals(user.getSongs(), (songs));
	}

	@Test
	void testAddAlbum() {
		users.addNewUser(user);
		users.addAlbum(album1, user);
		assertEquals(user.getAlbumList().get(0), album1);
	}

	@Test
	void getFavorites() {
		users.addNewUser(user);
		users.addSongToLib(song2, user);
		users.favoriteSong("Yam Yam", user);
		assertEquals(user.getFavorites().get(0), song2);
	}
	
	@Test
	void addToPlayListTest() {
		users.addNewUser(user);
		user.createNewPlayList("Test");
		user.addToPlayList("Test", song1);
		assertEquals(user.getPlayListList().get(0).getSongs().get(0), song1);
	}
	
	@Test 
	void testGetArtists() {
		users.addNewUser(user);
        users.addSongToLib(song1, user);
        users.addSongToLib(song2, user);
        users.addSongToLib(song3, user);
        Set<String> artists = user.getArtists();
        assertEquals(2, artists.size());
        assertTrue(artists.contains("No Vacation"));
        assertTrue(artists.contains("Joey Bada$$"));
	}
	
	@Test
	void searchSongTitleTest() {
		users.addNewUser(user);
        users.addSongToLib(song1, user);
        users.addSongToLib(song2, user);
        users.addSongToLib(song3, user);
        assertEquals(1, user.searchSongTitle("Waltzing Back").size());
        assertEquals("Waltzing Back", user.searchSongTitle("Waltzing Back").get(0).getName());
	}
	@Test
	void searchSongArtistTest() {
		users.addNewUser(user);
        users.addSongToLib(song1, user);
        users.addSongToLib(song2, user);
        users.addSongToLib(song3, user);
        assertEquals(2, user.searchSongArtist("No Vacation").size());
        assertEquals("No Vacation", user.searchSongArtist("No Vacation").get(0).getAuthor());
        assertEquals("No Vacation", user.searchSongArtist("No Vacation").get(1).getAuthor());
	}

	@Test
	void searchAlbumInfoNameTest() {
		users.addNewUser(user);
        users.addAlbum(album1, user);
        users.addAlbum(album2, user);
        assertEquals(1, user.searchAlbumInfoName("Jen").size());
        assertEquals("Jen", user.searchAlbumInfoName("Jen").get(0).getName());
	}
	
	@Test
	void searchAlbumInfoArtistTest() {
		users.addNewUser(user);
        users.addAlbum(album1, user);
        users.addAlbum(album2, user);
        assertEquals(1, user.searchAlbumInfoArtist("Plums").size());
        assertEquals("Plums", user.searchAlbumInfoArtist("Plums").get(0).getAuthor());
	}
	
	@Test
	void serachPlayListName() {
		users.addNewUser(user);
		users.createNewPlayList("Test", user);
        assertEquals(1, user.searchPlayListName("Test").size());
        assertEquals("Test", user.searchPlayListName("Test").get(0).getName());
	}
	@Test
	void removeSongTest() {
		users.addNewUser(user);
		users.addSongToLib(song1, user);
		users.addSongToLib(song2, user);
		users.removeSongsByName("Waltzing Back", user);;
		assertEquals(user.getSongs().size(),1);
		assertTrue(!user.getSongs().contains(song1));
	}
	@Test
	void addSameSong() {
		users.addNewUser(user);
		users.addSongToLib(song1, user);
		users.addSongToLib(song1, user);
        assertEquals(1, user.searchSongTitle("Waltzing Back").size());
        assertEquals("Waltzing Back", user.searchSongTitle("Waltzing Back").get(0).getName());
	}
	@Test
	void removeFromEmptyLib() {
		users.addNewUser(user);
		users.removeSongsByName("Waltzing Back", user);;
		assertTrue(user.getSongs().isEmpty());
	}
	@Test
	void makePlayListOfSameName() {
		users.addNewUser(user);
		users.createNewPlayList("Test", user);
		users.createNewPlayList("Test", user);
		assertEquals(user.getPlayListList().size(),1);
	}

	
	
}
