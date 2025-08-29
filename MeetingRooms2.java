import java.util.*;

public class MeetingRooms2 {
	/**
	 * Definition of Interval:
	 */
	  public class Interval {
	      public int start, end;
	      public Interval(int start, int end) {
	          this.start = start;
	          this.end = end;
	      }
	  }
	 

	    public int minMeetingRooms(List<Interval> intervals) {
	        if(intervals.size() == 0) {
	            return 0;
	        }
	        Collections.sort(intervals, (a,b)->Integer.compare(a.start, b.start));

	        List<Interval> tempList = new ArrayList();
	        tempList.addAll(intervals);

	        int minDays = 0;
	        
	        while(tempList.size() > 0) {
	            minDays++;
	            int n = tempList.size()-1;
	            Interval prev = tempList.get(n);
	            tempList.remove(n);

	            if(tempList.size() > 0) {
	            for(int i = n-1; i >= 0; i--) {
	                Interval cur = tempList.get(i);
	                if(cur.end <= prev.start) {
	                    prev = cur;
	                    tempList.remove(i);
	                    
	                } 
	            }
	            }
	        }

	        return minDays;


	    }
	    
	    
	    public static void main(String args[]) {
	    	MeetingRooms2 mr = new MeetingRooms2();
	    	List<Interval> intervals = new ArrayList();
	    	Interval i1 = mr.new Interval(0, 40);
	    	Interval i2 = mr.new Interval(5, 10);
	    	Interval i3 = mr.new Interval(15, 20);
	    	
	    	intervals.add(i1);
	    	intervals.add(i2);
	    	intervals.add(i3);
	    	
	    	System.out.println(mr.minMeetingRooms(intervals));
	    }
	


}
