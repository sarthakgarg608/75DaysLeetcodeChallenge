class Solution {
    public int solve(int idx, int ct , int k , int[] xorArr,Integer[][] dp){
        int n = xorArr.length;
        int minXor = Integer.MAX_VALUE;
        if(idx == xorArr.length) return 0;

        

        // not possible to choose like that 
        if(ct == k && idx != xorArr.length) return Integer.MAX_VALUE;

        if(dp[idx][ct] != null) return dp[idx][ct];
        for(int i = idx ; i <= n-(k-ct); i++){
            if(idx == 0){
                int max = Math.max(xorArr[i],solve(i+1,ct+1,k,xorArr,dp));
                minXor = Math.min(minXor,max);
            }else {
                int max = Math.max(xorArr[i] ^ xorArr[idx-1],solve(i+1,ct+1,k,xorArr,dp));
                minXor = Math.min(minXor,max);
            }
        }
        return dp[idx][ct] =  minXor;
    }
    public int minXor(int[] nums, int k) {
        int[] xorArr = new int[nums.length];
        xorArr[0] = nums[0];
        for(int i = 1 ; i < nums.length; i++){
            xorArr[i] = xorArr[i-1] ^ nums[i];
        }
        Integer[][] dp = new Integer[nums.length][k+1];

        int n = nums.length;
        return solve(0,0,k,xorArr,dp);
    }
}