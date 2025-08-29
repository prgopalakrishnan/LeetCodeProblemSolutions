
public class LC215KthLargestElementInArray {
	
	    public int findKthLargest(int[] nums, int k) {
	        if(nums == null || nums.length == 0) {
	            return -1;
	        }
	        int n = nums.length-1;
	        int partitionIdx = 0;
	        int low = 0;
	        int high = nums.length-1;
	        partitionIdx = partition(low, high, nums);
	        while(true) {
	            partitionIdx = partition(low, high, nums);
	            System.out.println("partitionIdx = "+partitionIdx);
	            int numElemsRight = n-partitionIdx+1;
	            if(numElemsRight == k){
	                return nums[partitionIdx];
	            } else if (numElemsRight < k) {
	                high = partitionIdx-1;
	            } else {
	                low = partitionIdx+1;
	            }
	             
	        }
	    }

	    public int partition(int low, int high, int[] nums) {
	        int key = nums[low];
	        int i = low+1;
	        int j = high;
	        while(i <= high && j > low) {
	            while(i <= high && nums[i] <= key) {
	                i++;
	            }
	            while(j > low && nums[j] > key) {
	                j--;
	            }
	            if(i < j) {
	                int tmp = nums[i];
	                nums[i] = nums[j];
	                nums[j] = tmp;
	            } else {
	                int tmp = nums[low];
	                nums[low] = nums[j];
	                nums[j] = tmp;
	                return j;
	            }

	        }
	        return j;
	        
	   }
	    
	    public static void main(String args[]) {
	    	LC215KthLargestElementInArray obj = new LC215KthLargestElementInArray();
	    	int[] nums = new int[] {2,1};
	    	int k = 1;
	    	int elem = obj.findKthLargest(nums, k);
	    	System.out.println(elem);
	    }

}
