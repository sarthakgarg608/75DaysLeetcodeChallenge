class Solution {
    public int[] minDifference(int[] nums, int[][] queries) {
        int n1 = nums.length;
        int n2 = queries.length;

        int[][] prefix = new int[n1+1][101];
        for(int i = 0 ; i < n1 ; i++){
            int x = nums[i];
            prefix[i+1][x] = 1;
        }

        for(int i = 1 ; i <= 100; i++){
            for(int j = 1 ; j<= n1 ; j++){
                prefix[j][i] += prefix[j-1][i];
            }
        }

        int[] ans = new int[n2];
        for(int i = 0 ; i < n2; i++){
            int l = queries[i][0];
            int r = queries[i][1];
            int first = Integer.MAX_VALUE;
            int second = Integer.MAX_VALUE;
            boolean flag = false;
            int min = Integer.MAX_VALUE;
            for(int x = 1; x <= 100; x++){
                int ct = prefix[r+1][x] - prefix[l][x];
                if(ct >= 1){
                    if(flag) {
                        second = x;
                        min = Math.min(second-first,min);
                        first = second;
                    }else{
                        first = x;
                        flag = true;
                    }
                }

            }
            if(min == Integer.MAX_VALUE){
                ans[i] = -1;
            }else ans[i] = min;
        }
        return ans;
    }
}