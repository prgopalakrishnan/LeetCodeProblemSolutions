import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFreq {
	
	    public int[] topKFrequent(int[] nums, int k) {
	        
	        if(nums == null || nums.length == 0) {
	            return null;
	        }

	        PriorityQueue<int[]> q = new PriorityQueue<int[]>(new CompareByFreq());
	        Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();

	        for(int i: nums) {
	            countMap.put(i, countMap.getOrDefault(i, 0)+1);
	        }
	        
	        
	        for(Integer i: countMap.keySet()) {
	            q.add(new int[]{i, countMap.get(i)});
	            if(q.size() > k){
	                q.poll();
	            } 
	        }
	        

	        int[] result = new int[k];
	        int ind = 0;
	        while(q.size() > 0) {
	            result[ind++] = q.poll()[0];
	        }
	        return result;
	    }
	    
	    
	    public static void main(String args[]) {
	    	TopKFreq topObj = new TopKFreq();
	    	int[] nums = {1,1,1,2,2,3}; int k = 2;
	    	int[] result = topObj.topKFrequent(nums, k);
	    	for(int i = 0; i < result.length; i++) {
	    		System.out.println(result[i]);
	    	}
	    	
	    }
	}

	class CompareByFreq implements Comparator<int[]> {
	    public int compare(int[] a, int[] b) {
	        return Integer.compare(a[1], b[1]);
	    }
	}


