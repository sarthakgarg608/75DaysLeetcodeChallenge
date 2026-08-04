class Solution {
    public int maxDistance(int[] nums1, int[] nums2) {

        int ans = 0;

        for(int i = 0 ;i < nums2.length;i++){
            int low = 0 , high = Math.min(i,nums1.length-1);

            int mxIdx = -1;
            while(low <= high){
                int mid = low + (high-low)/2;
                if(nums1[mid] <= nums2[i]){
                    mxIdx = mid;
                    low = mid+1;
                }else high = mid-1;
            }

            low = 0; high = Math.min(i,nums1.length-1);
            int mnIdx = -1;
            while(low <= high){
                int mid = low + (high-low)/2;
                if(nums1[mid] <= nums2[i]){
                    mnIdx = mid;
                    high = mid-1;
                }else low = mid+1;
            }
            
            if(mxIdx != -1) ans = Math.max(ans,i-mxIdx);
            if(mnIdx != -1) ans = Math.max(ans,i-mnIdx);

        }
        return ans;
    }
}