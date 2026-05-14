class Solution {

    public int countPath(TreeNode root, long currSum, int target) {

        if (root == null) return 0;

        currSum += root.val;

        int ans = 0;

        if (currSum == target) ans++;

        ans += countPath(root.left, currSum, target);
        ans += countPath(root.right, currSum, target);

        return ans;
    }

    public int pathSum(TreeNode root, int targetSum) {

        if (root == null) return 0;

        int ans = 0;

        // Paths starting from current node
        ans += countPath(root, 0, targetSum);

        // Paths starting from left subtree
        ans += pathSum(root.left, targetSum);

        // Paths starting from right subtree
        ans += pathSum(root.right, targetSum);

        return ans;
    }
}