import java.util.*;


public class GrayCode {
	
	
		public static void main(String[] args) {
			GrayCode gc = new GrayCode();
			List<Integer> result = gc.grayCode(2);
			System.out.println(result);
			
		}
	
	    public List<Integer> grayCode(int n) {
	        
	        List<Integer> numSet = new ArrayList();
	        for(int i =1; i <= (Math.pow(2,n)-1); i++) {
	            numSet.add(i);
	        }
	        
	        List<Integer> result = new ArrayList();
	        result.add(0);
	        while(numSet.size()>0) {
	            Integer start = result.get(result.size()-1);
	            Integer returnNum = getNextNum(start, numSet, n);
	            result.add(returnNum);
	        }
	        return result;
	    }
	    
	    public int getNextNum(Integer num1, List<Integer> numSet, int len) {
	        Integer returnNum = 0;
	        for(int i =0; i < numSet.size(); i++) {
	            Integer num2 = numSet.get(i);
	            if(oneBitDiff(num1, num2, len)) {
	                numSet.remove(num2);
	                returnNum = num2;
	                break;
	            }
	        }
	        return returnNum;
	    }
	                       
	    public boolean oneBitDiff(Integer num1, Integer num2, int len) {
	        String a = Integer.toBinaryString( (1 << len) | num1 ).substring( 1 );//Integer.toBinaryString(num1);
	        String b = Integer.toBinaryString( (1 << len) | num2 ).substring( 1 );//Integer.toBinaryString(num2);
	        int i = 0;
	        int cnt = 0;
	        while(i < a.length()) {
	            if(a.charAt(i) != b.charAt(i)) {
	                cnt++;
	            }
	            if(cnt > 1) {
	                return false;
	            }
	            i++;
	        }
	        if(cnt == 1) {
	            return true;
	        }
	        return false;
	    }
	

}
