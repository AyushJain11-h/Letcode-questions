class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;
        int[] pos = new int[n];
        int[] prefix = new int[n + 1];

        // Extract positions and prefix sums
        for (int i = 0; i < n; i++) {
            pos[i] = fruits[i][0];
            prefix[i + 1] = prefix[i] + fruits[i][1];
        }

        int ans = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            while (left <= right && !canReach(pos[left], pos[right], startPos, k)) {
                left++;
            }
            ans = Math.max(ans, prefix[right + 1] - prefix[left]);
        }

        return ans;
    }

    private boolean canReach(int left, int right, int startPos, int k) {
        int leftCost = Math.abs(startPos - left) + (right - left);
        int rightCost = Math.abs(startPos - right) + (right - left);
        return Math.min(leftCost, rightCost) <= k;
    }
}