class Solution {
    HashMap<String,Long> map;
    public long solve(int idx ,int target,int xor ,int[] nums){
        int n = nums.length;
        if(idx == n){
            if(xor == target) return 0;
            else return Integer.MAX_VALUE;
        } 

        String key = idx + " " + xor;
        if(map.containsKey(key)) return map.get(key);

        long ans =  Math.min(solve(idx+1,target,xor^nums[idx],nums) , 1 + solve(idx+1,target,xor,nums));
        map.put(key,ans);
        return ans;
    }
    public int minRemovals(int[] nums, int target) {
        int n = nums.length;
        map = new HashMap<>();
        long ans = solve(0,target,0,nums);
        if(ans == Integer.MAX_VALUE) return -1;
        else return (int)ans;
        
    }
}