class Solution {
    public long maxSum(List<Integer> arr, int m, int k) {
        int n = arr.size();
        int[] nums = new int[n];
        for(int i = 0 ; i < n ; i++) nums[i] = arr.get(i);
        HashMap<Integer,Integer> map = new HashMap<>();


        int l = 0 , r = 0 , size = 0;
        long sum = 0 , ans = 0;
        while(r < n){
            map.put(nums[r] , map.getOrDefault(nums[r],0)+1);
            size++;
            sum += nums[r];
            if(size == k){
                if(map.size() >= m) ans = Math.max(ans,sum);

                if(map.get(nums[l]) == 1) map.remove(nums[l]);
                else map.put(nums[l],map.get(nums[l]) - 1);
                sum -= nums[l];
                l++;
                size--;
            }
            r++;   
        }
        return ans;
        
    }
}