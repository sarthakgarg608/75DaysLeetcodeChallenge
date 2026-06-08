class Solution {
    Integer[][] dp ;
    public int solve(int idx , int free, int[] prices){
        if(idx == prices.length) return 0;

        if(dp[idx][free] != null) return dp[idx][free];
        if(free > 0){
            return dp[idx][free] =  Math.min(solve(idx+1,free-1,prices) , prices[idx] + solve(idx+1,idx+1,prices));
        }
        return dp[idx][free] =   prices[idx] + solve(idx+1,idx+1,prices);

    }
    public int minimumCoins(int[] prices) {
        dp = new Integer[prices.length+1][prices.length+1];
        return solve(0,0,prices);

        
    }
}