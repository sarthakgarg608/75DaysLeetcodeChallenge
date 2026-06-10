class Solution {
    int[] nums;
    int k;
    int n;
    Long[] dp;

    public long solve(int idx){
        if(idx >= (n-2)) return 0;

        if(dp[idx] != null) return dp[idx];

        long case1 = nums[idx] >= k ? solve(idx+1) : (k-nums[idx]) + solve(idx+1);
        long case2 = nums[idx+1] >= k ? solve(idx+2) : (k-nums[idx+1]) + solve(idx+2);
        long case3 = nums[idx+2] >= k ? solve(idx+3) : (k-nums[idx+2]) + solve(idx+3);

        return dp[idx] = Math.min(case1,Math.min(case2,case3));
        
    }
    public long minIncrementOperations(int[] nums, int k) {
        this.nums = nums;
        this.k = k;
        n = nums.length;
        dp = new Long[n];
        return solve(0);


        
    }
}