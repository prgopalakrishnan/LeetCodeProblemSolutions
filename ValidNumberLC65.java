
public class ValidNumberLC65 {
	    public boolean isNumber(String s) {
	        boolean isValid = false;
	        if(s == null || s.isEmpty()) {
	            return false;
	        }
	        
	        

	        s = s.toLowerCase();
	        
	       
	        
	        String[] tokens = s.split("e");
	        if(s.contains("e") && tokens.length != 2) {
	        	return false;
	        }
	        int firstIdx = s.indexOf('.');
	        int lastIdx = s.lastIndexOf('.');
	        if(firstIdx != lastIdx) {
	            return false;
	        }
	        if(tokens.length > 0) {
	            isValid = isInteger(tokens[0]) || isDecimal(tokens[0]);
	        }
	       
	        if(tokens.length > 1) {
	            isValid = isValid && isInteger(tokens[1]);
	        }

	        return isValid;
	        
	    }

	    boolean isInteger(String token) {
	        boolean isValidInteger = false;
	        if(token != null && token.length() > 0) {
	            
	            if(token.charAt(0) == '+' || token.charAt(0) == '-' || Character.isDigit(token.charAt(0))) {
	                isValidInteger =  true;
	            }

	            if(token.charAt(0) == '+' || token.charAt(0) == '-') {
	                if(token.length() < 2 || !Character.isDigit(token.charAt(1))) {
	                    isValidInteger = isValidInteger && false;
	                }
	            }
	            
	            int len = token.length();
	            int i =1;
	            while(i < len) {
	                isValidInteger = isValidInteger && Character.isDigit(token.charAt(i));
	                i++;
	            }
	            
	        }

	        return isValidInteger;
	    }

	    boolean isDecimal(String token) {
	        boolean isValidDecimal = false;
	        if(token!= null && token.length() > 0) {
	            String[] tokens = token.split("\\.");
	            System.out.println("tokens.length = "+tokens.length);
	            System.out.println("tokens[0]= "+tokens[0]+" tokens[1] = "+tokens[1]);
	            if(tokens.length > 0 && tokens.length <= 2) {
	                isValidDecimal = isInteger(tokens[0]) || tokens[0].isEmpty() ||
	                                    tokens[0].equals("+") || tokens[0].equals("-");
	                System.out.println("isValidDecimal "+isValidDecimal);
	            }
	            
	            if(tokens.length > 1) {
	                for(int i = 0; i < tokens[1].length(); i++) {
	                    isValidDecimal = isValidDecimal && Character.isDigit(tokens[1].charAt(i));
	                }
	            }
	        }

	        return isValidDecimal;
	    }
	    
	    public static void main(String[] args) {
	    	ValidNumberLC65 obj = new ValidNumberLC65();
	    	System.out.println(obj.isNumber("+.8"));
	    }

	

}
