class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {   

        int n = dist.length , lo = 1 , hi = (int)(1e7);

        int minSpeed = Integer.MAX_VALUE; 

        while(lo <= hi){
            int mid = lo + (hi-lo)/2;

            double totalHour = 0;

            for(int i =0 ; i < n ; i++){
                if(i == n-1) totalHour += (dist[i]*1.0)/(mid);
                else {
                    if(dist[i] <= mid) totalHour += 1;
                    else {
                        if(dist[i] % mid == 0) totalHour += ((dist[i]*1.0) / mid);
                        else {
                            int div = dist[i] / mid;
                            totalHour += ((div*1.0)+1);
                        }
                    }
                }
            }
            if(totalHour > hour) {
                lo = mid+1;
            }else {
                minSpeed = Math.min(minSpeed,mid);
                hi = mid-1;

            }
        }
        if(minSpeed == Integer.MAX_VALUE) return -1;
        return minSpeed;


    }
}