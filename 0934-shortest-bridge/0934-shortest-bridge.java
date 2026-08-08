class Triplets{
    int r , c , step;
    Triplets(int r , int c , int step){
        this.r = r;
        this.c = c;
        this.step = step;
    }
}

class Solution {
    int[][] grid;
    int[] dr;
    int[] dc;
    int n ;

    public void dfs(int r , int c , int[][] vis){
        vis[r][c] = 1;
        for(int i = 0 ; i < 4 ; i++){
            int nr = dr[i] + r;
            int nc = dc[i] + c;
            if(nr >= 0 && nr < n && nc >= 0 && nc < n && vis[nr][nc] == 0 && grid[nr][nc] ==1) dfs(nr,nc,vis);
        }
    }
    public int shortestBridge(int[][] grid) {
        this.grid = grid;
        
        this.dr = new int[]{-1,0,1,0};
        this.dc = new int[]{0,1,0,-1};
        this.n = grid.length;
        int[][] vis = new int[n][n];

        int r = 0 , c = 0 ;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 1) {
                    r = i; c = j;
                    break;
                }
            }
        }

        dfs(r,c,vis);

        int[][] grid2 = new int[n][n];
        for(int i = 0 ; i<n;i++){
            for(int j = 0; j< n ; j++){
                grid2[i][j] = -1;
            }
        }
        for(int i = 0 ; i <n ; i++ ){
            for(int j = 0 ; j < n ; j++){
                if(vis[i][j] == 1) grid2[i][j] =0;
                else if(vis[i][j] == 0 && grid[i][j] == 1) grid2[i][j] = 1;
            }
        }

        // grid2[i][j] == -1  // It represent water
        // grid2[i][j] == 0  // There is one island that are connected
        // grid2[i][j] == 1 // There is another island that are not linked with island 1

        Queue<Triplets> que = new LinkedList<>();
        int[][] vis2 = new int[n][n];
        for(int i = 0 ; i< n ; i++){
            for(int j = 0 ; j< n ; j++){
                if(grid2[i][j] == 0){
                    vis2[i][j] = 1;
                    que.add(new Triplets(i,j,0));
                }
            }
        }

        while(!que.isEmpty()){
            Triplets top = que.remove();
            int row  = top.r ;
            int col = top.c;
            int step = top.step;
            for(int i = 0 ; i < 4 ; i++){
                int nr = row + dr[i];
                int nc = col + dc[i];
                if(nr >= 0 && nr < n && nc >= 0 && nc < n && vis2[nr][nc] == 0){
                    if(grid2[nr][nc] == 1) return step;
                    else {
                        vis2[nr][nc] = 1;
                        que.add(new Triplets(nr,nc,step+1));
                    }


                }
            }
        }

        return 0;


    }
}