package lab6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Parsing {
	 private static void printOneAverage(String line, int pointsPossible)
	  {   
	    // construct a temporary scanner, just to read data from this line
	    Scanner temp = new Scanner(line);
	    
	    // get the first and last name
	    String first = temp.next();
	    String last = temp.next();
	    
	    // add up all the scores
	    double total = 0.0;
	    while (temp.hasNextInt())
	    {
	      int value = temp.nextInt();
	      total += value;
	    }
	    temp.close();
	    // print the average
	    double average = total / pointsPossible;
	    System.out.println(first + " " + last + " " + average);
	  }
	 
	 
	 private static void printAllAverages(String filename, int pointsPossible) 
		      throws FileNotFoundException
		  {
		    // open the file
		    File file = new File(filename);    
		    Scanner scanner = new Scanner(file);
		    
		    // while there are more lines...
		    while (scanner.hasNextLine())
		    {
		      // get the next line
		      String line = scanner.nextLine();
		      
		      // process the line
		      printOneAverage(line, pointsPossible);
		    }
		    
		    // close the file
		    scanner.close();

		  }
	 
	   public static void main(String[] args) throws FileNotFoundException
	   {
	     // read from a file called "scores.txt", assume total possible points is 50
	     printAllAverages("scores.txt", 50);
	   }
	 

}
