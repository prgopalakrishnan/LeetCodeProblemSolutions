
public class JumpGame2 {
	
	
	public static void main(String args[]) {
		
		JumpGame2 jp = new JumpGame2();
		int[] nums = new int[]{5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5};
		System.out.print(jp.jump(nums));
	}
	 
    int min = Integer.MAX_VALUE;
    public int jump(int[] nums) {
        
        if(nums.length == 1) {
            return 0;
        }
        helper(nums, 0, nums.length-1, 0);
        return min;
    }
    
    
    public void helper(int[] nums, int curIdx, int targetIdx, int cnt) {
        if(curIdx >= nums.length) {
            return;
        }
        
        if(targetIdx-curIdx <= nums[curIdx]) {
            if(min > cnt+1) {
                min = cnt+1; 
            }
            return;
        }
        int endIdx = nums[curIdx];
        if(nums[curIdx] > targetIdx) {
            endIdx = targetIdx;
        }
        for(int i = 1; i <= endIdx; i++) {
            helper(nums, curIdx+i, targetIdx, cnt+1);
        }
    }

}
