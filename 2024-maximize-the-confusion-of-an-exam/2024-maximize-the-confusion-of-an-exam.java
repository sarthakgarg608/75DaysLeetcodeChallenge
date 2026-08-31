class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        /**
        In this problem we can do one thing we can store the ct of T and F in the window 
        here window will be valid till min(ctT,ctF) <= k here we can change all T's into F's
        or all F's into T  if this is not valid then we will shrink the window 
         */

        int n = answerKey.length() , ctT = 0 , ctF = 0 , maxLen = 0;
        int l = 0 , r = 0;
        while(r < n){
           char ch = answerKey.charAt(r);
           if(ch == 'T') ctT++;
           else ctF++;
           if(Math.min(ctT,ctF) <= k){
            maxLen = Math.max(maxLen,r-l+1);
           }
           while(Math.min(ctT,ctF) > k){
            char prev = answerKey.charAt(l);
            if(prev == 'T') ctT--;
            else ctF--;
            l++;
           }
           r++;
        }
        return maxLen;
    }
}