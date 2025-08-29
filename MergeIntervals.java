

import java.util.*;

public class MergeIntervals {
	public int[][] merge(int[][] intervals) {
		List<int[]> result = new ArrayList();
		int n = intervals.length;
		mergesort(intervals, 0, n-1);
		for(int i = 0; i < intervals.length; i++) {
			System.out.println(intervals[i][0]+ " "+ intervals[i][1]);
		}

		int i =1;
		int[] last = intervals[0];
		while(i < n) {
			if(intervals[i][0] <= last[1]) {
				last[1] = Math.max(intervals[i][1], last[1]);
				i++;
			} else {
				result.add(last);
				last = intervals[i];
				i++;
			}

		}
		result.add(last);
		return result.toArray(new int[result.size()][]);

	}

	public void mergesort(int[][] intervals, int low, int high) {
		if(low >= high) {
			return;
		}
		int mid = (low+high)/2;
		mergesort(intervals, low, mid);
		mergesort(intervals, mid+1, high);
		merge(intervals, low, mid, high);
	}

	public void merge(int[][] intervals, int low, int mid, int high) {
		int i = low;
		int j = mid+1;
		int k =0;
		int n = high-low+1;
		int[][] temp = new int[n][2];
		while(i <= mid && j <= high) {
			if (intervals[i][0] < intervals[j][0]) {
				temp[k][0] = intervals[i][0];
				temp[k][1] = intervals[i][1];
				i++; k++;
			} else {
				temp[k][0] = intervals[j][0];
				temp[k][1] = intervals[j][1];
				j++;
				k++;
			}
		}
		while(i <= mid) {
			temp[k][0] = intervals[i][0];
			temp[k][1] = intervals[i][1];
			i++; k++;
		}
		while(j <= high ) {
			temp[k][0] = intervals[j][0];
			temp[k][1] = intervals[j][1];
			j++;
			k++;
		}

		for(int a =0; a < n; a++) {
			intervals[low+a][0] = temp[a][0];
			intervals[low+a][1] = temp[a][1];
		}

	}



public static void main(String[] args) {
	//int[][] arr = { {1,2},{2,3}};
	int[][] arr = {{1,3},{2,6},{8,10},{15,18}};
	MergeIntervals mi = new MergeIntervals();
	int[][] r = mi.merge(arr);
	System.out.println("==============");
	for(int i = 0; i < r.length; i++) {
		System.out.println(r[i][0]+ " "+ r[i][1]);
	}

}

}
