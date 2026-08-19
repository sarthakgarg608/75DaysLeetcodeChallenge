class Solution {
    public int minDifference(int[] nums) {
        int len = nums.length;
        if(len <= 4) return 0;

        Arrays.sort(nums);
        int ans = nums[len-1] - nums[3];
        ans = Math.min(ans,nums[len-2]-nums[2]);
        ans = Math.min(ans,nums[len-3]-nums[1]);
        ans = Math.min(ans,nums[len-4] - nums[0]);
        return ans;
    }
}