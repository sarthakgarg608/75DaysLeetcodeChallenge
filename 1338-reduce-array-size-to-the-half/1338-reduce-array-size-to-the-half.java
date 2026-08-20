class Solution {
    public int minSetSize(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int x : arr) map.put(x,map.getOrDefault(x,0)+1);

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (x,y) -> Integer.compare(y[1],x[1])
        );

        for(int key : map.keySet()){
            pq.offer(new int[]{key,map.get(key)});
        }

        int ans = 0 , n = arr.length , curr = 0;
        while(pq.size() > 0){
            if(curr >= (n/2)) break;
            int[] top = pq.poll();
            ans += 1;
            curr += top[1];
        }
        return ans;
    }
}