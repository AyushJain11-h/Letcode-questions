class Solution {
    public int numOfArrays(int n, int m, int k) {
        final int MOD = 1_000_000_007;

        // dp[len][max][cost]
        int[][][] dp = new int[n + 1][m + 1][k + 1];

        // Base case:
        // Array of length 1, maximum = num, cost = 1
        for (int num = 1; num <= m; num++) {
            dp[1][num][1] = 1;
        }

        for (int len = 2; len <= n; len++) {
            for (int max = 1; max <= m; max++) {
                for (int cost = 1; cost <= k; cost++) {

                    // Add a number <= current maximum
                    // There are 'max' choices
                    dp[len][max][cost] =
                        (int) ((long) dp[len - 1][max][cost] * max % MOD);

                    // Add a new maximum
                    if (cost > 1) {
                        for (int prevMax = 1; prevMax < max; prevMax++) {
                            dp[len][max][cost] += dp[len - 1][prevMax][cost - 1];

                            if (dp[len][max][cost] >= MOD) {
                                dp[len][max][cost] -= MOD;
                            }
                        }
                    }
                }
            }
        }

        int answer = 0;

        for (int max = 1; max <= m; max++) {
            answer += dp[n][max][k];

            if (answer >= MOD) {
                answer -= MOD;
            }
        }

        return answer;
    }
}