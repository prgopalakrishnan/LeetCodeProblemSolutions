
public class MagicIndex {
	
	
	
	public static void main(String args[]) {
		int[] a1 = {-1,1,32,34,40,65,70};
		int indx = find(a1);
		
		System.out.println("indx = "+indx);
		
		int[] a2 = {-100,-90,-80,-40,-10,5,60,70};
		 indx = find(a2);
		System.out.println("indx = "+indx);
		
		int[] a3 = {0,1,1,1,1,1};
		 indx = find(a3);
		System.out.println("indx = "+indx);
		
	}
	
	public static int find(int[] a) {
		return helper(a, 0, a.length-1);
	}
	
	public static int helper(int[] a, int low, int high) {
		if(low < high) {
			int mid = (low+high)/2;
			if(a[mid] == mid) {
				return mid;
			} 
			
			if(a[mid] <= high) {
				return helper(a, mid+1, high);
			} 
			
			if(a[mid] >= low) {
				return helper(a, low, mid-1);
			}
		}
		return -1;
	}

}
