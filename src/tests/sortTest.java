package tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import model.Album;
import model.LibraryModel;
import model.MusicStore;
import model.Song;

public class sortTest {


    File file = new File("src/albums/19_Adele.txt");
    MusicStore store = new MusicStore();
	LibraryModel library = new LibraryModel(store);
    
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
	void testNameSortOne() {
		assertTrue(library.getSongs().isEmpty());
		library.addSongToLib(song1); //"Waltzing Back", "No Vacation", "Indie", "2021"
		ArrayList<Song> sortOne = library.getSongsBy(0);
		
		assertTrue(sortOne.get(0).getName().equals("Waltzing Back"));
	
	}
	
	@Test
	void testNameSortMany() {
		assertTrue(library.getSongs().isEmpty());
		library.addSongToLib(song1); //"Waltzing Back", "No Vacation", "Indie", "2021"
		library.addSongToLib(song2); //"Yam Yam", "No Vacation", "Indie", "2017"
		library.addSongToLib(song3); //"Survival Tactics", "Joey Bada$$", "Hip-Hop", "2012"
		library.addSongToLib(song4); //"Telephones", "Vacations", "Indie", "2018"
		assertTrue((library.getSongs().size() == 4));
		
		ArrayList<Song> sortFour = library.getSongsBy(0);
	 	assertTrue(sortFour.get(0).getName().equals("Survival Tactics")); //
		assertTrue(sortFour.get(1).getName().equals("Telephones")); //
		assertTrue(sortFour.get(2).getName().equals("Waltzing Back")); //
		assertTrue(sortFour.get(3).getName().equals("Yam Yam"));		
	}
	
	@Test
	void testNameSortLots() {
		assertTrue(library.getSongs().isEmpty());
		library.addSongToLib(song1); //"Waltzing Back", "No Vacation", "Indie", "2021"
		library.addSongToLib(song2); //"Yam Yam", "No Vacation", "Indie", "2017"
		library.addSongToLib(song3); //"Survival Tactics", "Joey Bada$$", "Hip-Hop", "2012"
		library.addSongToLib(song4); //"Telephones", "Vacations", "Indie", "2018"
		library.addSongToLib(song7); //"Julia Gloria", "Plums", "Indie", "2015"
		library.addSongToLib(song8); //"Jen", "Plums", "Indie", "2015"
		library.addSongToLib(song9); //"Lounger", "Plums", "Indie", "2015"
		library.addSongToLib(song10);//"Fine Madeline", "Plums", "Indie", "2015"
		library.addSongToLib(song11);//"Room Song", "Plums", "Indie", "2015"
		assertTrue((library.getSongs().size() == 9));
		
		ArrayList<Song> sortFour = library.getSongsBy(0);
	 	assertTrue(sortFour.get(0).getName().equals("Fine Madeline")); 
	 	assertTrue(sortFour.get(1).getName().equals("Jen")); 
		assertTrue(sortFour.get(2).getName().equals("Julia Gloria")); 
		assertTrue(sortFour.get(3).getName().equals("Lounger")); 
		assertTrue(sortFour.get(4).getName().equals("Room Song"));		
		assertTrue(sortFour.get(5).getName().equals("Survival Tactics")); 
		assertTrue(sortFour.get(6).getName().equals("Telephones")); 
		assertTrue(sortFour.get(7).getName().equals("Waltzing Back")); 
		assertTrue(sortFour.get(8).getName().equals("Yam Yam"));	
	}
	
	@Test
	void testAuthorSortOne() {
		assertTrue(library.getSongs().isEmpty());
		library.addSongToLib(song1); //"Waltzing Back", "No Vacation", "Indie", "2021"
		ArrayList<Song> sortOne = library.getSongsBy(1);
		
		assertTrue(sortOne.get(0).getAuthor().equals("No Vacation"));
	}
	
	@Test
	void testAuthorSortMany() {
		assertTrue(library.getSongs().isEmpty());
		library.addSongToLib(song1); //"Waltzing Back", "No Vacation", "Indie", "2021"
		library.addSongToLib(song2); //"Yam Yam", "No Vacation", "Indie", "2017"
		library.addSongToLib(song3); //"Survival Tactics", "Joey Bada$$", "Hip-Hop", "2012"
		library.addSongToLib(song4); //"Telephones", "Vacations", "Indie", "2018"
		assertTrue((library.getSongs().size() == 4));
		
		ArrayList<Song> sortFour = library.getSongsBy(1);
	 	assertTrue(sortFour.get(0).getAuthor().equals("Joey Bada$$")); //
		assertTrue(sortFour.get(1).getAuthor().equals("No Vacation")); //
		assertTrue(sortFour.get(2).getAuthor().equals("No Vacation")); //
		assertTrue(sortFour.get(3).getAuthor().equals("Vacations"));		
	}
	
	@Test
	void testRatingSortOne() {
		assertTrue(library.getSongs().isEmpty());
		library.addSongToLib(song1); //"Waltzing Back", "No Vacation", "Indie", "2021"
		ArrayList<Song> sortOne = library.getSongsBy(2);
		
		assertTrue(sortOne.get(0).getAuthor().equals("No Vacation"));
	}
	
	@Test
	void testRatingSortMany() {
		assertTrue(library.getSongs().isEmpty());
		library.addSongToLib(song1); //"Waltzing Back", "No Vacation", "Indie", "2021"
		library.addSongToLib(song2); //"Yam Yam", "No Vacation", "Indie", "2017"
		library.addSongToLib(song3); //"Survival Tactics", "Joey Bada$$", "Hip-Hop", "2012"
		library.addSongToLib(song4); //"Telephones", "Vacations", "Indie", "2018"
		assertTrue((library.getSongs().size() == 4));
		library.rateSongTitle("Waltzing Back", 3);
		library.rateSongTitle("Yam Yam", 0);
		library.rateSongTitle("Survival Tactics", 1);
		library.rateSongTitle("Telephones", 5);
		
		ArrayList<Song> sortFour = library.getSongsBy(2);
		assertTrue(sortFour.get(0).getName().equals("Telephones")); 
	 	assertTrue(sortFour.get(1).getName().equals("Waltzing Back")); 
		assertTrue(sortFour.get(2).getName().equals("Survival Tactics")); 
		assertTrue(sortFour.get(3).getName().equals("Yam Yam")); 		
	}
	
}
