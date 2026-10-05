class Solution {
    int[] nums;
    long[][] dp;
    public long solve(int idx , int prevSign){
        if(idx ==  nums.length) return 0;

        if(dp[idx][prevSign] != -1) return dp[idx][prevSign];
        // if sign is 1 that means element will be added 
        if(prevSign == 1){
            long take = nums[idx] + solve(idx+1,0);
            long notTake = solve(idx+1,1);
            return dp[idx][prevSign] = Math.max(take,notTake);
        
        }
        // if sign is 0 then element will be subtracted
        else {
            long take = -nums[idx] + solve(idx+1,1);
            long notTake = solve(idx+1,0);
            return dp[idx][prevSign] = Math.max(take,notTake);
        }
    }
    public long maxAlternatingSum(int[] nums) {
        this.nums = nums;
        int n = nums.length;
        this.dp = new long[n][2];
        for(long[] arr : dp) Arrays.fill(arr,-1);
        return solve(0,1);
    }
}