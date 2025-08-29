
public class MultiplyStrings {
	
	
	//"123456789"
	//"987654321"
		public static void main(String args[]) {
			String result = multiply("123456789", "987654321");
			System.out.println(result);
			
			
			double num1 = 123456789;
			double num2 = 2469135780.0;
			double num3 = 37037036700.0;
			double num4 = 493827156000.0;
			double num5 = 6172839450000.0;
			double num6 = 74074073400000.0;
			double num7 = 864197523000000.0;
			double num8 = 9876543120000000.0;
			double num9 = 111111110100000000.0;
			
			double sum = num1+num2+num3+num4+num5+num6+num7+num8+num9;
			System.out.print(sum);
		}
		
		
	    public static String multiply(String num1, String num2) {
	       
	        
	        String firstNum = num1;
	        String secNum = num2;
	         
	        
	        int num1Len = firstNum.length();
	        int num2Len = secNum.length();
	        
	        if(num1Len < num2Len) {
	             firstNum = num2;
	             secNum = num1;
	        }
	        
	        
	        long result = 0;
	        long sum = 0;
	        int m = 0;
	        for(int i = num2Len-1; i >= 0; i--){
	            int a = Integer.parseInt(secNum.charAt(i)+"");
	            int k = 0;
	            long num  = 0;
	            int carry = 0;
	            for(int j = num1Len-1; j >= 0; j--) {
	                int b = Integer.parseInt(firstNum.charAt(j)+"");
	                result = (a*b)+carry;
	                if(result > 9 && j != 0) {
	                    carry = (int)(result/10);
	                    result = result%10;
	                } else {
	                	carry = 0;
	                }
	                
	                
	                num = (long)(num + result*Math.pow(10, k));
	                k++;
	            }
	            
	            System.out.println("num = "+num);
	            
	            sum = (long)(sum + (num*Math.pow(10,m)));
	            m++;
	        }
	        return new String(sum+"");
	                         
	    }
	

}
