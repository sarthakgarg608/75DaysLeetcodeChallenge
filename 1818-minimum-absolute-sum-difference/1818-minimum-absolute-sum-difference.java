class Solution {

    // Returns the index of the first element >= target
    public int findClosestElement(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        int ans = nums.length-1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] >= target) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }

        return ans;
    }

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int MOD = 1_000_000_007;

        long diffSum = 0;
        int[] diff = new int[n];

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            diffSum += diff[i];
        }

        int[] sorted = nums1.clone();
        Arrays.sort(sorted);

        long ans = diffSum;

        for (int i = 0; i < n; i++) {
            int idx = findClosestElement(sorted, nums2[i]);

            // Check lower bound
            if (idx < n) {
                long newSum = diffSum - diff[i] + Math.abs(sorted[idx] - nums2[i]);
                ans = Math.min(ans, newSum);
            }

            // Check previous element
            if (idx > 0) {
                long newSum = diffSum - diff[i] + Math.abs(sorted[idx - 1] - nums2[i]);
                ans = Math.min(ans, newSum);
            }
        }

        return (int) (ans % MOD);
    }
}