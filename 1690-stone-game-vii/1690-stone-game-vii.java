class Solution {
    int[] stones;
    Integer[][][] dp;
    public int solve(int low , int high , int hasAliceTurn){

        if(high == low) return 0;

        if(dp[low][high][hasAliceTurn] != null) return dp[low][high][hasAliceTurn];

        int leftSum = stones[high] - stones[low] ;
        int rightSum = stones[high-1];
        if(low-1 >=0) rightSum -= stones[low-1];

        if(hasAliceTurn == 1){
            int left = solve(low+1,high,0) + leftSum;
            int right = solve(low,high-1,0) + rightSum;
            return dp[low][high][hasAliceTurn] =  Math.max(left,right);
        }else{
            int left = solve(low+1,high,1) - leftSum;
            int right = solve(low,high-1,1) - rightSum;
            return dp[low][high][hasAliceTurn] =  Math.min(left,right);
        }

    }
    public int stoneGameVII(int[] stones) {
        this.stones = stones;
        int n = stones.length;
        dp = new Integer[n][n][2];
        for(int i = 1; i < stones.length; i++) stones[i] += stones[i-1];
        return solve(0,n-1,1);
        
    }
}