class Solution {
    int[][] grid;
    Integer[][] dp;
    int n;
    // public int solve(int idx , int ct , int time){
        
    //     int n = grid.length;
    //     if(time > n) time = n;
    //     if(idx == n){
    //         if(n-ct <= time) return 0;
    //         else return Integer.MAX_VALUE;
    //     }
    //     if(n-ct <= time) return 0;
    //     if(dp[idx][ct][time] != null) return dp[idx][ct][time];
    //     int next = solve(idx+1, ct+1, time+grid[idx][1]);
    //     int take = next == Integer.MAX_VALUE ? Integer.MAX_VALUE : grid[idx][0] + next;
    //     int notTake = solve(idx+1,ct,time);
    //     return dp[idx][ct][time]= Math.min(take,notTake);

    // }
    public int solve(int idx , int time){
        if(idx == n){
            if(time <= 0) return 0;
            else return Integer.MAX_VALUE;
        }        
        if(time <= 0) return 0;
        if(dp[idx][time] != null) return dp[idx][time];
        int next = solve(idx+1,time-1-grid[idx][1]);
        int take = next == Integer.MAX_VALUE ? Integer.MAX_VALUE  : grid[idx][0] + next;
        int notTake = solve(idx+1,time);
        return dp[idx][time] =Math.min(take,notTake);
    }
    public int paintWalls(int[] cost, int[] time) {
        // we will be having one solving function where we will have 3 parameters 
        // index , ct that will show that and how much paid painter we have taken , time taken by those paid painter 
        n = cost.length;
        this.grid = new int[n][2];
        for(int i = 0 ; i < n ; i++){
            // the row represent that the cost grid[i][0]  is required to paint the i wall with time grid[i][1];
            grid[i][0] = cost[i];
            grid[i][1] = time[i];
        }
        Arrays.sort(grid,(a,b) ->{
            if(a[1] == b[1]) return a[0]-b[0];
            else return b[1]-a[1];
        });

        //this.dp = new Integer[n][n][n+1];  this give MLE and TLE
        this.dp = new Integer[n][n+1];

        //return solve(0,0,0);
        return solve(0,n);




        
    }
}