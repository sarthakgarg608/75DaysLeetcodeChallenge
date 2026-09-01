class MaxSGTree{
    int[] seg;
    public MaxSGTree(int n){
        seg = new int[4*n+1];
    }
    
    public void build(int idx , int low , int high,int[] arr){
        if(low == high){
            seg[idx] = arr[low];
            return ;
        }
        
        int mid = low + (high - low)/2;
        build(2*idx+1,low,mid,arr);
        build(2*idx+2,mid+1,high,arr);
        
        seg[idx] = Math.max(seg[2*idx+1] , seg[2*idx+2]);
    }
    
    public int query(int idx , int low , int high , int l , int r){
        // Complete overlap {l , low , high , r};
        if(low >= l && high <=r) {
            return seg[idx];
        }
        
        // No overlap {low , high , l ,r} or {l,r,low,high};
        if(high < l || r < low) return Integer.MIN_VALUE;
        
        // Partial overlap 
        int mid = low + (high - low)/2;
        int left = query(2*idx+1,low,mid,l,r);
        int right = query(2*idx+2 , mid+1,high,l,r);
        
        return Math.max(left,right);
    }
}
class MinSGTree{
    int[] seg;
    public MinSGTree(int n){
        seg = new int[4*n+1];
    }
    
    public void build(int idx , int low , int high,int[] arr){
        if(low == high){
            seg[idx] = arr[low];
            return ;
        }
        
        int mid = low + (high - low)/2;
        build(2*idx+1,low,mid,arr);
        build(2*idx+2,mid+1,high,arr);
        
        seg[idx] = Math.min(seg[2*idx+1] , seg[2*idx+2]);
    }
    
    public int query(int idx , int low , int high , int l , int r){
        // Complete overlap {l , low , high , r};
        if(low >= l && high <=r) {
            return seg[idx];
        }
        
        // No overlap {low , high , l ,r} or {l,r,low,high};
        if(high < l || r < low) return Integer.MAX_VALUE;
        
        // Partial overlap 
        int mid = low + (high - low)/2;
        int left = query(2*idx+1,low,mid,l,r);
        int right = query(2*idx+2 , mid+1,high,l,r);
        
        return Math.min(left,right);
    }
}

class Solution {
    public long continuousSubarrays(int[] nums) {
        int n = nums.length;
        MaxSGTree mxs = new MaxSGTree(n);
        MinSGTree mns = new MinSGTree(n);

        mxs.build(0,0,n-1,nums);
        mns.build(0,0,n-1,nums);

        int l = 0 , r = 0;
        long ans = 0;
        while(r < n){
            int max = mxs.query(0,0,n-1,l,r);
            int min = mns.query(0,0,n-1,l,r);
            if(max-min <= 2){
                ans += (r-l+1);
            }else{
                while(max-min > 2){
                    l++;
                    max = mxs.query(0,0,n-1,l,r);
                    min = mns.query(0,0,n-1,l,r);
                }
                ans += (r-l+1);
            }
            r++;
        }
        return ans;
    }
}