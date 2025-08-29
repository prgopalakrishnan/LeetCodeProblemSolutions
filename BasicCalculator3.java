
public class BasicCalculator3 {
	    public int calculate(String s) {
	        return helper(s);
	    }

	    public int helper(String s) {
	        System.out.println(s);
	        if(isNumber(s)) {
	            return Integer.parseInt(s);
	        }

	        int firstIdxOf = s.indexOf(')');
	        if(firstIdxOf != -1) {
	            int i = firstIdxOf;
	            while(i >= 0 && s.charAt(i) != '(') {
	                i--;
	            }
	            StringBuffer sb = new StringBuffer();
	            int value = evaluate(s.substring(i+1, firstIdxOf));
	            if(value < 0 && i-1 >= 0 && s.charAt(i-1) == '-') {
	                value = -1*value;
	                sb.append(s.substring(0,i-1)).append("+").append(value);
	            } else {
	            	sb.append(s.substring(0,i)).append(value);
	            }
	            if(firstIdxOf+1 <= s.length()-1) {
	                sb.append(s.substring(firstIdxOf+1));
	            }

	            return helper(sb.toString());
	        }
	        return evaluate(s);
	    }

	    int evaluate(String s) {
	        if(s == null || s.isEmpty()) {
	            return 0;
	        }

	        char prevOper = '+';
	        int lastNum = 0;
	        int curNum = 0;
	        int result = 0;
	        for(int i =0; i < s.length(); i++) {
	            char c = s.charAt(i);
	            if(Character.isDigit(c)) {
	                curNum = (curNum*10)+(c-'0');
	            }

	            if((!Character.isDigit(c) && (c != ' ')) || i == s.length()-1 ) {
	                if(prevOper == '+' || prevOper == '-') {
	                    result = result+lastNum;
	                    lastNum =  (prevOper == '-') ? (-1*curNum) : curNum;
	                }

	                if(prevOper == '*') {
	                    lastNum = lastNum*curNum;
	                }

	                if(prevOper == '/') {
	                    lastNum = lastNum/curNum;
	                }

	                prevOper = c;
	                curNum = 0;
	            }
	        }
	        result = result+lastNum;
	        System.out.println(" s= "+s+" result = "+result);
	        return result;
	    }

	    boolean isNumber(String s) {
	        try {
	            Integer.parseInt(s);
	        } catch (NumberFormatException e) {
	            return false;
	        }
	        return true;
	    }
	    
	    public static void main(String args[]) {
	    	BasicCalculator3 obj = new BasicCalculator3();
	    	String s = "2*(5+5*2)\\/3+(6\\/2+8)";
	    	System.out.println(obj.calculate(s));

	    }


}
