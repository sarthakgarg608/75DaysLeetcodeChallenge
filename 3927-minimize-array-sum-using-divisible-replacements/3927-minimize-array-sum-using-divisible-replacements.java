class Solution {
    public long minArraySum(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();

        for (int x : nums) {
            if (x == 1) return n;
            set.add(x);
        }

        long ans = 0;

        for (int i = 0; i < n; i++) {
            long ele = nums[i];
            long res = ele;

            for (int j = 2; j * j <= ele; j++) {

                if (ele % j != 0) continue;

                if (set.contains(j))
                    res = Math.min(res, j);

                if (set.contains((int)(ele / j)))
                    res = Math.min(res, ele / j);
            }

            ans += res;
        }

        return ans;
    }
}