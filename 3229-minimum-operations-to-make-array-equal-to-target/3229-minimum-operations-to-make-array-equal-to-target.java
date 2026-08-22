class Solution {
    public long minimumOperations(int[] nums, int[] target) {
        int[] require = new int[nums.length];
        for(int i = 0 ; i < nums.length ; i++){
            require[i] = target[i] - nums[i];
        }

        int l = 0 , r = 0;
        long ans = 0;
        while(r < nums.length){
            if((require[l]>= 0 && require[r] >= 0) || (require[l] < 0 && require[r] < 0)) r++;
            else {
                r -= 1;
                // we have block of same sign require[l...r];
                ans += Math.abs(require[l]);
                for(int i = l+1 ; i <= r; i++){
                    // we are calculating extra if it decrease that means no need extra operation or increase need extra operation
                    ans += Math.max(0,Math.abs(require[i])-Math.abs(require[i-1]));
                }
                l = r+1;
                r++;
            }
        }

        // for example we have require [1,2,3,4] then else will never execute 
        r -= 1;
        ans += Math.abs(require[l]);
        for(int i = l+1 ; i <= r; i++){
            // we are calculating extra if it decrease that means no need extra operation or increase need extra operation
            ans += Math.max(0,Math.abs(require[i])-Math.abs(require[i-1]));
        }

        return ans;
    }
}