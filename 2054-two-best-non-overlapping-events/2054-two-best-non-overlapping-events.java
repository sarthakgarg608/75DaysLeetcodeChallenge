class Solution {
    int[][] events ;
    int n;
    Integer[][] dp;

    public int findIdx(int end){
        int lo = 0 , hi = n-1;
        int ans = n;
        while(lo <= hi){
            int mid  = lo + (hi-lo)/2;
            int start = events[mid][0];
            if(start > end){
                ans = mid;
                hi = mid-1;
            }else lo = mid+1;
        }
        return ans;
    }

    public int solve(int idx, int event){

        if(event == 2) return 0;
        if(idx >= n) return 0;
        

        if(dp[idx][event] != null) return dp[idx][event];

        int end = events[idx][1];
        int profit = events[idx][2];

        int newIdx = findIdx(end);
        return dp[idx][event] = Math.max(profit + solve(newIdx,event+1) , solve(idx+1,event));
    }

    public int maxTwoEvents(int[][] events) {
        this.events = events;
        this.n = events.length;
        dp = new Integer[n+1][3];

        Arrays.sort(events,(a,b) -> Integer.compare(a[0],b[0]));

        return solve(0,0);
        
    }
}