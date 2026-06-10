class Solution {
    String s;
    int n;
    Long[][][] dp;
    public long solve(int idx , int count , int prev){

        if(count == 3) return 1;
        if(idx == n) return 0;

        if(dp[idx][count][prev] != null) return dp[idx][count][prev];

        int curr = s.charAt(idx)-'0';
        if(curr == prev){
            return dp[idx][count][prev] = solve(idx+1,count,prev);
        }else return dp[idx][count][prev] = solve(idx+1,count+1,curr) + solve(idx+1,count,prev);
    }
    public long numberOfWays(String s) {
        this.s = s;
        n = s.length();
        dp = new Long[n][4][3];
        return solve(0,0,2);


        
    }
}