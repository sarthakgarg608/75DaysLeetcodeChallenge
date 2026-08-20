class Solution {
    int[] nums;
    int mod = (int)(1e9+7);
    Integer[][][] dp ;
    public int solve(int idx , int ct , int parity){

        if(idx == nums.length && ct == 0) return 0;
        if(idx == nums.length && ct != 0) return 1;

        if(dp[idx][ct][parity] != null) return dp[idx][ct][parity];
        
        int ans = 0;
        int curr = (nums[idx] % 2);
        if(curr == parity){
            if(ct == 2) ans = (ans + solve(idx+1,ct,parity)) % mod;
            else ans = (ans + solve(idx+1,ct+1,parity) + solve(idx+1,ct,parity)) % mod;
        }else {
            ans = (ans + solve(idx+1,1,curr) + solve(idx+1,ct,parity)) % mod;
        }

        return dp[idx][ct][parity] =  ans;

    }
    public int countStableSubsequences(int[] nums) {
        this.nums = nums;
        this.dp = new Integer[nums.length][3][2];

        if(nums[0] % 2 == 0) return solve(0,0,1);
        else return solve(0,0,0);

    }
}