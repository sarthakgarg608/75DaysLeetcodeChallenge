class Solution {
    class Pair{
        int first ;
        int second;
        Pair(int first , int second){
            this.first = first;
            this.second = second;
        }
    }
    public boolean BinarySearch(int l , int r , List<Pair> list){
        int lo = 0 , hi = list.size()-1;
        while(lo <= hi){
            int mid = lo + (hi-lo)/2;
            Pair temp = list.get(mid);
            int first = temp.first;
            int second = temp.second;
            if(first >= l && second <= r) return false;
            else if(first >= r) hi = mid-1;
            else lo = mid+1;
        }
        return true;
    }
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = queries.length;
        boolean[] ans = new boolean[n];
        int[] parity = new int[nums.length];
        for(int i = 0 ; i < nums.length ; i++) parity[i] = (nums[i]%2);

        List<Pair> list = new ArrayList<>();
        for(int i = 0 ; i < nums.length-1; i++){
            if(parity[i] == parity[i+1]) list.add(new Pair(i,i+1));
        }

        for(int i = 0 ; i < n ; i++){
            int l = queries[i][0];
            int r = queries[i][1];
            boolean check = BinarySearch(l,r,list);
            ans[i] = check;
        }
        return ans;
    }
}