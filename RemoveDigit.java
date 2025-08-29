import java.util.*;


public class RemoveDigit {
	
	
	
		public static void main(String[] args) {
			RemoveDigit ob = new RemoveDigit();
			String result = ob.removeKdigits("10200", 1);
			System.out.println(result);
		}
	
	    public String removeKdigits(String num, int k) {
	        Map<Integer, List<Integer>> map = new TreeMap<Integer, List<Integer>>();
	        preProcess(map, num);
	        int totalLen = num.length()-k;
	        StringBuffer res = new StringBuffer();
	        
	        int curIdx = 0;
	        int prevIdx = -1;
	        for(int i =0; i < totalLen; i++) {
	            curIdx = getNextNum(map, totalLen-i-1, prevIdx, num.length());
	            prevIdx = curIdx;
	            if(curIdx != -1) {
	                Integer curNum = Integer.parseInt(num.charAt(curIdx)+"");
	                res.append(curNum);
	            }
	        }
	        
	        return res.toString();
	    }
	    
	    
	    public void preProcess(Map<Integer, List<Integer>> map, String num) {
	        if(num != null && num.length() > 0) {
	            int l = num.length();
	            for(int i = 0; i < num.length(); i++) {
	                Integer n = Integer.parseInt(num.charAt(i)+"");
	                if(!map.containsKey(n)) {
	                    List<Integer> list = new ArrayList<Integer>();
	                    map.put(n, list);
	                }
	                
	                List tmpList = map.get(n);
	                tmpList.add(l-i-1);
	                map.put(n, tmpList);
	            }
	        }
	    }
	    
	    public int getNextNum(Map<Integer, List<Integer>> map, int lenNeeded, int prevIdx, int k) {
	        int result = -1;
	        
	        if(map != null && map.size() > 0) {
	            for(Integer key: map.keySet()) {
	                List<Integer> list = map.get(key);
	                for(int i =0; i < list.size(); i++) {
	                    int item = list.get(i);
	                    int curIdx = k-item-1;
	                    if(item >= lenNeeded && curIdx > prevIdx) {
	                        list.remove(i);
	                        return curIdx;
	                    }
	                }
	            }
	        }
	        return result;
	    }

}
