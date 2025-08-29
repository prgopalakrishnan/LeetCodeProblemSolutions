
public class LCBasicCalculator227 {
	    public int calculate(String s) {
	       return helper(s);
	    }

	    int helper(String s) {
	        int index = 0; 
	        int op1 = 0;
	        int op2 = 0;
	        int result = 0;
	        StringBuffer sb = null;
	        int[] metadata = null;

	        index = s.indexOf('/');
	        if(index != -1) {
	            metadata = getMetadata(s, index);
	            op1 = metadata[0];
	            op2 = metadata[1];
	            result = op1/op2;
	            sb = new StringBuffer();
	            if(metadata[2] != -1) {
	                sb.append(s.substring(0, metadata[2]+1));
	            }
	            sb.append(result);
	            if(metadata[3] != -1) {
	                sb.append(s.substring(metadata[3]));
	            }
	            return helper(sb.toString());
	        }

	        index = s.indexOf('*');
	        if(index != -1) {
	            metadata = getMetadata(s, index);
	            op1 = metadata[0];
	            op2 = metadata[1];
	            result = op1*op2;
	            sb = new StringBuffer();
	            if(metadata[2] != -1) {
	                sb.append(s.substring(0, metadata[2]+1));
	            }
	            sb.append(result);
	            if(metadata[3] != -1) {
	                sb.append(s.substring(metadata[3]));
	            }
	            return helper(sb.toString());
	        }

	        index = s.indexOf('+');
	        if(index != -1) {
	            metadata = getMetadata(s, index);
	            op1 = metadata[0];
	            op2 = metadata[1];
	            result = op1+op2;
	            sb = new StringBuffer();
	            if(metadata[2] != -1) {
	                sb.append(s.substring(0, metadata[2]+1));
	            }
	            sb.append(result);
	            if(metadata[3] != -1) {
	                sb.append(s.substring(metadata[3]));
	            }
	            return helper(sb.toString());
	        }

	        index = s.indexOf('-');
	        if(index != -1) {
	            metadata = getMetadata(s, index);
	            op1 = metadata[0];
	            op2 = metadata[1];
	            result = op1-op2;
	            sb = new StringBuffer();
	            if(metadata[2] != -1) {
	                sb.append(s.substring(0, metadata[2]+1));
	            }
	            sb.append(result);
	            if(metadata[3] != -1) {
	                sb.append(s.substring(metadata[3]));
	            }
	            return helper(sb.toString());
	        }
	        return Integer.parseInt(s);

	    }

	    int[] getMetadata(String s, int index) {
	        int[] metadata = new int[4];
	        int leftOp = -1;
	        int rightOp = -1;
	        int leftIdx = -1;
	        int rightIdx = -1;

	        leftIdx = index-1;
	        while(leftIdx >= 0 && (s.charAt(leftIdx) != '/' && s.charAt(leftIdx) != '*'
	        		&& s.charAt(leftIdx) != '+' && s.charAt(leftIdx) != '-')) {
	        	leftIdx--;
	        }

	        rightIdx = index+1;
	        while(rightIdx < s.length() && (s.charAt(rightIdx) != '/' && s.charAt(rightIdx) != '*'
	        		&& s.charAt(rightIdx) != '+' && s.charAt(rightIdx) != '-')) {
	            rightIdx++;
	        }

	        String leftOpStr = s.substring(leftIdx+1, index);
	        String rightOpStr = s.substring(index+1, rightIdx);

	        if(leftOpStr != null && !leftOpStr.isEmpty()) {
	            leftOp = Integer.parseInt(leftOpStr.trim());
	        }
	        if(rightOpStr != null && !rightOpStr.isEmpty()) {
	            rightOp = Integer.parseInt(rightOpStr.trim());
	        }

	        metadata[0] = leftOp;
	        metadata[1] = rightOp;
	        metadata[2] = leftIdx<0? -1:leftIdx;
	        metadata[3] = rightIdx>=s.length()? -1:rightIdx;
	        return metadata;

	    }
	    
	    public static void main(String args[]) {
	    	LCBasicCalculator227 ob = new LCBasicCalculator227();
	    	System.out.println(ob.calculate("0-2147483647"));
	    }


	

}
