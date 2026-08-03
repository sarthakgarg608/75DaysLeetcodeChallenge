class Solution {
    public int maxDistance(int[] position, int m) {
        int n = position.length;
        Arrays.sort(position);

        int low = 1;
        int high = position[n - 1] - position[0];
        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (canPlace(position, m, mid)) {
                ans = mid;      // mid is possible
                low = mid + 1;  // try for a larger minimum distance
            } else {
                high = mid - 1; // reduce the distance
            }
        }

        return ans;
    }

    private boolean canPlace(int[] position, int m, int dist) {
        int count = 1; // Place first ball at the first position
        int lastPlaced = position[0];

        for (int i = 1; i < position.length; i++) {
            if (position[i] - lastPlaced >= dist) {
                count++;
                lastPlaced = position[i];

                if (count == m) {
                    return true;
                }
            }
        }

        return false;
    }
}