class Solution {
    static List<List<Integer>> ans;

    public void findPath(TreeNode root, int target,int sum, List<Integer> result) {
        if (root == null) return;
        // Add current node
        result.add(root.val);
        // Leaf node
        if (root.left == null && root.right == null) {

            if (sum + root.val == target) {

                // Make copy of list
                ans.add(new ArrayList<>(result));
            }

            // Backtrack
            result.remove(result.size() - 1);
            return;
        }

        findPath(root.left, target, sum + root.val, result);
        findPath(root.right, target, sum + root.val, result);

        // Backtrack
        result.remove(result.size() - 1);
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        ans = new ArrayList<>();
        findPath(root, targetSum, 0, new ArrayList<>());
        return ans;
    }
}