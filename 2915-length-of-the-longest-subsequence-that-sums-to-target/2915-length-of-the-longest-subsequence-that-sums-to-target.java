class Solution {
    Integer[][] dp ;
    public int solve(int idx , int sum ,int target , List<Integer> nums){

        

        // No more elements needed because all the elements are positive 
        if(sum == target) return 0;

        if(sum > target) return Integer.MIN_VALUE;

        if(idx == nums.size() && sum < target) return Integer.MIN_VALUE;

        if(idx == nums.size()) return 0;

        if(dp[idx][sum] != null) return dp[idx][sum];
        

        
        int ele = nums.get(idx);
        return dp[idx][sum] =  Math.max(1+solve(idx+1,sum+ele,target,nums),solve(idx+1,sum,target,nums));
        

    }
    public int lengthOfLongestSubsequence(List<Integer> nums, int target) {
        dp = new Integer[nums.size()][target+1];
        int ans = solve(0,0,target,nums);
        if(ans <=0) return -1;
        return ans;


        
    }
}