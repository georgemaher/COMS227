package hw2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class PhraseSelector {
	// creates an array to store all the lines
	private ArrayList<String> list = new ArrayList<String>();
	/**
	 * Constructor for the class that throws an exception in case of the file doesn't exist
	 * @param givenFilename is the name of the file to be opened 
	 * @throws FileNotFoundException in case that the file doesn't exist
	 */
	public PhraseSelector(String givenFilename) throws FileNotFoundException {
		File file = new File(givenFilename); // creating the new file
		Scanner scnr = new Scanner(file);// scanning the file
		while (scnr.hasNext()) {
			String line = scnr.nextLine();// grabbing each line within the file
			list.add(line.trim());// remove spaces before and after and add it to the list
		}
		scnr.close();
	}

	/**
	 * method to select a line from the text file to play with
	 * @param rand random selector for the line from the list of lines
	 * @return one string line will be the game word
	 * @throws FileNotFoundException in case the file doesn't exist
	 */
	public String selectWord(Random rand) throws FileNotFoundException {
		int num = rand.nextInt(list.size());
		
		return list.get(num);
	}
	
}
