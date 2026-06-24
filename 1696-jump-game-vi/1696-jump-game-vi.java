class Pair{
    int val;
    int idx;
    Pair(int val , int idx){
        this.val = val;
        this.idx = idx;
    }
}
class Solution {
    public int maxResult(int[] nums, int k) {
        int n = nums.length;
        Integer[] dp = new Integer[n+1];

        // dp[i] "the maximum score to reach the end starting at index idx "
        dp[n-1] = nums[n-1];

        PriorityQueue<Pair> pq =
            new PriorityQueue<>((a, b) -> Integer.compare(b.val, a.val));
        pq.add(new Pair(nums[n-1],n-1));

        for(int i = n-2;i>=0;i--){
            while(true){
                Pair top = pq.peek();
                int idx = top.idx;
                int val = top.val;
                if(idx <= i+k){
                    dp[i] = nums[i] + val;
                    pq.add(new Pair(dp[i],i));
                    break;
                }else pq.remove();
            }
        }
        return dp[0];   
    }
}