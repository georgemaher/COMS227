package hw1;

import java.util.Arrays;

public class Exa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "51 22 33 5";
//		char ch[] = s.toCharArray();
//		for (int i = 0 ; i < ch.length; i++) {
//			System.out.println(ch[i]);
//		}
//		
		System.out.println(findSecondLargest(s));

		
	}
public static int findSecondLargest(String nums) {
		
		int largest = -1000;
		int secondLargest = -1001;
		int current = 0;
		int x = 0;

		String p = "";
		String num = nums + " ";

		for (int i = 1; i <= num.length(); i++) {
			if (num.charAt(i - 1) == ' ') {
				p = num.substring(x, i - 1);
				current = Integer.parseInt(p);
				x = i;

				if (current > largest) {
					secondLargest = largest;
					largest = current;
				} else if (current > secondLargest)
					secondLargest = current;
			}
		}

		return secondLargest;
	}
	
}