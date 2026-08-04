class Solution {
    class Triplets{
        int val , r , c;
        Triplets(int val , int r , int c){
            this.val = val; this.r = r; this.c = c;
        }
    }

    public int[][] colorGrid(int n, int m, int[][] sources) {

        int[][] ans = new int[n][m];
        
        // Max Heap based on 'color value'
        PriorityQueue<Triplets> pq = new PriorityQueue<>(
            (x, y) -> Integer.compare(y.val, x.val)
        );

        int len = sources.length;  // expected TC = O(len log(len)); 
        for(int i = 0 ; i < len ; i++){
            int r = sources[i][0] , c = sources[i][1] , color = sources[i][2];
            pq.offer(new Triplets(color,r,c));
            ans[r][c] = color;
        }

        Queue<Triplets> que = new LinkedList<>();
        while(!pq.isEmpty()) que.add(pq.poll());

        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};
        while(!que.isEmpty()){
            Triplets top = que.remove();
            int val = top.val , r = top.r , c = top.c;
            for(int i = 0 ; i < 4 ; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr >= 0 && nr < n && nc >= 0 && nc < m && ans[nr][nc] == 0){
                    ans[nr][nc] = val;
                    que.add(new Triplets(val,nr,nc));
                }
            }
        }

        return ans;



    }

}