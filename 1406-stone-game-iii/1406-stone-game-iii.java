class Solution {
    int[] nums;
    int n;
    Integer[][] dp;
    public int solve(int idx , int turn){ 
        // if turn 1 that means Alice and 0 means bob
        if(idx == n ) return 0;
        

        if(dp[idx][turn] != null) return dp[idx][turn];
        if(turn == 1){
            int first = Integer.MIN_VALUE , second = Integer.MIN_VALUE  , third = Integer.MIN_VALUE ;
            if(idx+1 <= n) first = nums[idx] + solve(idx+1,0);
            if(idx+2 <= n) second = nums[idx] + nums[idx+1] +  solve(idx+2,0);
            if(idx+3 <= n) third  = nums[idx] + nums[idx+1] + nums[idx+2] +  solve(idx+3,0);

            return dp[idx][turn] =  Math.max(first,Math.max(second,third));
        }else {
            int first = Integer.MAX_VALUE , second = Integer.MAX_VALUE  , third = Integer.MAX_VALUE ;
            if(idx+1 <= n) first = -nums[idx] + solve(idx+1,1);
            if(idx+2 <= n) second = -(nums[idx]  + nums[idx+1])  +  solve(idx+2,1);
            if(idx+3 <= n) third  = -(nums[idx]  + nums[idx+1]  + nums[idx+2])  +  solve(idx+3,1);

            return dp[idx][turn] =  Math.min(first,Math.min(second,third));
        }
    }
    public String stoneGameIII(int[] nums) {
        this.nums = nums;
        this.n = nums.length;
        this.dp = new Integer[n][2];
        int score = solve(0,1);
        if(score > 0) return "Alice";
        else if(score < 0) return "Bob";
        else return "Tie";
    }
}