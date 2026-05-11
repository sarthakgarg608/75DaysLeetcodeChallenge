class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        List<Integer> ans = new ArrayList<>();
        int n = arr.length;
        if(n == 1) return ans;
        if(n == 2 && arr[0] < arr[1]) return ans;
        for(int x = n; x >= 3; x--)
        {
            int idx = -1;
            for(int j = 0;j<n;j++)
            {
                if(arr[j] == x)
                {
                    idx = j;
                    break;
                }
            }
            if(idx == x-1) continue;
            if(idx == 0){
                ans.add(x);
            }else {
                ans.add(idx+1);
                ans.add(x);
            }
            int lo = 0 , hi = idx;
            while(lo <= hi)
            {
                int temp = arr[lo];
                arr[lo] = arr[hi];
                arr[hi] = temp;
                lo++;
                hi--;
            }
            lo = 0 ; hi = x-1;
            while(lo <= hi)
            {
                int temp = arr[lo];
                arr[lo] = arr[hi];
                arr[hi] = temp;
                lo++;
                hi--;
            }
        }
        if(arr[0] < arr[1]) return ans;
        else {
            ans.add(2);
            return ans;
        }
        
        
    }
}