
import java.util.*;

/**
 * Given an array, for each element find the value of the nearest element to the right which is having a frequency greater than as that of the current element. If there does not exist an answer for a position, then make the value ‘-1’.

Examples: 

Input : a[] = [1, 1, 2, 3, 4, 2, 1] 
Output : [-1, -1, 1, 2, 2, 1, -1]
Explanation:
Given array a[] = [1, 1, 2, 3, 4, 2, 1] 
Frequency of each element is: 3, 3, 2, 1, 1, 2, 3
Lets calls Next Greater Frequency element as NGF
1. For element a[0] = 1 which has a frequency = 3,
   As it has frequency of 3 and no other next element 
   has frequency more than 3 so  '-1'
2. For element a[1] = 1 it will be -1 same logic 
   like a[0]
3. For element a[2] = 2 which has frequency = 2,
   NGF element is 1 at position = 6  with frequency 
   of 3 > 2
4. For element a[3] = 3 which has frequency = 1,
   NGF element is 2 at position = 5 with frequency 
   of 2 > 1
5. For element a[4] = 4 which has frequency = 1,
   NGF element is 2 at position = 5 with frequency 
   of 2 > 1
6. For element a[5] = 2 which has frequency = 2,
   NGF element is 1 at position = 6 with frequency
   of 3 > 2
7. For element a[6] = 1 there is no element to its 
   right, hence -1 

Input : a[] = [1, 1, 1, 2, 2, 2, 2, 11, 3, 3]
Output : [2, 2, 2, -1, -1, -1, -1, 3, -1, -1]
Naive approach: 
 * @author priyagopalakrishnan
 *
 */
public class NextGreaterFrequencyElement {
	
	public static void main(String args[]) {
		//int[] a = {1, 1, 2, 3, 4, 2, 1};
		int[] a = {1, 1, 1, 2, 2, 2, 2, 11, 3, 3};
		
		int[] out = nextGreaterElement(a);
		
		for(int i = 0; i < out.length; i++) {
			System.out.print(out[i]+" ");
		}
	}
	
	public static int[] nextGreaterElement(int a[]) {
		int out[] = new int[a.length];
		
		// Get the frequency of each element
		Map<Integer, Integer> cntMap = new HashMap<Integer, Integer>();
		
		for(int i = 0; i < a.length; i++) {
			cntMap.putIfAbsent(a[i], 0);
			cntMap.put(a[i], cntMap.get(a[i])+1);
		}
		
		
		// Find for each element next freq Elem val
		for(int i = 0; i <= a.length-1; i++) {
			 int curElem = a[i];
			 int curMin = 0;
			 int minSoFar = Integer.MAX_VALUE;
			 int nextElem = -1;
			 for(int j = i+1; j < a.length; j++) {
				 curMin = Math.abs(a[j] - curElem);
				 if(curMin <= minSoFar && cntMap.get(curElem) < cntMap.get(a[j])) {
					 minSoFar = curMin;
					 nextElem = a[j];
				 }
			 }
			 out[i] = nextElem;
		}
		out[a.length-1] = -1;
		
		
		return out;
	}

}
