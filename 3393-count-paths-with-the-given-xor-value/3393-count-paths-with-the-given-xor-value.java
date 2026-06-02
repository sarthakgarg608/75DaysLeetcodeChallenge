class Solution {

    int MOD = (int)1e9 + 7;
    Integer[][][] dp;

    public int solve(int r, int c, int xor, int k, int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if (r == m - 1 && c == n - 1) {
            return xor == k ? 1 : 0;
        }

        if (dp[r][c][xor] != null) {
            return dp[r][c][xor];
        }

        long ans = 0;

        if (r + 1 < m) {
            ans += solve(r + 1, c,
                    xor ^ grid[r + 1][c], k, grid);
        }

        if (c + 1 < n) {
            ans += solve(r, c + 1,
                    xor ^ grid[r][c + 1], k, grid);
        }

        return dp[r][c][xor] = (int)(ans % MOD);
    }

    public int countPathsWithXorValue(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;

        // Grid values are <= 15 in this problem,
        // so XOR range is 0..15.
        dp = new Integer[m][n][16];

        return solve(0, 0, grid[0][0], k, grid);
    }
}