import java.util.*;

public class LC423ReconstructDigitsfromStr {
    
    public String output = "";
    
    public static void main(String args[]) {
    	LC423ReconstructDigitsfromStr sol = new LC423ReconstructDigitsfromStr();
        //System.out.println(sol.getDigit("two"));
        //System.out.println(sol.isPresent("four", "owoztneoer"));
        StringBuffer buf = new StringBuffer("owoztneoer");
        // sol.deleteDigitStr("zero", buf);
        // System.out.println(buf.toString());
        // sol.appendDigitStr("zero", buf);
        // System.out.println(buf.toString());
        String s = "zeroonetwothreefourfivesixseveneightnine";
        System.out.println(sol.originalDigits(s));
    }
    
    
    public String originalDigits(String s) {
        List<String> list = new ArrayList<String>();
        list.add("zero");
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        list.add("five");
        list.add("six");
        list.add("seven");
        list.add("eight");
        list.add("nine");
        
        StringBuffer out = new StringBuffer();
        StringBuffer input = new StringBuffer(s);
        
        helper(input, list,out, 0);   
        return out.toString();
        
    }
    
    
    public void helper(StringBuffer input, List<String> list, StringBuffer out, int idx) {
        
    	System.out.println(input.toString()+" "+out.toString());
    	if(input.toString().equals("wugtnsifiv")) {
    		System.out.println("");
    	}

        if(input.toString().isEmpty() || !output.isEmpty()) {
            output = out.toString();
            return;
        }
        
            
            
            
            
            for(int i = idx; i < list.size(); i++) {
                String digitStr = list.get(i);
                if(digitStr.equals("seven")) {
                	System.out.println("");
                }
                List<Integer> indices = isPresent(digitStr, input.toString());
                if( indices != null) {
                    out.append(getDigit(digitStr));
                    deleteDigitStr(digitStr, input, indices);
                
                    helper(input, list, out, idx);
                    if(!output.isEmpty()) {
                        break;
                    }
                    appendDigitStr(digitStr, input, indices);
                    out.deleteCharAt(out.length()-1);
                }
            
            }
            
        
    }
    
    public void deleteDigitStr(String digitStr, StringBuffer input, List<Integer> indices) {
        for(int i = 0;i < indices.size(); i++) {
                input.deleteCharAt(indices.get(i));
        }
    }
    
    public void appendDigitStr(String digitStr, StringBuffer input, List<Integer> indices) {
    	for(int i =0; i < digitStr.length(); i++) {
    		input.insert(indices.get(i), digitStr.charAt(i)+"");
    	}
    }
        
        
    
    
    public List<Integer> isPresent(String digitStr, String input) {
    	List<Integer> indices = new ArrayList();
        for(int i =0;i < digitStr.length(); i++) {
        	int index = input.indexOf(digitStr.charAt(i));
        	
            if(index < 0) {
               return null;
            } else {
            	indices.add(index);
            }
        }
        return indices;
    }
    
    public String getDigit(String s) {
        if(s.equals("zero")) {
            return "0";
        } else if(s.equals("one")) {
            return "1";
        }else if(s.equals("two")) {
            return "2";
        }else if(s.equals("three")) {
            return "3";
        }else if(s.equals("four")) {
            return "4";
        }else if(s.equals("five")) {
            return "5";
        }else if(s.equals("six")) {
            return "6";
        }else if(s.equals("seven")) {
            return "7";
        }else if(s.equals("eight")) {
            return "8";
        }else {
            return "9";
        }
    }
}