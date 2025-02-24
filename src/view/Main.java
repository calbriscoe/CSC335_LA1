package view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import model.LibraryModel;
import model.MusicStore;


public class Main {
	public static void main(String[] args) {
		MusicStore store = new MusicStore();
		LibraryModel user = new LibraryModel();
		
		// Format/Style based on Java W3 School Java API
		// Also does not work 
		try {
		      File album = new File("19_Adele.txt");
		      Scanner myScanner = new Scanner(album);
		      String albumData = myScanner.nextLine();
		      while (myScanner.hasNextLine()) {
		        String songData = myScanner.nextLine();
		        System.out.println(songData);
		      }
		      myScanner.close();
		 } catch (FileNotFoundException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
		
	}
}