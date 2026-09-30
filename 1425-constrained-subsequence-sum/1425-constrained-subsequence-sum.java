class Solution {
    class Pair{
        int first ;
        int second;
        Pair(int first , int second){
            this.first = first;
            this.second = second;
        }
    }
    public int solve(int[] nums, int n , int k){
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> b.first-a.first);
        pq.add(new Pair(nums[0],0));
        int ans = nums[0];
        for(int i = 1; i < n ; i++){
            while(i-pq.peek().second > k) pq.poll();

            // because if all are negative then we select a single element with less negative
            int sum = Math.max(0,pq.peek().first) + nums[i];
            ans = Math.max(ans,sum);
            pq.add(new Pair(sum,i));
        }
        return ans;
    }
    public int constrainedSubsetSum(int[] nums, int k) {
      int n = nums.length;
      return solve(nums,n, k);
       
        
    }
}