class Solution {

    Integer[][][] dp;
    int[] nums;
    int k;
    int n;

    int solve(int idx, int op1, int op2) {

        if (idx == n) return 0;

        if (dp[idx][op1][op2] != null) {
            return dp[idx][op1][op2];
        }

        int x = nums[idx];

        // No operation
        int ans = x + solve(idx + 1, op1, op2);

        // Operation 1 only
        if (op1 > 0) {
            int afterOp1 = (x + 1) / 2;   // ceil(x / 2)
            ans = Math.min(ans,
                    afterOp1 + solve(idx + 1, op1 - 1, op2));
        }

        // Operation 2 only
        if (op2 > 0 && x >= k) {
            int afterOp2 = x - k;
            ans = Math.min(ans,
                    afterOp2 + solve(idx + 1, op1, op2 - 1));
        }

        // Both operations: op1 -> op2
        if (op1 > 0 && op2 > 0) {
            int afterOp1 = (x + 1) / 2;

            if (afterOp1 >= k) {
                int val = afterOp1 - k;
                ans = Math.min(ans,
                        val + solve(idx + 1, op1 - 1, op2 - 1));
            }
        }

        // Both operations: op2 -> op1
        if (op1 > 0 && op2 > 0 && x >= k) {
            int afterOp2 = x - k;
            int val = (afterOp2 + 1) / 2;

            ans = Math.min(ans,
                    val + solve(idx + 1, op1 - 1, op2 - 1));
        }

        return dp[idx][op1][op2] = ans;
    }

    public int minArraySum(int[] nums, int k, int op1, int op2) {
        this.nums = nums;
        this.k = k;
        this.n = nums.length;

        dp = new Integer[n][op1 + 1][op2 + 1];

        return solve(0, op1, op2);
    }
}