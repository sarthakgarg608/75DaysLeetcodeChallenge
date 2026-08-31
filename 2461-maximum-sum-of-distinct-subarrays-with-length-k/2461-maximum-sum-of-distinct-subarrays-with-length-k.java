class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long[] prefix = new long[n];
        prefix[0] = nums[0];
        for(int i = 1 ; i < n ; i++){
            prefix[i] = prefix[i-1] + nums[i];
        }

        int l = 0 , r = 0;
        long mxSum = 0;
        HashSet<Integer> set = new HashSet<>();
        int len = 0;
        while(r < n){
            if(!set.contains(nums[r])){
                set.add(nums[r]);
                len += 1;
            }else{
                while(set.contains(nums[r])){
                    set.remove(nums[l]);
                    l++;
                    len = r-l+1;
                }
                set.add(nums[r]);
            }
            

            if(len == k){
                mxSum = Math.max(mxSum,l == 0 ? prefix[r] : prefix[r] - prefix[l-1]);
                set.remove(nums[l]);
                l++;
                len -= 1;
            }
            r++;

        }
        return mxSum ;
    }
}