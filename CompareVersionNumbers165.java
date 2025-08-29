
public class CompareVersionNumbers165 {
	    public int compareVersion(String version1, String version2) {
	        
	        int result = 0;
	        int i = 0;
	        int j = 0;
	        StringBuilder sbVersion1 = new StringBuilder();
	        StringBuilder sbVersion2 = new StringBuilder();
	        while(i < version1.length() || j < version2.length()) {
	        	sbVersion1.setLength(0);
	        	sbVersion2.setLength(0);
	        	while(i < version1.length() && version1.charAt(i) != '.') {
	        		if(version1.charAt(i) != 0) {
	        			sbVersion1.append(version1.charAt(i));
	        		}
	        		i++;
	        		
	        	}
	        	int num1 = sbVersion1.toString().length() > 0 ? Integer.parseInt(sbVersion1.toString()):0;
	        	
	        	while(j < version2.length() && version2.charAt(j) != '.') {
	        		if(version2.charAt(j) != 0) {
	        			sbVersion2.append(version2.charAt(j));
	        		}
	        		j++;
	        		
	        	}
	        	int num2 = sbVersion2.toString().length() > 0 ? Integer.parseInt(sbVersion2.toString()):0;
	        	
	        	
	        	
	        	if(num1 > num2) {
	        		return 1;
	        	} else if( num1 < num2 ) {
	        		return -1;
	        	}
	        	i++;j++;
	        }
	        
	        return result;
	    }



	    
	    public static void main(String[] args) {
	    	CompareVersionNumbers165 obj = new CompareVersionNumbers165();
	    	System.out.println(obj.compareVersion("1.01", "1.001"));
	    	System.out.println(obj.compareVersion("1.0", "1.0.0"));
	    	System.out.println(obj.compareVersion("0.1", "1.1"));
	    	System.out.println(obj.compareVersion("1.0.1", "1"));
	    }

}
