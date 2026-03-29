class Solution {
    public String largestNumber(int[] cost, int target) {
        int[] dp = new int[target + 1];
        
        // Initialize with very small value
        for (int i = 1; i <= target; i++) {
            dp[i] = Integer.MIN_VALUE;
        }
        
        dp[0] = 0;
        
        // DP to maximize number of digits
        for (int t = 1; t <= target; t++) {
            for (int d = 0; d < 9; d++) {
                if (t >= cost[d] && dp[t - cost[d]] != Integer.MIN_VALUE) {
                    dp[t] = Math.max(dp[t], dp[t - cost[d]] + 1);
                }
            }
        }
        
        // If impossible
        if (dp[target] < 0) return "0";
        
        // Reconstruct largest number greedily
        StringBuilder sb = new StringBuilder();
        int t = target;
        
        for (int d = 8; d >= 0; d--) {
            while (t >= cost[d] && dp[t] == dp[t - cost[d]] + 1) {
                sb.append(d + 1);
                t -= cost[d];
            }
        }
        
        return sb.toString();
    }
}