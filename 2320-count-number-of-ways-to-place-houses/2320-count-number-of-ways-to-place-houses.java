class Solution {
    int n;
    Integer[] dp;
    int mod;
    public int solve(int p1){
        if(p1 >= n) return 1;
        if(dp[p1] != null) return dp[p1];
        int pick = solve(p1+2);
        int notPick = solve(p1+1);
        return dp[p1] = (pick+notPick)%mod;
    }
    public int countHousePlacements(int n) {
        this.n = n;
        mod = (int)(1e9+7);
        dp = new Integer[n+1];
        int way = solve(0)%mod;
        return (int)(((long)way * way) % mod);

        
    }
}