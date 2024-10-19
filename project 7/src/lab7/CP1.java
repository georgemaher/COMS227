package lab7;

public class CP1 {

	public static void main(String[] args) {

//		int[] test = {3, 4, 5, 1, 2, 3, 2}; // sum should be 20
//	    int result = arrayMax(test);
//	    System.out.println(result);
		System.out.println(getPyramidCount(3));
		
	}
	public static int arrayMax(int[] arr)
	  {
	    return arrayMaxRec(arr, 0, arr.length - 1);
	  }
	public static int arrayMaxRec(int[] arr ,int start, int end) {
		if(start == end) {
			return arr[start];
		}
		else {
			int mid = (start + end)/2;
		int	leftArrayMax = arrayMaxRec(arr , start , mid);
		int rightArrayMax = arrayMaxRec(arr , mid+1 , end);	
		return Math.max(leftArrayMax, rightArrayMax);
		}
		
		
	}
	public static int getPyramidCount(int nLevels) {
		int count;
		if(nLevels ==1 ) {
			count = 1;
			return count;
		}
		else {
			count = (nLevels * nLevels) + getPyramidCount(nLevels -1);
			return count;
		}
	}

}
