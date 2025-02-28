package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Album;
import model.Song;

class albumTest {

	Album album1 = new Album("Jen", "Plums");
	Song song6 = new Song("Parking Lots", "Plums", "Indie", "2015");
	Song song7 = new Song("Julia Gloria", "Plums", "Indie", "2015");
	Song song8 = new Song("Jen", "Plums", "Indie", "2015");
	Song song9 = new Song("Lounger", "Plums", "Indie", "2015");
	Song song10 = new Song("Fine Madeline", "Plums", "Indie", "2015");
	Song song11 = new Song("Room Song", "Plums", "Indie", "2015");
	Song song12 = new Song("They Love Me They Love Me", "Plums", "Indie", "2015");
	
	@Test
	void addSongTest() {
		album1.addSong(song6);
		assertEquals(album1.getSongs().size(),1);
		assertEquals(album1.getSongs().get(0),song6);
	}
	@Test
	void addSameSong() {
		album1.addSong(song6);
		album1.addSong(song6);
		assertEquals(album1.getSongs().size(),1);
		assertEquals(album1.getSongs().get(0),song6);
	}
	
	@Test
	void searchSongTest() {
		album1.addSong(song6);
		assertEquals(album1.searchSong("Parking Lots").get(0), song6);
	}
	
	@Test
	void testEquals1() {
		Album album2 = new Album(album1);
		assertTrue(album2.equals(album1));
	}
	@Test
	void testEquals2() {
		assertTrue(album1.equals(album1));
	}
	@Test
	void testEquals3() {
		assertFalse(album1.equals(song6));
	}
    @Test
    void getNameTest() {
        assertEquals("Jen", album1.getName());
    }

    @Test
    void getAuthorTest() {
        assertEquals("Plums", album1.getAuthor());
    }

    @Test
    void getInfoTest() {
        Album album = new Album("Jen", "Plums");
        assertEquals("Jen by Plums", album.getInfo());
    }
	
}
