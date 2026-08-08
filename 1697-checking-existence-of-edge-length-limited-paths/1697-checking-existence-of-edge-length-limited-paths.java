class DSU {
    int[] rank , size , parent;
    DSU(int n){
        rank = new int[n+1];
        size = new int[n+1];
        parent = new int[n+1];
        for(int i =0;i<=n;i++){
            size[i] =1;
            parent[i] = i;
        }  
    }
    public int findUPar(int node){
        if(node == parent[node]) return node;
        return parent[node] = findUPar(parent[node]);
    }
    public void unionByRank(int u , int v){
        int pu = findUPar(u);
        int pv = findUPar(v);
        if(pu == pv) return ;
        if(rank[pu] < rank[pv]){
            parent[pu] = pv;
        }else if(rank[pv] < rank[pu]){
            parent[pv] = pu;
        }else{
            parent[pv] = pu;
            rank[pu]++;
            
        }
    }
    public void unionBySize(int u, int v) {
        int pu = findUPar(u);
        int pv = findUPar(v);
        if (pu == pv) return;
        if (size[pu] < size[pv]) {
            parent[pu] = pv;
            size[pv] += size[pu];
        } else {
            parent[pv] = pu;
            size[pu] += size[pv];
        }
    }
}

class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        Arrays.sort(edgeList,(a,b) -> Integer.compare(a[2],b[2]));
        int[][] grid = new int[queries.length][4];
        for(int i = 0 ; i< queries.length ; i++){
            grid[i][0] = queries[i][0];
            grid[i][1] = queries[i][1];
            grid[i][2] = queries[i][2];
            grid[i][3] = i;
        }
        Arrays.sort(grid,(a,b) -> Integer.compare(a[2],b[2]));
        DSU ds = new DSU(n);
        boolean[] ans = new boolean[queries.length];
        int j = 0;
        for(int i = 0;i<grid.length;i++ ){
            int p = grid[i][0] , q = grid[i][1] , limit = grid[i][2] , idx = grid[i][3];
            while(j<edgeList.length && edgeList[j][2] < limit){
                ds.unionByRank(edgeList[j][0],edgeList[j][1]);
                j++;
            }
            if(ds.findUPar(p) == ds.findUPar(q)){
                ans[idx] = true;
            }else ans[idx] = false;


        }
        return ans;


    }
}