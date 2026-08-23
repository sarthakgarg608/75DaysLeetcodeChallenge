class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] st) {
        int n = st.length;
        int dis = startFuel , idx = 0 , ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        while(dis < target){

            // add all stations that are reachable 
            while(idx < n && st[idx][0] <= dis){
                pq.offer(st[idx][1]);
                idx++;
            }

            // no reachable station 
            if(pq.size() == 0) return -1;

            dis += pq.peek();
            pq.remove();

            ans++;
        }

        return ans;

    }
}