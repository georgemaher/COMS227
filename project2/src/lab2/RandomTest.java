package lab2;
import java.util.Random;
public class RandomTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		k(4);
	}
	public static int k(int x) {
		if(x <= 0) {
			System.out.println("m");
			return 2;
		}
		else {
			int tmp = x-1;
			int result = k(tmp) +tmp;
			System.out.println(result);
			return result;
		}
	}

}
