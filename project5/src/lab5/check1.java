package lab5;
public class check1 {

	public static void main(String[] args) {
		
		
		System.out.println(initials("George Makhali"));
		System.out.println(isvowel("Gkorge"));

	}

	public static int isvowel(String s) {
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if ("aeiouAEIOU".indexOf(c) >= 0) {
				return i;
			}
		}
		return -1;
	}
	
	
public static String initials(String fullName) {
	String initial = fullName.charAt(0) + "";
	
	for (int i =0; i< fullName.length(); i++) {
	   if (fullName.charAt(i) == ' ') {
		   initial += fullName.charAt(i+1);
	   }
		
	}
	return initial;
}

}
