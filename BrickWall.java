
import java.util.*;

public class BrickWall {
	
	public static void main(String args[]) {
		List l1 = new ArrayList();
		l1.add(1);l1.add(1);
		
		List l2 = new ArrayList();
		l2.add(2);
		
		List l3 = new ArrayList();
		l3.add(1);l3.add(1);
		
		
		List out = new ArrayList();
		out.add(l1);
		out.add(l2);
		out.add(l3);
		
		BrickWall b = new BrickWall();
		System.out.print(b.leastBricks(out));
		
	}
	
	    public int leastBricks(List<List<Integer>> wall) {
	        List<List<Integer>> outList = new ArrayList();
	        preprocess(wall, outList);
	        
	        return cntBricks(outList);
	        
	    }
	    
	    
	    
	    
	    public int cntBricks(List<List<Integer>> outList) {
	        int n = outList.size();
	        int firstListSize = outList.get(0).size();
	        int maxValue = outList.get(0).get(firstListSize-1);
	        
	        Map<Integer, Integer> map = new HashMap();
	        
	        
	        if(outList != null && outList.size() > 0) {
	            for(int i =0; i < outList.size(); i++) {
	                List<Integer> tmpList = outList.get(i);
	                if(tmpList != null && tmpList.size() > 0) {
	                    for(int j =0; j < tmpList.size(); j++) {
	                        int cutNum = tmpList.get(j);
	                        if(!map.containsKey(cutNum)) {
	                            map.put(cutNum, 0);
	                        }
	                        map.put(cutNum, map.get(cutNum)+1);
	                    }
	                }
	            }
	        }
	        
	        //findMax 
	        
	        int max = 0;
	        for(Integer key: map.keySet()) {
	            int val = map.get(key);
	            if(max < val && key != maxValue) {
	                max = val;
	            }
	        }
	        
	        if(maxValue == 1) {
	            return n;
	        }
	        return (n - max);
	    }
	    
	    
	    
	    public void preprocess(List<List<Integer>> wall, List<List<Integer>> outList) {
	        if(wall != null && wall.size() > 0) {
	            for(int i =0; i < wall.size(); i++) {
	                List<Integer> tmpList = wall.get(i);
	                if(tmpList != null && tmpList.size() > 0) {
	                    List<Integer> newList = new ArrayList();
	                    newList.add(tmpList.get(0));
	                    for(int j =1; j < tmpList.size(); j++) {
	                        newList.add(tmpList.get(j)+newList.get(j-1));
	                    }
	                    outList.add(newList);
	                }
	            }
	        }
	    }

}
