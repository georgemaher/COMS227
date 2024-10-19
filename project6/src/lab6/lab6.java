package lab6;
import java.io.File;
import java.io.FileNotFoundException;
//import java.io.IOException;
import java.util.Scanner;
import java.io.PrintWriter;

public class lab6 {
	 public static void main(String[] args) throws FileNotFoundException
	  {
//	    File file = new File("story.txt");
//	    System.out.println(file.getAbsolutePath());
//	    Scanner scanner = new Scanner(file);
//	    int lineCount = 1;
//	    System.out.println(file.exists());          // true if the file exists
//	    System.out.println(file.getName());         // name of the file 
//	     // absolute path to the file
//	    System.out.println(file.length());          // size of the file
//	    while (scanner.hasNextLine())
//	    {
//	      String line = scanner.nextLine();
//	      System.out.print(lineCount + " ");
//	      System.out.println(line);
//	      lineCount += 1;
//	    }
//	    scanner.close();
//	    Scanner in = new Scanner(System.in);
//	    File outFile = new File("mydocument.txt");
//	    System.out.println(outFile.exists());
//	    PrintWriter out = new PrintWriter(outFile);
//
//	    // Echo keyboard input out to the file.
//	    while (in.hasNextLine())
//	    {
//	      String line = in.nextLine();
//	      out.println(line);
//	    }
//	    
//	    System.out.println("Done");
//	    out.close(); // Important: don't forget to close!
//	  }
		 File file = new File("/Users/mariammakhali/Desktop/EE /project5/src/lab5/SimpleLoops.java");
//		    System.out.println(file.getAbsolutePath());
		    Scanner scanner = new Scanner(file);
		    int lineCount = 1;
//		    System.out.println(file.exists());          // true if the file exists
//		    System.out.println(file.getName());         // name of the file 
		     // absolute path to the file
//		    System.out.println(file.length());          // size of the file
		    while (scanner.hasNextLine())
		    {
		      String line = scanner.nextLine();
		      System.out.print(lineCount + " ");
		      System.out.println(line);
		      lineCount += 1;
		    }
		    scanner.close();
	  
	  }
}
