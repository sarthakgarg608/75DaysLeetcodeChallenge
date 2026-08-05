class Solution {
    class Triplets{
        int stop;
        int bus;
        int total;

        Triplets(int stop , int bus , int total){
            this.stop = stop;
            this.bus = bus;
            this.total = total;
        }
    }
    public int numBusesToDestination(int[][] routes, int source, int target) {
        
        if(source == target) return 0;
        int n = routes.length;
        int mx = 0 ;
        for(int i = 0 ; i < n ; i++){
            int len = routes[i].length;
            for(int j = 0 ; j < len ; j++){
                mx = Math.max(mx,routes[i][j]);
            }

        }

        if(mx < target) return -1;
        if(mx < source) return -1;

        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i <= mx ; i++) adj.add(new ArrayList<>());

        for(int i = 0 ; i < n ; i++){
            int len = routes[i].length;
            for(int j = 0 ; j < len ; j++){
                int node = routes[i][j];
                adj.get(node).add(i);
            }

        }

        boolean[] vis = new boolean[mx+1];

        Queue<Triplets> que = new LinkedList<>();
        int len = adj.get(source).size();

        for(int i = 0; i < len; i++){
            que.add(new Triplets(source,adj.get(source).get(i),0));
        }

        vis[source] = true;

        while(!que.isEmpty()){
            Triplets top = que.remove();
            int stop = top.stop;
            int bus = top.bus;
            int total = top.total;

            if(stop == target) return total;

            int Len = routes[bus].length;
            for(int i = 0 ; i < Len ; i++){
                if(vis[routes[bus][i]] == false){
                    vis[routes[bus][i]] = true;
                    int size = adj.get(routes[bus][i]).size();
                    for(int j = 0 ; j < size ; j++){
                        int busStop = adj.get(routes[bus][i]).get(j);
                        que.add(new Triplets(routes[bus][i],busStop,total+1));
                    }
                }
            }
        }

        return -1;


        

    }
}