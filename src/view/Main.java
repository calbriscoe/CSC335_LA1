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
		
		// Path of the specific directory for me
		// Wouldn't work on gitHub so not sure what to
		//    replace it with. Also gitHub still bugging
	    String directoryPath = "C:/Users/sonny/Documents/albums";
	    File directory = new File(directoryPath);
	    File[] files = directory.listFiles();
	      
	    // Print name of the all files present in that path
	    System.out.println("Print: ");
	    if (files != null) {
	    	for (File file : files) {
	          store.addAlbum(file);
	        }
	    }
	    
	    
	    // Small testing
	    System.out.print(store.albumInfo("Begin Again"));
	    System.out.print(store.songInfo("Norah Jones"));
		
	}
}