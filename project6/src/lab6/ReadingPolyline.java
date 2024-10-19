package lab6;
import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import plotter.Plotter;
import plotter.Polyline;

public class ReadingPolyline {
//	

	private static Polyline parseOneLine(String line)
	  {
		 String color = "";
		 int font = 0;
		 String spaceCheck = line;
		 ArrayList<Integer> list = new ArrayList<Integer>();
		 Scanner scnr = new Scanner(spaceCheck);

		 if (scnr.hasNextInt()) {
				font = scnr.nextInt();
			 }
			 color = scnr.next();
			 if(scnr.hasNext()){
				 	while(scnr.hasNextInt()) {
				 		list.add(scnr.nextInt());
				 	}
				 }
			 Polyline poly = new Polyline(color, font);		 
			 for(int i =0; i < list.size(); i+=2) {	 
			 poly.addPoint(new Point(list.get(i) , list.get(i+1)));
			 }
		 scnr.close();
		 return poly;
			 }

	private static ArrayList<Polyline> readFile(String filename)
		      throws FileNotFoundException
		  {
		 ArrayList<Polyline> list = new ArrayList<Polyline>();
		 File file = new File(filename);
		 Scanner scnr = new Scanner(file);
		 
		 while(scnr.hasNextLine()) {
			 String s = scnr.nextLine();
			 
			 if(s.trim().length() == 0 || s.startsWith("#")) {
				continue;
			 }
			 
			 list.add(parseOneLine(s));
			 
		 }	 
		 scnr.close();
		 return list;
		  }

	 public static void main(String[] args) throws FileNotFoundException
	  {
		    
		    ArrayList<Polyline> list = readFile("hello.txt");
		    Plotter plotter = new Plotter();

		    for (Polyline p : list)
		    {
		      plotter.plot(p);
		    }
	  }
}


