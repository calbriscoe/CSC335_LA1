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
	void rateSongTest() {
		users.addNewUser(user);
		assertTrue(users.userExists("Test"));
		assertEquals(users.getUser("NotReal"), null);
		users.addSongToLib(song1, user);
		assertTrue(user.rateSongTitle("Waltzing Back", 1));
	}	
	
	@Test
	void addAlbumTest() {
		users.addNewUser(user);
		users.addAlbum(album1, user);
		assertTrue(!users.getAlbumList(user).isEmpty());
		users.removeAlbum(album1, user);
		assertTrue(users.getAlbumList(user).isEmpty());
	}	
	
	@Test
	void addPlayListTest() {
		users.addNewUser(user);
		ArrayList<Album> test = new ArrayList<Album>();
		test.add(album1);
		users.addPlayList(test, user);
		assertEquals(user.getPlayListList().size(),3);
	}
	
	@Test
	void testCreateNewPlayList() {
		users.addNewUser(user);
		users.createNewPlayList("Test", user);
		assertEquals(user.getPlayListList().size(), 3);
	}
	
	@Test
	void testSearchAlbum() {
		users.addNewUser(user);
		users.addAlbum(album1, user);
		assertEquals(users.searchAbum("Jen", user).size(), 1);
		assertEquals(users.searchAbum("saf", user).size(), 0);
	}
	
	@Test
	void getPLTEsTS() {
		users.addNewUser(user);
		users.createNewPlayList("Test", user);
		store.addAlbum(file);
		users.addSongToPlayList("Test", "Tired", user);
		assertTrue(users.getPlayListList(user).get(2).hasSong("Tired"));
	}
	@Test
	void testCreatelayList() {
		users.addNewUser(user);
		users.createNewPlayList("Test", user);
		assertEquals(users.getPlayListList(user).size(), 3);
	}

	@Test
	void testAddSong() {
		users.addNewUser(user);
		users.addSongToLib(song1, user);
		users.addSongToLib(song2, user);
		users.addSongToLib(song3, user);
		users.addSongToLib(song4, user);
		users.addSongToLib(song6, user);
		users.addSongToLib(song7, user);
		users.addSongToLib(song8, user);
		users.addSongToLib(song9, user);
		users.addSongToLib(song10, user);
		users.addSongToLib(song11, user);
		users.addSongToLib(song12, user);
		
		assertEquals(users.getPlayListList(user).size(), 3);
		ArrayList<Song> songs = new ArrayList<Song>();
		songs.add(song1);
		songs.add(song2);
		songs.add(song3);
		songs.add(song4);
		songs.add(song6);
		songs.add(song7);
		songs.add(song8);
		songs.add(song9);
		songs.add(song10);
		songs.add(song11);
		songs.add(song12);
	
		assertEquals(users.getSongs(user), (songs));
	}

	@Test
	void testAddAlbum() {
		users.addNewUser(user);
		users.addAlbum(album1, user);
		assertEquals(user.getAlbumList().get(0), album1);
	}
	@Test
	void testAddAlbums() {
		users.addNewUser(user);
		ArrayList<Album> albums = new ArrayList<Album>();
		albums.add(album1);
		albums.add(album2);
		users.addAlbum(albums, user);
		assertEquals(users.searchAbum("Jen", user).size(), 1);
		assertEquals(users.searchAbum("saf", user).size(), 0);
	}

	@Test
	void getFavorites() {
		users.addNewUser(user);
		users.addSongToLib(song2, user);
		users.favoriteSong("Yam Yam", user);
		assertEquals(user.getFavorites().get(0), song2);
		assertEquals(users.getFavorites(user).get(0), song2);
	}
	
	@Test
	void addToPlayListTest() {
		users.addNewUser(user);
		users.createNewPlayList("Test", user);
		users.addToPlayList("Test", song1, user);
		assertEquals(users.getPlayListList(user).get(2).getSongs().get(0), song1);
	}
	
	@Test 
	void testGetArtists() {
		users.addNewUser(user);
        users.addSongToLib(song1, user);
        users.addSongToLib(song2, user);
        users.addSongToLib(song3, user);
        Set<String> artists = users.getArtists(user);
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
        assertEquals(1, users.searchSongTitle("Waltzing Back", user).size());
        assertEquals("Waltzing Back", user.searchSongTitle("Waltzing Back").get(0).getName());
	}
	@Test
	void searchSongArtistTest() {
		users.addNewUser(user);
        users.addSongToLib(song1, user);
        users.addSongToLib(song2, user);
        users.addSongToLib(song3, user);
        assertEquals(2, users.searchSongArtist("No Vacation", user).size());
        assertEquals("No Vacation", users.searchSongArtist("No Vacation", user).get(0).getAuthor());
        assertEquals("No Vacation", users.searchSongArtist("No Vacation", user).get(1).getAuthor());
	}

	@Test
	void searchAlbumInfoNameTest() {
		users.addNewUser(user);
        users.addAlbum(album1, user);
        users.addAlbum(album2, user);
        assertEquals(1, users.searchAlbumInfoName("Jen", user).size());
        assertEquals("Jen", users.searchAlbumInfoName("Jen", user).get(0).getName());
	}
	
	@Test
	void searchAlbumInfoArtistTest() {
		users.addNewUser(user);
        users.addAlbum(album1, user);
        users.addAlbum(album2, user);
        assertEquals(1, users.searchAlbumInfoArtist("Plums", user).size());
        assertEquals("Plums", users.searchAlbumInfoArtist("Plums", user).get(0).getAuthor());
	}
	
	@Test
	void serachPlayListName() {
		users.addNewUser(user);
		users.createNewPlayList("Test", user);
        assertEquals(1, users.searchPlayListName("Test", user).size());
        assertEquals(3, users.getPlayListNames(user).size());
        assertEquals("Test", users.searchPlayListName("Test", user).get(0).getName());
	}
	@Test
	void removeSongTest() {
		users.addNewUser(user);
		users.addSongToLib(song1, user);
		users.addSongToLib(song2, user);
		users.removeSongsByName("Waltzing Back", user);;
		assertEquals(users.getSongs(user).size(),1);
		assertTrue(!users.getSongs(user).contains(song1));
	}
	@Test
	void addSameSong() {
		users.addNewUser(user);
		users.addSongToLib(song1, user);
		users.addSongToLib(song1, user);
        assertEquals(1, users.searchSongTitle("Waltzing Back", user).size());
        assertEquals("Waltzing Back", users.searchSongTitle("Waltzing Back", user).get(0).getName());
	}
	@Test
	void removeFromEmptyLib() {
		users.addNewUser(user);
		users.removeSongsByName("Waltzing Back", user);;
		assertTrue(users.getSongs(user).isEmpty());
	}
	@Test
	void makePlayListOfSameName() {
		users.addNewUser(user);
		users.createNewPlayList("Test", user);
		users.createNewPlayList("Test", user);
		assertEquals(users.getPlayListList(user).size(),3);
	}

	
	@Test
	void testRatingSortOne() {
		users.addNewUser(user);
		assertTrue(users.getUser(user.getUsername()).getSongs().isEmpty());
		assertEquals(users.searchSongsGenre("Indie", user), null);
		users.addSongToLib(song1, user); //"Waltzing Back", "No Vacation", "Indie", "2021"
		ArrayList<Song> sortOne = users.getSongsBy(2, user);
		assertEquals(users.searchSongsGenre("Indie", user).size(), 1);
		assertTrue(sortOne.get(0).getAuthor().equals("No Vacation"));
	}	
	
	@Test
	void removeSongTests() {
		users.addNewUser(user);
		users.addSongToLib(song1, user);
		users.addSongToLib(song2, user);
		users.removeSongsByName("Waltzing Back", user);;
		assertEquals(users.getSongs(user).size(),1);
		assertTrue(!users.getSongs(user).contains(song1));
		
		users.removeSong(song2, user);
		assertEquals(users.getSongs(user).size(),0);
	}
	
	@Test
	void rateSongTestUser() {
		users.addNewUser(user);
		users.addSongToLib(song1, user);
		assertTrue(users.rateSongTitle("Waltzing Back", 4, user));
		assertTrue(users.getPlayListList(user).get(1).hasSong("Waltzing Back"));
	}	
	
	
	@Test
	void testFrequencyListString() {
		/* Testing if it printed the string properly, mostly a visual thing
	     *  and not assert-able. 
		 */
		users.addNewUser(user);
		assertTrue((library.getFrequency().isEmpty()));
		users.playSong(song1, user);
		users.playSong(song2, user);
		users.playSong(song3, user);
		users.playSong(song4, user);
		users.playSong(song5, user);
		
		users.createFrqList(user);
		assertTrue(users.getFrequencyList(user).size()==5);
		
		assertTrue(users.getFrqListToString(user) != null);
		//System.out.print(library.getFrqListToString());
		assertTrue(true); // Printed correct
		
		users.playSong(song1, user);
		users.playSong(song1, user);
		users.playSong(song1, user);
		users.playSong(song2, user);
		users.playSong(song2, user);
		
		assertEquals(users.getRecent(user).size(), 5);
		assertTrue(!users.getFrequency(user).isEmpty());
		users.createFrqList(user);
		assertTrue(users.getFrequencyList(user).size()==5);
		
		//System.out.print(library.getFrqListToString());
		assertTrue(true); // Printed correct
	}
	
	
	
}
