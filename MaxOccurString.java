
import java.util.*;

public class MaxOccurString {
	
	    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
	        
	        int result = 0;
	        if(s == null || s.length() == 0) {
	            return result;
	        }

	        Map<String, Integer> map = new HashMap<String, Integer>();

	        for(int i = minSize; i <= maxSize; i++) {
	            for(int j = 0; (j+i) <= s.length(); j++) {
	                String subStr = s.substring(j, j+i);
	                if(unique(subStr, maxLetters)) {
	                    map.put(subStr, map.getOrDefault(subStr, 0)+1);
	                }
	            }
	        }

	        List<Map.Entry<String, Integer>> list = new ArrayList(map.entrySet());
	        Collections.sort(list, new ValueComparator());

	        return list.size() > 0 ? list.get(0).getValue() : 0;
	    }

	    public boolean unique(String substr, int maxLetter) {
	        Set<Character> set = new HashSet<Character>();
	        for(int i = 0; i < substr.length(); i++) {
	            set.add(substr.charAt(i));
	        }
	        boolean result =  set.size() == maxLetter ?  true : false;
	        return result;
	    }
	    
	    public static void main(String args[]) {
	    	String s = "abcde";
	    	MaxOccurString obj = new MaxOccurString();
	    	System.out.println(obj.maxFreq(s, 2, 3, 4));
	    }


	}

	class ValueComparator implements Comparator<Map.Entry<String, Integer>> {
	    public int compare(Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) {
	        return Integer.compare(e2.getValue(), e1.getValue());
	    }
	}


