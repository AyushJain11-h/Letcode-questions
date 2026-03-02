class Solution {
    public int palindromePartition(String s, int k) {
        int n = s.length();
        int[][] cost = new int[n][n];

        // Precompute cost[i][j]
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                cost[i][j] = cost[i + 1][j - 1]
                           + (s.charAt(i) == s.charAt(j) ? 0 : 1);
            }
        }

        int[][] dp = new int[n + 1][k + 1];
        int INF = 1_000_000;

        // Initialize DP
        for (int i = 0; i <= n; i++) {
            for (int p = 0; p <= k; p++) {
                dp[i][p] = INF;
            }
        }

        dp[0][0] = 0;

        // DP transitions
        for (int i = 1; i <= n; i++) {
            for (int p = 1; p <= k; p++) {
                for (int j = p - 1; j < i; j++) {
                    dp[i][p] = Math.min(
                        dp[i][p],
                        dp[j][p - 1] + cost[j][i - 1]
                    );
                }
            }
        }

        return dp[n][k];
    }
}