package mini1;

import java.util.Arrays;

//import java.util.Scanner;

/**
 * Utility class with some static methods involving loops.
 */
public class WackyLoops {

	/**
	 * Determines how many iterations of the following operation are required until
	 * the condition (a * a + b * b) &gt; 4 is reached:
	 * 
	 * <pre>
	 *   newA = a * a - b * b + startLoc
	 *   newB = 2 * a * b + y
	 *   a = newA
	 *   b = newB
	 * </pre>
	 * 
	 * where a and b are initially zero. If the condition (a * a + b * b) &gt; 4 is
	 * not reached within <code>maxIterations</code>, the method returns
	 * <code>maxIterations</code>.
	 * 
	 * @param startLoc             given startLoc value
	 * @param y             given y value
	 * @param maxIterations maximum number of iterations to attempt
	 * @return number of iterations required to get (a * a + b * b) &gt; 4, or
	 *         maxIterations
	 */
	public static int findEscapeCount(double x, double y, int maxIterations) {
		double a = 0 ;
		double b = 0;
		int i = 0;
		for (i = 0; i < maxIterations ; i++) {
			double newA = a * a  - b * b + x; // updates x & y until condition is met
			double newB = 2 * a * b + y;
			a = newA;
			b = newB;
			if ((a*a + b*b) > 4.0) { // if condition is met, return iterations
				return i+1;
			}
			
		}
		
		
		return maxIterations; // else return maxIterations
	}

	/**
	 * Counts the number of positions in a pair of strings that have matching
	 * characters. The strings need not be the same length. For example,
	 * countMatches("abcde", "xbydzzzzz") returns 2.
	 * 
	 * @param s any string
	 * @param t any string
	 * @return number of positions in which the characters match in the two strings
	 */
	public static int countMatches(String s, String t) {
		int length = Math.min(s.length(), t.length()); // pick the min length
		int i = 0;
		int count = 0;
		for (i = 0; i < length ; i++) {
			if(s.charAt(i) == t.charAt(i)) { // if matched, increase count
				count +=1;
			}
		}
		
		return count;
	}

	/**
	 * Determines whether the two given strings are permutations (rearrangements) of
	 * each other. The method is case sensitive. For example,
	 * <ul>
	 * <li>isPermutation("abcabc", "baaccb") returns true
	 * <li>isPermutation("abc", "cbba") returns false
	 * <li>isPermutation("Abc", "abc") returns false
	 * </ul>
	 * 
	 * @param s given string
	 * @param t given string
	 * @return true if the given strings are permutations of each other, false
	 *         otherwise
	 */
public static boolean isPermutation(String s, String t) {
		
		
		if (s.length() != t.length()) { // if not the same length, false
			return false ; 
		}
		else {
			char ch1[] = s.toCharArray();// convert both strings to char array
			char ch2[] = t.toCharArray();
			Arrays.sort(ch1);// sort those arrays
			Arrays.sort(ch2);
			for(int i = 0 ; i< s.length() ; i++) {
				if (ch1[i] != ch2[i]) { // compare them
					return false;
				}
				
			}
			return true;
		}
	}

	/**
	 * Returns a new string in which all consonants in the given string are doubled.
	 * Consonants that are already doubled are not doubled again. For example,
	 * doubleConsonants("rabbit") returns "rrabbitt". It is assumed that in the
	 * given string is alphabetic and that no character appears more than twice in a
	 * row.
	 * 
	 * @param s given string
	 * @return new string with all consonants doubled
	 */
	public static String doubleConsonants(String s) {
		String str = "";
		char prevChar = ' ';
		for (int i = 0; i < s.length() ; i++) {
			if ( isVowel(s.charAt(i) )){// if vowel, add it without repeating
				str += s.charAt(i);
			}
			else if (prevChar == s.charAt(i)) {// if already repeated, skip
			}
			else {// otherwise repeat it and add it to the output string
				str += s.charAt(i) ;
				str += s.charAt(i);
			}
			prevChar = s.charAt(i);// update what the prevChar is
		}
		return str;
	}

		
	

	private static boolean isVowel(char ch) {
		return "aeiouAEIOU".indexOf(ch) >= 0;
	}

	/**
	 * Returns the secondLargest largest number in a string of integers. For example, given
	 * the string "42 137 -7 42 66 55" the method returns 66. Note that the secondLargest
	 * largest value may be the same as the largest, e.g., for the string "5 5 5 3"
	 * the method returns 5. If the given string is invalid or contains fewer than
	 * two numbers, the behavior of this method is undefined.
	 * 
	 * @param nums string of text containing integers separated by one or more
	 *             spaces
	 * @return secondLargest largest number in the given string
	 */
	public static int findSecondLargest(String nums) {

		String buffer = "";
		String subString = nums + " ";
		int largest = -1000;// this and the next lines setting values to compare to
		int secondLargest = -1001;
		int parsed = 0;
		int startLoc = 0;
		
		for (int i = 1; i <= subString.length(); i++) {
			
			if (subString.charAt(i - 1) == ' ') { // detecting spaces within the string
				buffer = subString.substring(startLoc, i - 1);// buffer will be from startLoc to space
				parsed = Integer.parseInt(buffer);// convert it to integer
				startLoc = i;// updating start loc after the space
				
				if (parsed > largest) { // checking the desired conditions
					secondLargest = largest;
					largest = parsed;
				} else if (parsed > secondLargest)
					secondLargest = parsed;
			}
		}
		return secondLargest;
	}
	

	/**
	 * Determines whether the string <code>target</code> occurs as a substring of
	 * string <code>source</code> where "gaps" are allowed between characters of
	 * <code>target</code>. That is, the characters in <code>target</code> occur in
	 * <code>source</code> in their given order but do not have to be adjacent.
	 * (Pictured another way, this method returns true if <code>target</code> could
	 * be obtained from <code>source</code> by removing some of the letters of
	 * <code>source</code>.) This method is case sensitive. For example,
	 * <ul>
	 * <li>containsWithGaps("hamburgers", "mug") returns true
	 * <li>containsWithGaps("hamburgers", "burrs") returns true
	 * <li>containsWithGaps("hamburgers", "hamburgers") returns true
	 * <li>containsWithGaps("hamburgers", "gum") returns false
	 * <li>containsWithGaps("hamburgers", "hamm") returns false
	 * <li>containsWithGaps("hamburgers", "") returns true
	 * </ul>
	 * 
	 * @param source the given string in which to find the target characters
	 * @param target the characters to be found
	 * @return true if the characters in <code>target</code> can be found as a
	 *         subsequence in <code>source</code>, false otherwise
	 */
	public static boolean substringWithGaps(String source, String target) {
			
			boolean substringWithGaps = true; //setting the output to true
			// checking for otherwise
			for (int i = 0; i < target.length(); i++) {
				char ch = target.charAt(i);// checking each char of target
				int ind = source.indexOf(ch);// index of this char

				if (source.equals(target)) {
					substringWithGaps = true;
				} else if (ind >= 0 && ind != source.length()) {
					source = source.substring(ind + 1);// creating substring after each match
				}
				else {
					substringWithGaps = false;
				}
			}

			return substringWithGaps;
		}


}
