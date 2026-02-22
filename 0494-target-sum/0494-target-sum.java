class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) sum += num;

        // Edge cases
        if (Math.abs(target) > sum || (sum + target) % 2 != 0) {
            return 0;
        }

        int requiredSum = (sum + target) / 2;

        // DP array
        int[] dp = new int[requiredSum + 1];
        dp[0] = 1;

        for (int num : nums) {
            for (int j = requiredSum; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        return dp[requiredSum];
    }
}