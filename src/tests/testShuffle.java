package tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import model.Album;
import model.LibraryModel;
import model.MusicStore;
import model.PlayList;
import model.Song;

public class testShuffle {


    File file = new File("src/albums/19_Adele.txt");
    MusicStore store = new MusicStore();
	LibraryModel library = new LibraryModel(store);
    
	Song song1 = new Song("Waltzing Back", "No Vacation", "Indie", "2021");
	Song song2 = new Song("Yam Yam", "No Vacation", "Indie", "2017");
	Song song3 = new Song("Survival Tactics", "Joey Bada$$", "Hip-Hop", "2012");
	Song song4 = new Song("Telephones", "Vacations", "Indie", "2018");

	// Library Shuffle
	@Test
	void testLibraryShuffleOne() {
		assertTrue(library.getSongs().isEmpty());
		library.addSongToLib(song1); //"Waltzing Back", "No Vacation", "Indie", "2021"
		List<Song> shuffleOne = library.shuffleSongs();
		
		assertTrue(shuffleOne.get(0).getName().equals("Waltzing Back"));
	
	}
	@Test
	void testLibraryShuffleMany() {
		assertTrue(library.getSongs().isEmpty());
		library.addSongToLib(song1); //"Waltzing Back", "No Vacation", "Indie", "2021"
		library.addSongToLib(song2); //"Yam Yam", "No Vacation", "Indie", "2017"
		library.addSongToLib(song3); //"Survival Tactics", "Joey Bada$$", "Hip-Hop", "2012"
		library.addSongToLib(song4); //"Telephones", "Vacations", "Indie", "2018"
		List<Song> shuffleMany = library.shuffleSongs();
		assertTrue((shuffleMany.size() == 4));
		// Due to randomness of Shuffle cannot assert positions
	}
	
	// Playlist Shuffle
	@Test
	void testPlayListShuffleOne() {
		PlayList testPlay = new PlayList("Test");
		assertTrue(testPlay.getSongs().isEmpty());
		testPlay.addSong(song1); //"Waltzing Back", "No Vacation", "Indie", "2021"
		List<Song> shuffleOne = testPlay.shuffleSongs();
		
		assertTrue(shuffleOne.get(0).getName().equals("Waltzing Back"));
	
	}
	@Test
	void testPlayListShuffleMany() {
		PlayList testPlay = new PlayList("Test");
		assertTrue(testPlay.getSongs().isEmpty());
		testPlay.addSong(song1); //"Waltzing Back", "No Vacation", "Indie", "2021"
		testPlay.addSong(song2); //"Yam Yam", "No Vacation", "Indie", "2017"
		testPlay.addSong(song3); //"Survival Tactics", "Joey Bada$$", "Hip-Hop", "2012"
		testPlay.addSong(song4); //"Telephones", "Vacations", "Indie", "2018"
		List<Song> shuffleMany = testPlay.shuffleSongs();
		assertTrue((shuffleMany.size() == 4));
		// Due to randomness of Shuffle cannot assert positions
	}
}
