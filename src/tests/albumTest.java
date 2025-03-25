package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

import model.Album;
import model.Song;

class albumTest {

	Album album1 = new Album("Jen", "Plums");
	Song song6 = new Song("Parking Lots", "Plums", "Indie", "2015");
	Song song7 = new Song("Julia Gloria", "Plums", "Indie", "2015");
	Song song8 = new Song("Jen", "Plums", "Indie", "2015");
	File file = new File("src/albums/19_Adele.txt");
	Album album2 = new Album("21", "Adele");
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
    @Test
    void testWhatEverThisIs() {
    	album2.addSongs(file);
    	assertEquals(album2.getYear(), "2008");
    	assertEquals(album2.getGenre(), "Pop");
    	assertEquals(album2.getFullInfo(),"21 by Adele created in 2008. Genre: Pop");
    }
    
    @Test
    void testHashCode() {
    	Album album1 = new Album("Jen", "Plums");
    	Album album2 = new Album("Jen", "Plums");
    	assertEquals(album1.hashCode(), album2.hashCode());
    }
	
}
