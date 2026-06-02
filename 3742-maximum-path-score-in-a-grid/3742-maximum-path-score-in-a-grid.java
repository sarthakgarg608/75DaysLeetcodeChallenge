class Solution {

    public int solve(int r, int c, int cost, int k, int[][] grid, Integer[][][] dp) {
        int m = grid.length;
        int n = grid[0].length;
        int score = grid[r][c];
        if (grid[r][c] != 0) {
            cost++;
        }

        if (cost > k) {
            return Integer.MIN_VALUE;
        }

        if (r == m - 1 && c == n - 1) {
            return (cost <= k) ? score : Integer.MIN_VALUE;
        }

        if (dp[r][c][cost] != null) {
            return dp[r][c][cost];
        }

        long ans = Integer.MIN_VALUE;

        if (c + 1 < n) {
            int right = solve(r, c + 1, cost, k, grid, dp);

            if (right != Integer.MIN_VALUE) {
                ans = Math.max(ans, (long) score + right);
            }
        }

        if (r + 1 < m) {
            int down = solve(r + 1, c, cost, k, grid, dp);

            if (down != Integer.MIN_VALUE) {
                ans = Math.max(ans, (long) score + down);
            }
        }

        dp[r][c][cost] = (ans == Integer.MIN_VALUE) ? Integer.MIN_VALUE : (int) ans;

        return dp[r][c][cost];
    }

    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        Integer[][][] dp = new Integer[m][n][k + 1];

        int ans = solve(0, 0, 0, k, grid, dp);

        return ans == Integer.MIN_VALUE ? -1 : ans;
    }
}