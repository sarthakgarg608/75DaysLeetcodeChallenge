class Solution {

    Long[][][] dp;

    public long solve(int r, int c, int second, int[][] waitCost) {

        int m = waitCost.length;
        int n = waitCost[0].length;

        if (r == m - 1 && c == n - 1) {
            return 0;
        }

        if (dp[r][c][second % 2] != null) {
            return dp[r][c][second % 2];
        }

        if (second % 2 == 0) {
            return dp[r][c][0] =
                    waitCost[r][c] + solve(r, c, second + 1, waitCost);
        }

        long ans = Long.MAX_VALUE;

        if (r + 1 < m) {
            ans = Math.min(ans,
                    (long)(r + 2) * (c + 1)
                            + solve(r + 1, c, second + 1, waitCost));
        }

        if (c + 1 < n) {
            ans = Math.min(ans,
                    (long)(r + 1) * (c + 2)
                            + solve(r, c + 1, second + 1, waitCost));
        }

        return dp[r][c][1] = ans;
    }

    public long minCost(int m, int n, int[][] waitCost) {
        dp = new Long[m][n][2];

        return 1 + solve(0, 0, 1, waitCost);
    }
}