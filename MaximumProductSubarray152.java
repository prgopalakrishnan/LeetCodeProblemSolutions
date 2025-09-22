class MaximumProductSubarray152 {
    public int maxProduct(int[] nums) {

        if(nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length-1;
        int maxPdt = nums[len];
        int lastMaxPdt = nums[len];
        int lastMinPdt = nums[len];
        int curMaxPdt = 1;
        int curMinPdt = 1;

        maxPdt = nums[len];


        for(int i = len-1; i >= 0; i--) {
            curMaxPdt = getMax(nums[i], nums[i]*lastMaxPdt, nums[i]*lastMinPdt);
            curMinPdt = getMin(nums[i], nums[i]*lastMaxPdt, nums[i]*lastMinPdt);
            maxPdt = getMax(maxPdt, curMaxPdt, curMinPdt);
            lastMaxPdt = curMaxPdt;
            lastMinPdt = curMinPdt;
        }



        return maxPdt;
    } 

    int getMax(int a, int b, int c) {
        int res = Math.max(a,b);
        res = Math.max(res, c);
        return res;
    }

    int getMin(int a, int b, int c) {
        int res = Math.min(a,b);
        res = Math.min(res, c);
        return res;
    }
}
