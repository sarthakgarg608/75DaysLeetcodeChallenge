class Solution {
    int[] nums;
    int n;
    Integer[] dp;
    public int solve(int idx){ 
        // if turn 1 that means Alice and 0 means bob
        if(idx == n ) return 0;
        if(dp[idx] != null) return dp[idx];
        int first = Integer.MIN_VALUE , second = Integer.MIN_VALUE , third = Integer.MIN_VALUE;

        if(idx+1 <= n) first = (nums[idx] - solve(idx+1));
        if(idx+2 <= n) second = (nums[idx]+ nums[idx+1] - solve(idx+2));
        if(idx+3 <= n) third = (nums[idx]+nums[idx+1]+nums[idx+2] - solve(idx+3));
        return dp[idx] =  Math.max(first,Math.max(second,third));
        
    }
    public String stoneGameIII(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        this.dp = new Integer[n];
        int score = solve(0);
        if(score > 0) return "Alice";
        else if(score < 0) return "Bob";
        else return "Tie";
    }
}