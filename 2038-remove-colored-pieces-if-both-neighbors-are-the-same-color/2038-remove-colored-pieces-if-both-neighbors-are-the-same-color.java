class Solution {
    public boolean winnerOfGame(String colors) {
        
        /**

        In this problem statement we have to find that which player will win this game
        As we Know in this problem for Alice "AAA" this substring must be present so that
        he can remove character at middle 
        for Bob "BBB" this substring must be in the original string 
        we can find total group of string substrings "AAAA" like that and also for Bob 
        we have to find substring like "BBBBB"  

        */

        
        int ctAlice = 0 , ctBob = 0;
        int i = 0;
        while(i < colors.length()){
            if(colors.charAt(i) == 'A'){
                int j = i+1;
                while(j < colors.length()){
                    if(colors.charAt(j) == 'A'){
                        j++;
                    }else break;
                }
                int len = j-i;
                if(len > 2){
                    ctAlice += (len-2);
                }
                i = j;


            }else{
                int j = i+1;
                while(j < colors.length()){
                    if(colors.charAt(j) == 'B'){
                        j++;
                    }else break;
                }
                int len = j-i;
                if(len > 2){
                    ctBob += (len-2);
                }
                i = j;

            }
        }

        if(ctAlice > ctBob) return true;
        else return false;
        

    }
}