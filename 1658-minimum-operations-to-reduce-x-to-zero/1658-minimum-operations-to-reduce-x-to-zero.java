class Solution {
    int[] nums;
    int n;
    int x;
    // This approach could be possible but time complexity will be very high as per given constraints
    // public int solve(int lo , int hi , int x){
    //     if(x == 0) return 0;
    //     if(x < 0) return Integer.MAX_VALUE;
    //     int left = solve(lo+1,hi,x-nums[lo]);
    //     int right = solve(lo,hi-1,x-nums[hi]);
    //     int result = Math.min(left,right);
    //     if(result == Integer.MAX_VALUE) return -1;
    //     return 1 + result;
    // }

    public int solve(){
        int totalSum = 0;
        for(int val : nums) totalSum += val;

        int target = totalSum - x;

        if(target == 0) return n;
        if(target < 0) return -1;

        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(nums[0],1);
        map.put(0 , 0);
        int sum = nums[0];
        for(int i = 1; i < n ; i++){
            sum += nums[i];
            map.put(sum,i+1); 
        }

        int curr = 0;
        int len = 0;
        for(int i = 0 ; i < n ; i++){
            curr += nums[i];
            int rem = curr - target;
            if(rem < 0) continue;
            if(map.containsKey(rem)){
                len = Math.max(len,i-map.get(rem)+1);
        
            }
        }
        if(len == 0) return -1;
        return n-len;

       

    }
    public int minOperations(int[] nums, int x) {
        this.nums = nums;
        this.n = nums.length;
        this.x = x;

        return solve();
   
    }
}