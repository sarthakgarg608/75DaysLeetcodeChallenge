class Solution {
    public long maximumProduct(int[] nums, int m) {
        int n = nums.length;
        long maxi = Long.MIN_VALUE;
        long mini = Long.MAX_VALUE;

        long ans  = Long.MIN_VALUE;

        int l = 0 , r = m-1;
        while(r < n){
            maxi = Math.max(maxi,(long)(nums[l]));
            mini = Math.min(mini,(long)(nums[l]));

            ans = Math.max(ans,Math.max((long)maxi*nums[r] , (long)mini*nums[r]));
            l++;
            r++;
        }
        return ans;
        
    }
}