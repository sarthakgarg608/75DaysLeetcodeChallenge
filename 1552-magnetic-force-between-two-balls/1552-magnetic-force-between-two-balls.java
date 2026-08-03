class Solution {
    public boolean canPlace(int[] pos , int m ,int dist ){
        int ct = 1;
        int lastPlaced = pos[0];

        for(int i = 1; i < pos.length; i++){
            if(pos[i] - lastPlaced >= dist){
                ct += 1;
                lastPlaced = pos[i];
            }

            if(ct == m) return true;
        }

        return false;
    }
    public int maxDistance(int[] pos, int m) {
        int n = pos.length;
        Arrays.sort(pos);

        int lo = 1;                 // minimum distance 
        int hi = pos[n-1] - pos[0];  // maximum distance
        int ans = 0;

        while(lo <= hi){
            int mid = lo + (hi-lo)/2;

            if(canPlace(pos,m,mid)){ 
                ans = mid;    // Try for longer distance 
                lo = mid+1;
            }else hi = mid-1;  // can't place try for minimum dist
        }
        return ans;
        
    }
}