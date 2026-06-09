class Solution {
    int[][] grid;
    int[][] moveCost;
    int m ;
    int n ;
    Integer[][] dp;
    public int solve(int r , int c){

        if(r == m-1) return grid[r][c];

        if(dp[r][c] != null) return dp[r][c];

        int visCos = grid[r][c];
        int ans = Integer.MAX_VALUE;
        for(int col = 0; col< n;col++){
            int i = visCos;
            int j = col;
            ans = Math.min(ans,visCos + moveCost[i][j] + solve(r+1,col));
        }
        return dp[r][c] =  ans;
    }
    public int minPathCost(int[][] grid, int[][] moveCost) {
        this.grid = grid;
        this.moveCost = moveCost;
        m = grid.length ; n = grid[0].length;
        dp = new Integer[m][n];

        int ans = Integer.MAX_VALUE;

        for(int j =0; j < n; j++){
            ans = Math.min(ans,solve(0,j));
        }
        return ans;
        
    }
}