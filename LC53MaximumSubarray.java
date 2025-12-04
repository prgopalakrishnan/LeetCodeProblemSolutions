class LC53MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int len = nums.length-1;
        int maxsum = nums[len]; int prevSum = nums[len];
        for(int i = len-1; i >= 0; i--) {
            prevSum = Math.max(nums[i], nums[i]+prevSum);
            maxsum = (maxsum < prevSum ) ? prevSum : maxsum;
        }
        return maxsum;
    }
}
