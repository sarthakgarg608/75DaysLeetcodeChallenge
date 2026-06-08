class Solution {
    int[][] grid;
    int m;
    int n;
    int[] dr = {-1,0,1};
    int[] dc = {1,1,1};
    Integer[][] dp;

    public int solve(int r , int c ){

        if(dp[r][c] != null) return dp[r][c]; 
        int ans =0;
        for(int k = 0;k<3;k++){
            int nr = r + dr[k];
            int nc = c + dc[k];
            if(nr >= 0 && nr < m && nc >=0 && nc < n && grid[nr][nc] > grid[r][c]){
                ans = Math.max(ans,1+solve(nr,nc));
            }
        }
        return dp[r][c] =  ans;
    }
    public int maxMoves(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;

        dp = new Integer[m][n];        

        int ans = 0;
        for(int i =0;i<m;i++){
            ans = Math.max(ans,solve(i,0));
        }
        return ans;

        
    }
}