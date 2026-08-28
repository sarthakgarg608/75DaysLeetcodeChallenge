class Solution {
    public int halveArray(int[] nums) {
        PriorityQueue<Double> pq = new PriorityQueue<>(Collections.reverseOrder());
        double sum = 0;
        for(int num : nums){
            sum += num;
            pq.offer((double)num);
        }

        double half = sum/2;
        int op = 0;
        while(pq.size() > 0){
            double top = pq.remove();
            if(sum <= half) return op;
            sum -= (top/2);
            pq.offer(top/2);
            op += 1;

        }
        return op;
    }
}