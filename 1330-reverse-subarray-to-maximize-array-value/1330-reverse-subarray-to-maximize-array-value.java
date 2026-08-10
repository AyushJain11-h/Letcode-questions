class Solution {

    public int maxValueAfterReverse(int[] nums) {

        int n = nums.length;

        int original = 0;
        int gain = 0;

        int minMax = Integer.MAX_VALUE;
        int maxMin = Integer.MIN_VALUE;

        for (int i = 0; i < n - 1; i++) {

            int a = nums[i];
            int b = nums[i + 1];

            original += Math.abs(a - b);

            // Maximum gain from reversing a subarray
            gain = Math.max(gain,
                    Math.abs(nums[0] - b) - Math.abs(a - b));

            gain = Math.max(gain,
                    Math.abs(nums[n - 1] - a) - Math.abs(a - b));

            // Track min(max(a,b))
            minMax = Math.min(minMax, Math.max(a, b));

            // Track max(min(a,b))
            maxMin = Math.max(maxMin, Math.min(a, b));
        }

        // Maximum gain when both ends of the reversed
        // subarray are inside the array
        gain = Math.max(gain, 2 * (maxMin - minMax));

        return original + gain;
    }
}