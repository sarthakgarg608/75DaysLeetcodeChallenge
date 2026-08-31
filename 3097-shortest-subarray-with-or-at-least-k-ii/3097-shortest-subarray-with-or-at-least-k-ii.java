class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;

        // check for single element
        for(int num : nums) if(num >= k) return 1;

        // for every number in array we store the binary number in the prefix
        int[][] prefix = new int[32][n];

        for(int j = 0 ; j < n ; j++){
            String binary = Integer.toBinaryString(nums[j]);
            int len = binary.length();
            for(int i = 0 ; i < len; i++) prefix[len-1-i][j] = binary.charAt(i) - '0';
        }

        for(int i = 0 ; i < 32; i++){
            for(int j = 1; j < n ; j++){
                prefix[i][j] += prefix[i][j-1];
            }
        }

        int l = 0 , r = 0 , or = 0 , min = Integer.MAX_VALUE;
        while(r < n){
            or = or | nums[r];
            if(or >= k){
                min = Math.min(min,r-l+1);
            }
            while(or >= k && l < r){
                // now find or from range l+1 to r
                l++;
                int p = 1;
                int newOr = 0;
                for(int i = 0 ; i < 32 ; i++){
                    int ct = prefix[i][r] - prefix[i][l-1];
                    if(ct > 0) {
                       newOr += p; 
                    }
                    p *= 2;
                }
                or = newOr;
                if(or >= k) min = Math.min(min,r-l+1);
            }
            r++;
        }
        return min == Integer.MAX_VALUE ? -1 : min;
        
    }
}