package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;
import model.*;

class testStore {
	

    File file = new File("src/albums/19_Adele.txt");
    MusicStore store = new MusicStore();
    
	@Test
	void songInfoTest() {
		store.addAlbum(file);
		assertEquals(store.songInfo("Tired"),"Tired by Adele. Genre: Pop\n");
	}
	@Test
	void songInfoTestNull() {
		store.addAlbum(file);
		assertEquals(store.songInfo("dafs"),"Song not found!");
	}

	@Test
	void getSongTest() {
		store.addAlbum(file);
		assertEquals(store.getSong("Tired").get(0),new Song("Tired", "Adele", "Pop", "2008"));
	}
	@Test
	void getSongTestNull() {
		store.addAlbum(file);
		assertEquals(store.getSong("Tirdafsfed"),null);
	}
	@Test
	void getalbumInfoTestNF() {
		store.addAlbum(file);
		assertEquals(store.albumInfo("Tirdafsfed"),"Album not found!");
	}
	@Test
	void getalbumInfoTest() {
		store.addAlbum(file);
		assertEquals(store.albumInfo("19"),"19 by Adele\n");
	}

	@Test
	void getalbumsTest() {
		store.addAlbum(file);
		assertEquals(store.getAlbum("19").size(), 1);
	}
}
