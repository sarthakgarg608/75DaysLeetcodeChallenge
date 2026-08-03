class Solution {
    public int findLengthOfShortestSubarray(int[] nums) {

        /**
        The main idea is to solve this problem is sorted prefix and suffix 
        we want to remove some continuous part from the array so that we have sorted array 
        .. We will find largest left index where arr[0] <= arr[1] <= .... <= arr[left]
        .. then for suffix we have to find smallest right such that 
        arr[right] <= arr[right+1] <= ..... <= arr[n-1]
        
        Now we have array like that     Sorted prefix | unsorted Array | sorted suffix 
        
        1) initial answer could be either remove all the elements after the sorted prefix 
        Or remove all elements that are behind the sorted Suffix 
        and we can take minimum of both that is Min(n-left-1 , right);
        
        2) there are another possibilities to find the answer is we can keep some elements from sorted prefix and some elements from sorted suffix such that 
        sorted prefix nums[0 .. i]  and sorted suffix nums[j....n-1];
        where Must satisfying condition is nums[i] <= nums[j] then how ?? 
        
         */

        int n = nums.length;

        int left = 0;
        for (int i = 1; i < n; i++) {
            if (nums[i] >= nums[i - 1])
                left = i;
            else
                break;
        }

        if (left == n - 1)
            return 0; // sorted array 

        int right = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] <= nums[i + 1])
                right = i;
            else
                break;
        }

        if (right == 0)
            return 0; // sorted suffix 

        // Initial answer
        int ans = Math.min(n - 1 - left, right);

        // we can use two pointers approach 

        int i = 0;
        int j = right;

        while (i <= left && j < n) {
            if (nums[i] <= nums[j]) {
                // We can connect prefix [0..i] with suffix [j..n-1]
                ans = Math.min(ans, j - i - 1);
                i++;
            } else {
                // Need a larger element from the suffix
                j++;
            }
        }

        return ans;

    }

}