import java.util.*;


public class MinNonOverlappingInterval {
	public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)->Integer.compare(a[0], b[0]));
        List<int[]> slate = new ArrayList();
        Integer min = intervals.length+1;
        for(int i = 0; i < intervals.length; i++) {
            slate.add(intervals[i]);
            helper(intervals, slate, i+1, min);
            slate.remove(slate.size()-1);
        }
        return min;
    }

    public void helper(int[][] intervals, List<int[]> slate, int index, Integer min) {
        if(index >= intervals.length) {
        	System.out.println();
        	System.out.print(" min = "+min);
        	int newmin = intervals.length-slate.size();
            min = Math.min(min, newmin);
            System.out.print(" min = "+min+" newmin = "+newmin);
            return;
        }

        for(int i = index; i < intervals.length; i++) {
            int[] lastAdded = slate.get(slate.size()-1);
            if(lastAdded[1] <= intervals[i][0]) {
                slate.add(intervals[i]);
                helper(intervals, slate, i+1, min);
                slate.remove(slate.size()-1);
            }
        }
    }
	    public static void main(String args[]) {
	    	MinNonOverlappingInterval min = new MinNonOverlappingInterval();
	    	int[][] intervals = {{1,2},{2,4},{1,4}};
	    	System.out.println(min.eraseOverlapIntervals(intervals));
	    }

}
