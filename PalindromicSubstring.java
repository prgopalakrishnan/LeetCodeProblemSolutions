
public class PalindromicSubstring {
    Integer result = 0;
	    public int countSubstrings(String s) {

	        StringBuffer slate = new StringBuffer();
	        helper(s, slate, 0);
	        return result-1;
	    }

	    public void helper(String s, StringBuffer slate, int index) {
	        if(index > s.length()) {
	            return;
	        }
	        if(slate.length() > 0 && isPalindrome(slate)) {
	            result++;
	        }

	        for(int i = index; i < s.length(); i++) {
	            slate.setLength(0);
	            slate.append(s.substring(index, i));
	            helper(s, slate, index+1);
	        }
	    }

	    boolean isPalindrome(StringBuffer s) {
	        return (s.toString().equals(s.reverse().toString()));
	    }

	
	    public static void main(String args[]) {
	    	PalindromicSubstring ps = new PalindromicSubstring();
	    	System.out.println(ps.countSubstrings("abc"));
	    }

}
