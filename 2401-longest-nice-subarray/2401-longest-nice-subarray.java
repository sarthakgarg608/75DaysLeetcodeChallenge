class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int[][] prefix = new int[32][n];

        for(int j = 0 ; j < n ; j++){
            String binary = Integer.toBinaryString(nums[j]);
            int len = binary.length();
            for(int i = 0 ; i < len ; i++) prefix[len-1-i][j] = binary.charAt(i) - '0';
        }

        for(int i = 0 ; i < 32 ; i++){
            for(int j = 1; j < n ; j++){
                prefix[i][j] += prefix[i][j-1];
            }
        }

        // for every pair to be AND 0 there is only one possible case for every bit position there could be at  max one 1 if there are Two 1 not possible for all pair to be and 0
        int l = 0 , r = 0 , len = 1;
        while(r < n){
            if(l == r){
                r++;
                continue;
            }
            boolean flag = true;
            for(int i = 0 ; i < 32 ; i++){
                int ct = 0;
                if(l == 0) ct = prefix[i][r]; 
                else ct = prefix[i][r] - prefix[i][l-1];
                if(ct > 1) {
                    flag = false;
                    break;
                }

            }
            if(flag){
                len = Math.max(len,r-l+1);
                r++;
            }else {
                l++;
                if(l == r) r++;
            }

        }
        return len;

    }
}