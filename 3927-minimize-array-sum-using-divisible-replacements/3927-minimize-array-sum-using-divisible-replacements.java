class Solution {
    public long minArraySum(int[] nums) {
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();

        for (int x : nums) {
            if (x == 1) return n;
            set.add(x);
        }

        long ans = 0;

        for (int ele : nums) {
            long res = ele;
            for (int j = 2; j * j <= ele; j++) {
                if (ele % j != 0) continue;
                if (set.contains(j)) res = Math.min(res, j);
                if (set.contains((int)(ele / j))) res = Math.min(res, ele / j);
            }
            ans += res;
        }
        return ans;
    }
}