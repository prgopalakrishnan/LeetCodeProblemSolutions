
public class LC525ContiguousArray {
	int result = 0;
    int[][] matrix = null;
    public int findMaxLength(int[] nums) {
        
        matrix = new int[nums.length][nums.length];
        for(int i =0; i < nums.length; i++) {
            for(int j =0; j < nums.length; j++) {
                matrix[i][j] = -1;
            }
        }
        int numOnes = 0;
        int numZeros = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1)numOnes++;
            if(nums[i] == 0)numZeros++;
        }
        return helper(nums, 0, nums.length-1, numOnes, numZeros);
        
    }

    public int helper(int[] nums, int start, int end, int numOnes, int numZeros) {
        if(start >= end) {
            return 0;
        }
        if(numOnes > 0 && numOnes == numZeros && (end-start+1 == 2*numOnes)) {
            result = Math.max(result, end-start+1);
            return result;
        } else {
            int left = (matrix[start][end-1] == -1) ?
                    helper(nums, start, end-1, nums[end] == 1?numOnes-1:numOnes, nums[end] == 0?numZeros-1:numZeros):
                    matrix[start][end-1];
            int right = (matrix[start+1][end] == -1) ?            
                    helper(nums, start+1, end, nums[start] == 1?numOnes-1:numOnes, nums[start] == 0?numZeros-1:numZeros):
                    matrix[start+1][end];

            int curResult =  Math.max(left, right);
            result = Math.max(result, curResult);
        }
        matrix[start][end] = result;
        return result;
    }

	
	public static void main(String args[]) {
		
		LC525ContiguousArray obj = new LC525ContiguousArray();
		int[] nums = new int[] {0,1, 1};
		System.out.println(obj.findMaxLength(nums));
		
	}

}
