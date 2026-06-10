class Solution {
    public long getDescentPeriods(int[] prices) {
        int n = prices.length;

        long ans = 0;
        int i = 0 , j = 0;
        while(j < n){
            if(i == j){
                j++;
                ans++;
            }else{
                if(prices[j]-prices[j-1] == -1) {
                    ans += (j-i+1);
                    j++;
                }else i = j;
            }
        }
        return ans;   
    }
}