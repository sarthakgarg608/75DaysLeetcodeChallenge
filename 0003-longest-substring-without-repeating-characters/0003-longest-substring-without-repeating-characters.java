class Solution {
    public int lengthOfLongestSubstring(String s) {
        int l = 0 , r = 0 , n = s.length();
        boolean[] flag = new boolean[256];
        int mxlen = 0;
        while(r < n){
            int val = s.charAt(r);
            if(!flag[val]){
                mxlen = Math.max(mxlen,r-l+1);
                flag[val] = true;
                r++;
            }else{
                while(flag[val] == true){
                    flag[s.charAt(l)] = false;
                    l++;                    
                }
                flag[val] = true;
                mxlen = Math.max(mxlen,r-l+1);
                r++;
            }
        }
        return mxlen;

    }
}