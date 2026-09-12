class Solution {
    public long dfs(int node , List<List<Integer>> adj , int[] baseTime){
        // leaf node
        if(adj.get(node).size() == 0) return baseTime[node];

        long mini = Long.MAX_VALUE , maxi = Long.MIN_VALUE;
        for(int i = 0 ; i < adj.get(node).size() ; i++){
            int adjNode = adj.get(node).get(i);
            long next = dfs(adjNode,adj,baseTime);
            mini = Math.min(next,mini);
            maxi = Math.max(maxi,next);            
        }
        long own = (maxi-mini) + baseTime[node];
        return own + maxi;
    }
    public long finishTime(int n, int[][] edges, int[] baseTime) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) adj.add(new ArrayList<>());
        for(int i = 0 ; i < edges.length ; i++) adj.get(edges[i][0]).add(edges[i][1]);

        return dfs(0,adj,baseTime);

    }
}