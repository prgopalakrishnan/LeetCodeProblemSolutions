import java.util.*;

public class SpiralMatrix {
	    public List<Integer> spiralOrder(int[][] matrix) {
	        List<Integer> result = new ArrayList<Integer>();

	        int m = matrix.length;
	        int n = matrix[0].length;

	        int l = 0;
	        int r = n-1;
	        int t = 0;
	        int b = m-1;

	        while(l < r && t < b) {
	            //print top
	            for(int j = l; j < r; j++) {
	                result.add(matrix[l][j]);
	            }

	            //print right
	            for(int j = t; j < b; j++) {
	                result.add(matrix[j][r]);
	            }

	            //print bottom
	            for(int j = r; j >= l; j--) {
	                result.add(matrix[b][j]);
	            }

	            //print left
	            for(int j = b-1; j > l; j--) {
	                result.add(matrix[j][l]);
	            }

	            l = l+1; r = r-1; t = t+1; b = b-1;
	        }

	        if(l == r) {
	            for(int j = t; j <= b; j++) {
	                result.add(matrix[j][l]);
	            }
	        } else if (t == b) {
	            for(int j = l; j <= r; j++) {
	                result.add(matrix[t][j]);
	            }
	        }

	        return result;

	    }
	    
	    public static void main(String args[]) {
	    	int[][] matrix = {
	    			{1,2}, {3,4}
	    			};
	    	SpiralMatrix sm = new SpiralMatrix();
	    	List result = sm.spiralOrder(matrix);
	    	System.out.println(result);
	    }
	


}
