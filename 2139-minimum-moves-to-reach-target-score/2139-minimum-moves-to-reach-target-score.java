class Solution {
    public int minMoves(int target, int maxDoubles) {

        // We can not double the current element so we need to increment at every op
        // Or target is '1' , our starting and ending points are same
        if(maxDoubles == 0 || target == 1) return target-1;

        int op = 0 ;
        while(target > 1)
        {
            if(target %2 == 0){
                int half = target /2;
                if(maxDoubles != 0){
                    op += 1;
                    maxDoubles -= 1;
                    target = half;
                }else{
                    return target - 1 + op;
                }
            }else{
                int half = target / 2;
                if(maxDoubles != 0){
                    op += 2;
                    maxDoubles -= 1;
                    target = half;
                }else {
                    return target-1 + op;
                }
            }
        }

        return op;
    
    }
}