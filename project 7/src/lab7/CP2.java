package lab7;

import java.io.File;
import java.util.ArrayList;

public class CP2 {

	public static void main(String[] args) {
//		File rootDirectory = new File(".");
//	countFiles(rootDirectory);
	    System.out.println(countPatterns(6));
	}
	public static int countFiles(File f) {
		int count = 0 ;
		if (!f.isDirectory())
	    {
	      return  1 ; 
	    }else
	    {
	    	for (File f2 : f.listFiles())
	        {
	        	String mes = f2.getName();
	        	count ++;
	          countFiles(f2);
	        }
	        System.out.println("name of folder is "+ f.getName()+" and has " + count+ " files");
	          return count;
	      }	
	}
	 public static int countPatterns(int n){ 
		if (n > 0 && n < 3) {
			return 1;
		}
		else if (n == 3 ) {
			return 2;
		}
		else if(n <= 0 ) {
			
			return 0;
		}
		else {
			
			return countPatterns(n-3) + countPatterns(n-1);
		}
	 }
}
