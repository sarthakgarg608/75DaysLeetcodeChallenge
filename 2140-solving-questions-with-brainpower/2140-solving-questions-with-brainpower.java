class Solution {
    int[][] questions;
    int n ;
    Long[] dp;
    public long solve(int idx){
        if(idx >= n) return 0;

        if(dp[idx] != null) return dp[idx];

        long take = questions[idx][0] + solve(idx+1+questions[idx][1]);

        long notTake = solve(idx+1);

        return dp[idx] =  Math.max(take,notTake);
    }
    public long mostPoints(int[][] questions) {
        this.questions = questions;
        n = questions.length;
        dp = new Long[n];
        return solve(0);

        

        
    }
}