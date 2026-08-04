class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {   

        int n = dist.length;
        int lo = 1;
        int hi = (int)(1e7);
        

        int min = Integer.MAX_VALUE; 

        while(lo <= hi){
            int mid = lo + (hi-lo)/2;

            double totalHour = 0.0;

            for(int i =0 ; i < n ; i++){
                if(i == n-1) totalHour += (dist[i]*1.0)/(mid*1.0);
                else {
                    if(dist[i] <= mid) totalHour += 1.0;
                    else {
                        if(dist[i] % mid == 0) totalHour += ((dist[i]*1.0) / mid);
                        else {
                            int div = dist[i] / mid;
                            totalHour += (div*1.0+1.0);
                        }
                    }
                }
            }
            if(totalHour > hour) {
                lo = mid+1;
            }else {
                min = Math.min(min,mid);
                hi = mid-1;

            }
        }
        if(min == Integer.MAX_VALUE) return -1;
        return min;


    }
}