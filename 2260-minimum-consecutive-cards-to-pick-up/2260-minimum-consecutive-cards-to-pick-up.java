class Solution {
    public int minimumCardPickup(int[] cards) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int l = 0 , r = 0 , len = Integer.MAX_VALUE;
        while(r < cards.length){
            if(len == 2) return len;
            if(map.containsKey(cards[r]) && map.get(cards[r]) > 0){
                map.put(cards[r], map.get(cards[r])+1);
                len = Math.min(len,r-l+1);
                while(map.get(cards[l]) != 2){
                    map.put(cards[l],map.get(cards[l])-1);
                    l++;
                    len = Math.min(len,r-l+1);
                }
                if(map.get(cards[l]) == 2){
                    map.put(cards[l] , 1);
                    l++;
                }
            }else map.put(cards[r],1);
            r++;
            
        }
        return len == Integer.MAX_VALUE ? -1 : len;
    }
}