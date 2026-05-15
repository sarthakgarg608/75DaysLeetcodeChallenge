class Pair {
        TreeNode node;
        long idx;

        Pair(TreeNode node, long idx) {
            this.node = node;
            this.idx = idx;
        }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0L));

        int maxWidth = 0;

        while (!q.isEmpty()) {

            int currLevelSize = q.size();

            long stIdx = q.peek().idx;
            long endIdx = q.peek().idx;

            for (int i = 0; i < currLevelSize; i++) {

                Pair curr = q.poll();

                TreeNode node = curr.node;
                long idx = curr.idx;

                endIdx = idx;

                if (node.left != null) {
                    q.offer(new Pair(node.left, idx * 2 + 1));
                }

                if (node.right != null) {
                    q.offer(new Pair(node.right, idx * 2 + 2));
                }
            }

            maxWidth = Math.max(maxWidth, (int)(endIdx - stIdx + 1));
        }

        return maxWidth;
    }

    
}