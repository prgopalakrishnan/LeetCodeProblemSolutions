
public class TrappingRainWater {
	
		public static void main(String[] args) {
			TrappingRainWater tr = new TrappingRainWater();
			int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
			System.out.println(tr.trap(height));
		}
	
	    public int trap(int[] height) {
	        
	        int n = height.length;
	        int i =0;
	        
	        int result = 0;
	        
	        // find the first non zero num
	        while( i < n && height[i] == 0) {
	            i++;
	        }
	        
	        int nextIdx = -1;
	        while( i < n) {
	            nextIdx = findBiggest(i, true, height, n);
	            if(nextIdx != -1) {
	                for(int j = i+1; j < nextIdx; j++) {
	                    result = result + (height[i]-height[j]);
	                }
	                 i = nextIdx;
	            } else {
	                break;
	            }
	           
	        }
	        
	        int rightIdx = n-1;
	        int prevIdx = -1;
	        while( rightIdx >= i) {
	            prevIdx = findBiggest(rightIdx, false, height, i);
	            if(prevIdx != -1) {
	                for(int j = rightIdx-1; j > prevIdx; j--) {
	                    result = result + (height[rightIdx]-height[j]);
	                }
	                rightIdx = prevIdx;
	            } else {
	                break;
	            }
	            
	        }
	        
	        return result;
	    }
	    
	    public int findBiggest(int i, boolean isRight, int[] height, int limit){
	        int n = height.length;
	        if(isRight){
	            for(int k = i+1; k < n; k++) {
	                if(height[i] < height[k]) {
	                    return k;
	                }
	            }
	        } else {
	            for(int k = i-1; k >= limit; k--) {
	                if( height[k] > height[i]) {
	                    return k;
	                }
	            }
	        }
	        
	        return -1;
	    }

}
