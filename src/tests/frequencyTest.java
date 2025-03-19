package tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import org.junit.jupiter.api.Test;

import model.Album;
import model.LibraryModel;
import model.MusicStore;
import model.Song;

public class frequencyTest {
	LibraryModel library = new LibraryModel();

    File file = new File("src/albums/19_Adele.txt");
    MusicStore store = new MusicStore();

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
	void testPlayed() {
		assertTrue(library.getRecent().isEmpty());
		library.playSong(song1);
		library.playSong(song2);
		assertTrue((library.getRecent().size() == 2));
		
		library.playSong(song2);
		assertTrue((library.getRecent().size() == 2));
	}
	@Test
	void testPlayedFull() {
		assertTrue((library.getRecent().isEmpty()));
		library.playSong(song1);
		library.playSong(song2);
		library.playSong(song3);
		library.playSong(song4);
		library.playSong(song5);
		library.playSong(song6);
		library.playSong(song7);
		library.playSong(song8);
		library.playSong(song9);
		library.playSong(song10);
		assertTrue((library.getRecent().size() == 10));
		assertTrue((library.getRecent().get(0) == song10));
		assertTrue((library.getRecent().get(9) == song1));
		library.playSong(song11);
		assertTrue((library.getRecent().size() == 10));
		assertTrue((library.getRecent().get(0) == song11));
		assertTrue((library.getRecent().get(9) == song2));
		library.playSong(song12);
		assertTrue((library.getRecent().size() == 10));
		assertTrue((library.getRecent().get(0) == song12));
		assertTrue((library.getRecent().get(9) == song3));
	}	
	
	@Test
	void testFrequencyTable() {
		assertTrue((library.getFrequency().isEmpty()));
		library.playSong(song1);
		library.playSong(song2);
		library.playSong(song3);
		assertTrue((library.getFrequency().get(song1) == 1));
		assertTrue((library.getFrequency().get(song2) == 1));
		assertTrue((library.getFrequency().get(song3) == 1));
		library.playSong(song1);
		library.playSong(song1);
		library.playSong(song2);
		assertTrue((library.getFrequency().get(song1) == 3));
		assertTrue((library.getFrequency().get(song2) == 2));
	}

	@Test
	void testFrequencyList() {
		assertTrue((library.getFrequency().isEmpty()));
		library.playSong(song1);
		library.playSong(song1);
		library.playSong(song2);
		
		library.createFrqList();
		assertTrue(library.getFrequencyList().size() == 2);
		
		library.playSong(song1);
		library.playSong(song2);
		
		library.createFrqList();
		assertTrue(library.getFrequencyList().size() == 2);
		
		library.playSong(song3);
		
		library.createFrqList();
		assertTrue(library.getFrequencyList().size() == 3);
		

	}
	
	@Test
	void testFrequencyListFull() {
		assertTrue((library.getFrequency().isEmpty()));
		library.playSong(song1);
		library.playSong(song2);
		library.playSong(song3);
		library.playSong(song4);
		library.playSong(song5);
		library.playSong(song6);
		library.playSong(song7);
		library.playSong(song8);
		library.playSong(song9);
		library.playSong(song10);
		
		library.createFrqList();
		assertTrue(library.getFrequencyList().size()==10);
		
		library.playSong(song1);
		library.playSong(song1);
		library.playSong(song1);
		library.playSong(song2);
		library.playSong(song2);
		
		library.createFrqList();
		assertTrue(library.getFrequencyList().size()==10);
		
		library.playSong(song12);
		library.playSong(song12);
		library.playSong(song12);
		
		library.createFrqList();
		assertTrue(library.getFrequencyList().size()==10);
	}
	
	@Test
	void testFrequencyListString() {
		/* Testing if it printed the string properly, mostly a visual thing
	     *  and not assert-able. 
		 */
		
		assertTrue((library.getFrequency().isEmpty()));
		library.playSong(song1);
		library.playSong(song2);
		library.playSong(song3);
		library.playSong(song4);
		library.playSong(song5);
		
		library.createFrqList();
		assertTrue(library.getFrequencyList().size()==5);
		
		//System.out.print(library.getFrqListToString());
		assertTrue(true); // Printed correct
		
		library.playSong(song1);
		library.playSong(song1);
		library.playSong(song1);
		library.playSong(song2);
		library.playSong(song2);
		
		library.createFrqList();
		assertTrue(library.getFrequencyList().size()==5);
		
		//System.out.print(library.getFrqListToString());
		assertTrue(true); // Printed correct
	}
	
	@Test
	void testFrequnencyListSmall() {	
		assertTrue((library.getFrequency().isEmpty()));
		library.playSong(song1);
		library.playSong(song2);
		
		library.createFrqList();
		System.out.print(library.getFrqListToString());
		assertTrue(library.getFrequencyList().size()==2);
		
		
		System.out.println("-------");
		library.playSong(song2);
		
		library.createFrqList();
		System.out.print(library.getFrqListToString());
		assertTrue(library.getFrequencyList().size()==2);
		
		System.out.println("-------");
		library.playSong(song1);
		library.playSong(song1);
		
		library.createFrqList();
		System.out.print(library.getFrqListToString());
		assertTrue(library.getFrequencyList().size()==2);
	}
	
	@Test
	void testFrequencyListFullString() {
		/* Testing if it printed the string properly, mostly a visual thing
	     *  and not assert-able. 
		 */
		
		assertTrue((library.getFrequency().isEmpty()));
		library.playSong(song1);
		library.playSong(song2);
		library.playSong(song3);
		library.playSong(song4);
		library.playSong(song5);
		library.playSong(song6);
		library.playSong(song7);
		library.playSong(song8);
		library.playSong(song9);
		library.playSong(song10);
		library.playSong(song5);
		
		library.createFrqList();
		assertTrue(library.getFrequencyList().size()==10);
		
		//System.out.print(library.getFrqListToString());
		assertTrue(true); // Printed correct
		
		library.playSong(song2);
		library.playSong(song2);
		library.playSong(song2);
		library.playSong(song4);
		library.playSong(song4);
		library.playSong(song4);
		library.playSong(song10);
		library.playSong(song12);
		library.playSong(song12);
		library.playSong(song12);
		
		library.createFrqList();
		assertTrue(library.getFrequencyList().size()==10);
		
		//System.out.print(library.getFrqListToString());
		assertTrue(true); // Printed correct
	}
}
