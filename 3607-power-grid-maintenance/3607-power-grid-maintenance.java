class Solution {
    List<List<Integer>> adj;
    HashMap<Integer,TreeSet<Integer>> map;
    int[] vis;

    public void dfs(int node, int id) {
    vis[node] = 1;
    map.get(id).add(node);

    for (int next : adj.get(node)) {
        if (vis[next] == 0) {
            dfs(next, id);
        }
    }
}

    public int[] processQueries(int c, int[][] connections, int[][] queries) {

        this.map = new HashMap<>();
        this.adj = new ArrayList<>();

        for(int i = 0 ; i <= c ; i++) adj.add(new ArrayList<>());
        for(int i = 0 ; i < connections.length; i++)
        {
            int u = connections[i][0];
            int v = connections[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        this.vis = new int[c+1];
        int id = 0;
        for(int i = 1 ; i <= c ; i++){
            if(vis[i] == 0){
                map.put(id,new TreeSet<>());
                
                dfs(i,id);
                
                id += 1;
            }
        }

        int[] arr = new int[c+1];
        for (Map.Entry<Integer, TreeSet<Integer>> entry : map.entrySet()) {
            int key = entry.getKey();
            TreeSet<Integer> set = entry.getValue();
            for (int x : set) {
                arr[x] = key;
            }
        }

        boolean[] flag = new boolean[c+1];
        Arrays.fill(flag,false);

        List<Integer> ans = new ArrayList<>();
        for(int i = 0 ;i<queries.length; i++){
            int type = queries[i][0];
            int x = queries[i][1];
            if(type == 2) {
                flag[x] = true;
                map.get(arr[x]).remove(x);
            }else{
                if(flag[x] == false) ans.add(x);
                else{
                    int size = map.get(arr[x]).size();
                    if(size == 0) ans.add(-1);
                    else ans.add(map.get(arr[x]).first());
                }
            }
        }

        int[] result = new int[ans.size()];
        for(int i = 0 ; i< ans.size();i++) result[i] = ans.get(i);
        return result;
    }
}