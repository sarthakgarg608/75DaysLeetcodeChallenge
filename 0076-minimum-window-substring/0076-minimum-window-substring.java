class Solution {
    public String minWindow(String s, String t) {
        int[] map = new int[256];
        int n = s.length() , m = t.length() , ct = 0 , sIdx = -1 , minLen = Integer.MAX_VALUE;

        for(int i = 0 ; i < m; i++){
            map[t.charAt(i)]++;
        }

        int l = 0 , r = 0;
        while(r < n){
            if(map[s.charAt(r)] > 0) ct += 1;
            map[s.charAt(r)]--;

            while(ct == m){
                if(r-l+1 < minLen){
                    minLen = r-l+1;
                    sIdx = l;
                }

                map[s.charAt(l)]++;
                if(map[s.charAt(l)] > 0) ct -=1;
                l++;
            }

            r++;
        }
        return sIdx == -1 ? "" : s.substring(sIdx,sIdx+minLen);
    }
}