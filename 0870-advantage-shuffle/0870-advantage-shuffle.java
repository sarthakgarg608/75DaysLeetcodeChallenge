class Solution {

    public int lb(int[][] grid, int target) {
        int low = 0, high = grid.length - 1;
        int lb = grid.length;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (grid[mid][0] < target) {
                low = mid + 1;
            } else {
                lb = mid;
                high = mid - 1;
            }
        }

        return lb;
    }

    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[][] grid = new int[n][2];
        for (int i = 0; i < n; i++) {
            grid[i][0] = nums2[i];
            grid[i][1] = i;
        }
        Arrays.sort(grid, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(nums1);
        boolean[] vis = new boolean[n];
        int[] ans = new int[n];
        int idx = n - 1;

        for (int i = n - 1; i >= 0; i--) {

            int pos = lb(grid, nums1[i]) - 1;

            while (pos >= 0 && vis[grid[pos][1]]) {
                pos--;
            }

            if (pos < 0) {
                idx = i;
                break;
            }

            int curr = grid[pos][1];
            ans[curr] = nums1[i];
            vis[curr] = true;
        }
        for (int j = 0; j < n; j++) {

            if (!vis[j]) {
                ans[j] = nums1[idx--];
            }
        }

        return ans;
    }
}