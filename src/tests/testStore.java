package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;
import model.*;

class testStore {
	

    File file = new File("src/albums/19_Adele.txt");
    MusicStore store = new MusicStore();
    
	
	@Test
	void addAlbumtest() {
		store.addAlbum(file);
		System.out.println(store.albumList.get(0).getSongs().get(0).getName());
	}
	
	@Test
	void songInfoTest() {
		System.out.println(store.songInfo("Daydreamer"));
	}

}
