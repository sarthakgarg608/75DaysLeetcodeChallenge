class Solution {
    int[][] rides;
    int n;
    Long[] dp;
    public int findIdx(int target){
        int lo = 0 , hi = rides.length-1;
        int ans = rides.length;
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            int start = rides[mid][0];
            if(start >= target) {
                ans = mid;
                hi = mid-1;
            }else lo = mid+1;
        }
        return ans;
    }
    public long solve(int idx){

        if(idx >= rides.length) return 0;

        if(dp[idx] != null) return dp[idx];

        long profit = rides[idx][1] - rides[idx][0] + rides[idx][2];

        int newIdx = findIdx(rides[idx][1]);

        return dp[idx] = Math.max(profit + solve(newIdx) , solve(idx+1));
    }
    public long maxTaxiEarnings(int n, int[][] rides) {
        this.rides = rides;
        this.n = n;
        Arrays.sort(rides,(a,b)-> Integer.compare(a[0],b[0]));
        dp = new Long[rides.length+1];

        return solve(0);
        
    }
}