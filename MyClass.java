import java.util.*;

public class MyClass {

    private Map<String, Integer> map;

    public MyClass() {
       map = new HashMap<>();
       map.put("foo", 1);
       map.put("bar", 3);
}

    public int getValue(String input, int numRetries) throws Exception {  
    	System.out.println("Inside getValue");
       try {
           return map.get(input);
       }
       catch (Exception e) {
           if (numRetries > 3) {
              throw e;
           }
           return getValue(input, numRetries + 1);
       }
   }
    
    public static void main(String args[]) throws Exception {
    	MyClass mc = new MyClass();
    	
    	System.out.println(mc.getValue("foo", 0));   
    	System.out.println(mc.getValue("bar", 2));
    	System.out.println(mc.getValue("baz", 0));
//    	System.out.println(mc.getValue("fubar", 1)); 
    }
}


