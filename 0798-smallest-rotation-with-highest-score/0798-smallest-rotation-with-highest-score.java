class Solution {
    public int bestRotation(int[] nums) {
        int n = nums.length;
        int[] diff = new int[n];

        for (int i = 0; i < n; i++) {
            int low = (i + 1) % n;
            int high = (i - nums[i] + n + 1) % n;

            diff[low]++;
            diff[high]--;

            // Handle wrap-around
            if (low >= high) {
                diff[0]++;
            }
        }

        int maxScore = 0;
        int score = 0;
        int bestK = 0;

        for (int k = 0; k < n; k++) {
            score += diff[k];
            if (score > maxScore) {
                maxScore = score;
                bestK = k;
            }
        }

        return bestK;
    }
}