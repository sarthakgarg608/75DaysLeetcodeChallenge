class Solution {
    public long minimumOperations(int[] nums, int[] target) {
        int[] require = new int[nums.length];
        for(int i = 0 ; i < nums.length ; i++){
            require[i] = target[i] - nums[i];
        }

        long ans = Math.abs(require[0]);
        boolean prev;
        if(require[0] >= 0) prev = true;
        else prev = false;

        // true -> positive , false -> negative
        for(int i = 1; i < nums.length; i++){
            boolean curr;
            if(require[i] >= 0) curr = true;
            else curr = false;
            if((curr && prev) || (!curr && !prev)){
                // both are same sign 
                long extra = Math.max(0,Math.abs(require[i]) - Math.abs(require[i-1]));
                ans += extra;
            }else {
                // sign changed either + -> - or - --> +  we need to add this value 
                ans += Math.abs(require[i]);
                prev = curr;
            }
        }
        return ans;
    }
}