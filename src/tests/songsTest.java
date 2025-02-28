package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.*;

class songsTest {

	Song song = new Song("Yam Yam", "No Vacation", "Indie", "2017");
	
	Song song1 = new Song(song);
	
	@Test
	void getInfoTest() {
		assertEquals(song.getInfo(), "Yam Yam by No Vacation. Genre: Indie");
	}
	
	@Test
	void constructorTest() {
		assertEquals(song1, song);
	}
	@Test
	void setFavoriteTest() {
		song.setFavorite();
		assertTrue(song.getFavorite());
	}
	@Test
	void getNameTest() {
		assertEquals("Yam Yam", song.getName());
	}
	@Test
	void getAuthorTest() {
		assertEquals("No Vacation", song.getAuthor());
	}
	
	@Test
	void getGenreTest() {
		assertEquals("Indie", song.getGenre());
	}
	@Test
	void getYearTest() {
		assertEquals("2017", song.getYear());
	}
	@Test
	void equalsTest01() {
		Song song01 = new Song(song1);
		assertEquals(song1, song01);
	}
	@Test
	void equalsTest02() {
		PlayList a = new PlayList("a");
		assertFalse(song1.equals(a));
	}
}
