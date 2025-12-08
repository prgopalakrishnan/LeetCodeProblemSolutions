class LongestIncreasingSubsequence {
    
    public int lengthOfLIS(int[] nums) {
        int[] curMaxLIS = new int[nums.length];
        int maxLIS = 1; int curMax = 0;
        curMaxLIS[nums.length-1] = 1;
        for(int i = nums.length-2; i >= 0; i--) {
            curMax = 0;
            for(int j = i+1; j < nums.length; j++) {
                if(nums[j] > nums[i]) {
                    curMax = curMax < curMaxLIS[j] ? curMaxLIS[j] : curMax;
                }
            }
            curMaxLIS[i] = curMax+1;
            maxLIS = maxLIS < curMaxLIS[i] ? curMaxLIS[i] : maxLIS;
        }
        return maxLIS;
    }

       
}
