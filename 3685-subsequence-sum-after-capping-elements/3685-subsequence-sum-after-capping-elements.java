class Solution {
    public boolean[] subsequenceSumAfterCapping(int[] nums, int k) {
        Arrays.sort(nums); int n = nums.length;

        // this will store the sum 
        HashSet<Integer> set = new HashSet<>();
        set.add(0); int idx = 0;

        boolean[] result = new boolean[n];

        for(int cap = 1; cap <= n; cap++){
            while(idx < n && nums[idx] <= cap){
                List<Integer> list = new ArrayList<>(set);
                for(int sum : list){
                    int newSum = sum + nums[idx];
                    if(newSum <= k) set.add(newSum);
                }
                idx++;
            }
            if(set.contains(k)) result[cap-1] = true;
            else{
                for(int p = idx;p<n;p++){
                    int rightRemaining = p-idx+1;
                    int needed = k - (rightRemaining*cap);
                    if(set.contains(needed)){
                        result[cap-1] = true;
                        break;
                    }
                }
            }
        }
        return result;
        
        
    }
}