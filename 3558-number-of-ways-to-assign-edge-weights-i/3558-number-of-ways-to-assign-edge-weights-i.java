class Solution {
    int mod;
    public int findDepth(int node,List<List<Integer>> adj,int[] vis){
        vis[node] = 1;
        if(adj.get(node).size() == 0) return 1;

        int maxi = 1;
        for(int i = 0 ; i < adj.get(node).size() ; i++){
            
            int adjNode = adj.get(node).get(i);
            if(vis[adjNode] == 1) continue;
            maxi = Math.max(maxi,1+findDepth(adjNode,adj,vis));
        }
        return maxi;
    }
    public int solve(int s , int t, int flag,int[][] dp){  //s -> s+1  havig weight 1 or 2 in one step  when s = t total sum must be odd
        if(s == t){
            if(flag == 1) return 1;
            return 0;
        }
        if(dp[s][flag] != -1) return dp[s][flag];
        return dp[s][flag] = (solve(s+1,t,0,dp) + solve(s+1,t,1,dp))%mod;
        
    }
    public int assignEdgeWeights(int[][] e) {
        mod = (int)(1e9+7);
        int n = e.length+2;
        int[] vis = new int[n];
        Arrays.fill(vis,0);
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) adj.add(new ArrayList<>());
        for(int i = 0 ; i < e.length ; i++){
            adj.get(e[i][0]).add(e[i][1]);
            adj.get(e[i][1]).add(e[i][0]);
        };
        int depth = findDepth(1,adj,vis);
        int[][] dp = new int[depth+1][3];
        for(int[] arr : dp) Arrays.fill(arr,-1);

        int ans1 = solve(1,depth,2,dp);
        return (ans1)%(mod);


    }
}