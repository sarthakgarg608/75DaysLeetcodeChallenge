class Solution {

    HashMap<TreeNode, int[]> dp = new HashMap<>();

    public int dfs(TreeNode root, boolean hasTaken){

        if(root == null) return 0;

        // dp[node][0] -> when parent not taken
        // dp[node][1] -> when parent taken

        if(dp.containsKey(root) && dp.get(root)[hasTaken ? 1 : 0] != -1){
            return dp.get(root)[hasTaken ? 1 : 0];
        }

        dp.putIfAbsent(root, new int[]{-1, -1});

        int ans;

        if(hasTaken == false){

            int take = root.val
                    + dfs(root.left, true)
                    + dfs(root.right, true);

            int notTake =
                    dfs(root.left, false)
                    + dfs(root.right, false);

            ans = Math.max(take, notTake);
        }
        else{

            ans =
                    dfs(root.left, false)
                    + dfs(root.right, false);
        }

        dp.get(root)[hasTaken ? 1 : 0] = ans;

        return ans;
    }

    public int rob(TreeNode root) {

        return dfs(root, false);
    }
}