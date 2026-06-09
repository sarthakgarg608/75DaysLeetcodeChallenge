class Solution {

    private boolean canRob(int[] nums, int k, int cap) {
        int robbed = 0;

        for (int i = 0; i < nums.length; ) {

            if (nums[i] <= cap) {
                robbed++;
                i += 2; // skip adjacent house
            } else {
                i++;
            }

            if (robbed >= k) return true;
        }

        return false;
    }

    public int minCapability(int[] nums, int k) {

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for (int num : nums) {
            low = Math.min(low, num);
            high = Math.max(high, num);
        }

        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canRob(nums, k, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}