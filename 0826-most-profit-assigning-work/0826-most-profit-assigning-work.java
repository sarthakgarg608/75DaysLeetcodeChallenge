class Solution {
    public int lb(int[][] grid, int target){
        int low = 0 , high = grid.length-1;
        int lb = grid.length;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(grid[mid][0] <= target) low = mid+1;
            else if(grid[mid][0] > target){
                lb = Math.min(lb,mid);
                high = mid-1;
            } 

        }
        return lb;

    }
    public int maxProfitAssignment(int[] d, int[] p, int[] w) {
        int[][] grid = new int[p.length][2];
        for(int i =0;i<p.length;i++){
            grid[i][0] = d[i];
            grid[i][1] = p[i];
        }

        Arrays.sort(grid,(a,b) -> Integer.compare(a[0],b[0]));

        int[] mxProfit = new int[p.length];
        mxProfit[0] = grid[0][1];
        for(int i =1;i<p.length;i++){
            mxProfit[i] = Math.max(mxProfit[i-1],grid[i][1]);
        }

        int ans = 0;
        for(int i =0;i<w.length;i++){
            int lb = lb(grid,w[i]);
            if(lb == 0 && grid[0][0] > w[i]) continue;
            if(lb == p.length) {
                ans += mxProfit[lb-1];
                continue;
            }
            while(grid[lb][0] > w[i]) lb--;
            ans += mxProfit[lb];

        }
        return ans;   
    }
}