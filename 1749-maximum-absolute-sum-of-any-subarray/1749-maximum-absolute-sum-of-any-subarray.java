class Solution {
    public int maxAbsoluteSum(int[] nums) {
        /**
        The approach that will work is kadane's algo in both directions
        we will maintain two variable that is maxSum , minSum
        and at the end take maximum of absolute of both 
        the motive is kadane's algo find max sum positive and if
        sum is negative we reset it zero  */


        int maxSum = Integer.MIN_VALUE;
        int minSum = Integer.MAX_VALUE;
        int currPSum = 0 , currNSum = 0;
        int n = nums.length;

        for(int i = 0 ; i <n; i++){
        currPSum += nums[i];
        currNSum += nums[i];

        maxSum = Math.max(maxSum,currPSum);
        minSum = Math.min(minSum,currNSum);

        if(currPSum < 0) currPSum = 0;
        if(currNSum > 0) currNSum = 0;

        }

       return Math.max(Math.abs(maxSum),Math.abs(minSum));
    }
}