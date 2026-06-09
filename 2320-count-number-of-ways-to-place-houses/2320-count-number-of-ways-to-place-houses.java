class Solution {
    int n;
    Integer[][] dp;
    int mod;
    public int solve(int p1 , int prevP1){
        int ans = 0;
        if(p1 == n) return 1;

        if(dp[p1][prevP1] != null) return dp[p1][prevP1];
        
        if(prevP1 == 0) {
            ans += (solve(p1+1,1)%mod+ solve(p1+1,0)%mod) % mod;
        }else ans += solve(p1+1,0)%mod;

        return dp[p1][prevP1] = ans%mod;
    }
    public int countHousePlacements(int n) {
        this.n = n;
        mod = (int)(1e9+7);
        dp = new Integer[n+1][2];
        int way = solve(0,0)%mod;
        return (int)(((long)way * way) % mod);

        
    }
}