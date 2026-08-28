class Solution {
    public int minOperations(int[] target, int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < target.length; i++){
            map.put(target[i],i);
        }

        // they will store the indexes after that we can find LIS 
        List<Integer> lcs = new ArrayList<>();
        for(int i = 0 ; i < arr.length ; i++){
            if(map.containsKey(arr[i])) lcs.add(map.get(arr[i]));
        }

        if(lcs.size() == 0) return target.length ;

        ArrayList<Integer> lis = new ArrayList<>();

        for (int num : lcs) {

            int left = 0;
            int right = lis.size();

            // Find first index where lis.get(mid) >= num
            while (left < right) {

                int mid = left + (right - left) / 2;

                if (lis.get(mid) >= num) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }

            // If num is greater than every element
            if (left == lis.size()) {
                lis.add(num);
            } 
            else {
                lis.set(left, num);
            }
        }

        return target.length - lis.size();
    }
}