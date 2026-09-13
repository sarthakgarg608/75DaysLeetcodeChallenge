class Solution {
    int ans = 0;
    public int countGoodNodes(int[][] edges) {
        int n = edges.length + 1;

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build undirected tree
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // Root the tree at 0
        dfs(0, -1, adj);

        return ans;
    }

    public int dfs(int node, int parent, List<List<Integer>> adj) {
        
        // node itself
        int subtreeSize = 1;

        // at first no child
        int firstChildSize = -1;
        boolean good = true;

        for (int next : adj.get(node)) {

            // Don't go back to parent
            if (next == parent) {
                continue;
            }

            int childSize = dfs(next, node, adj);

            // Compare all child subtree sizes
            if (firstChildSize == -1) {
                firstChildSize = childSize;
            } 
            else if (firstChildSize != childSize) {
                good = false;
            }

            subtreeSize += childSize;
        }

        if (good) {
            ans++;
        }

        return subtreeSize;
    }
}