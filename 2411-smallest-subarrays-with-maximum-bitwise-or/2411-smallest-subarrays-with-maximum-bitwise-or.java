class Solution {
    public int UB(int row , int target , int[][] prefix){
        int lo = 0 , hi = prefix[0].length-1;
        int ub = prefix[0].length;

        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            if(prefix[row][mid] > target){
                ub  = Math.min(ub,mid);
                hi = mid-1;
            }else lo = mid+1;
            
        }
        return ub;

    }
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[][] prefix = new int[32][n];

        for(int j= 0 ; j < n; j++){
            String binary = Integer.toBinaryString(nums[j]);
            int len = binary.length();
            for(int i = 0 ; i < len; i++){
                prefix[len-1-i][j] = binary.charAt(i) -'0';
            }
        }

        for(int i = 0 ; i < 32 ; i++){
            for(int j = 1; j < n ; j++){
                prefix[i][j] += prefix[i][j-1];
            }
        }

        int[] ans = new int[n];
        for(int j = 0 ; j < n ; j++){
            int mxLen = 1;
            for(int i = 0 ; i < 32 ; i++){
                if(j == 0){
                    if(prefix[i][j] == 0) {
                        int ub = UB(i,prefix[i][j], prefix);
                        if(ub != nums.length){
                            mxLen = Math.max(ub-j+1,mxLen);
                        }
                    }else mxLen = Math.max(mxLen,1);
                }else {
                    if(prefix[i][j] - prefix[i][j-1] > 0){
                        mxLen = Math.max(mxLen,1);
                    }else {
                        int ub = UB(i,prefix[i][j],prefix);
                        if(ub != nums.length){
                            mxLen = Math.max(ub-j+1,mxLen);
                        }
                    }
                }
            }
            ans[j] = mxLen;
        }
        return ans;
    }
}