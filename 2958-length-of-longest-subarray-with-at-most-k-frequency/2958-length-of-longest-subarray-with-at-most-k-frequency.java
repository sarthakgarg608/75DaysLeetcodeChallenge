class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        int l = 0 , r = 0 , maxi = 0;
        while(r < n){
            if(map.containsKey(nums[r])){
                int freq = map.get(nums[r]);
                if(freq < k) {
                    map.put(nums[r],freq+1);
                    maxi = Math.max(maxi,r-l+1);
                }else{
                    while(map.get(nums[r]) >= k){
                        map.put(nums[l] , map.get(nums[l])-1);
                        l++;
                    }
                    map.put(nums[r],map.get(nums[r])+1);
                    maxi = Math.max(r-l+1,maxi);
                }
            }else{
                map.put(nums[r],1);
                maxi = Math.max(maxi,r-l+1);
            }
            r++;
        }
        return maxi;
    }
}