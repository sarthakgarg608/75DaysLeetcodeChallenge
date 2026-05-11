class Solution {
    public int bagOfTokensScore(int[] tokens, int power) {
        Arrays.sort(tokens);
        int maxi =0;
        int score = 0;
        int n = tokens.length;
        int lo = 0 , hi = n-1;
        while(lo <= hi)
        {
            if(power >= tokens[lo])
            {
                power -= tokens[lo];
                score += 1;
                maxi = Math.max(maxi,score);
                lo++;


            }
            
            else if(score >=1)
            {
                power += tokens[hi];
                score -= 1;
                hi--;

            }
            else
            {
                return maxi;
            }
            

        }
        return maxi;
        
    }
}