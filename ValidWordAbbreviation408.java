
public class ValidWordAbbreviation408 {
	
	    public static boolean validWordAbbreviation(String word, String abbr) {
	        int i = 0;
	        int j = 0;
	        int m = word.length();
	        int n = abbr.length();
	        boolean result = true;

	        while(i < m && j < n) {
	            if(word.charAt(i) == abbr.charAt(j)) {
	                i++; j++;
	                continue;
	            } else if(Character.isDigit(abbr.charAt(j))) {
	                StringBuffer num = new StringBuffer();
	                
	                while(j < n && Character.isDigit(abbr.charAt(j))) {
	                    num.append(abbr.charAt(j));
	                    j++;
	                }
	                if(num.charAt(num.length()-1) == '0' || num.charAt(0) == '0') {
	                    result = false;
	                    break;
	                }
	                Integer pos = Integer.parseInt(num.toString());
	                System.out.println("pos = "+pos);
	                i = i+pos;
	                continue;
	            } else {
	                result = false;
	                break;
	            } 

	        }

	        if(i != m || j != n) {
	            result = false;
	        }
	        return result;
	    }
	    
	    public static void main(String[] args) {
	    	boolean result = validWordAbbreviation("a", "01");
	    	System.out.println(result);
	    }

}
