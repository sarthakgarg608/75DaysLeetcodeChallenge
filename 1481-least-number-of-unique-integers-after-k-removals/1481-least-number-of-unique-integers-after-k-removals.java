class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int x : arr) map.put(x,map.getOrDefault(x,0) + 1);

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (x,y) -> Integer.compare(x[1],y[1])
        );

        for(int key : map.keySet()){
            pq.offer(new int[]{key,map.get(key)});
        }

        while(pq.size() > 0){
            if(k == 0) return pq.size();
            int[] top = pq.poll();
            int freq = top[1];
            if(freq <= k) {
                k -= freq;
            }else{
                pq.offer(top);
                break;
            }
            
            
        }
        return pq.size();
    }
}