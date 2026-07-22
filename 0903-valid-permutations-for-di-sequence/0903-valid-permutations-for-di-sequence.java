class Solution {
    private static final int MOD = 1_000_000_007;

    public int numPermsDISequence(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        int[] ndp = new int[n + 1];

        for (int j = 0; j <= n; j++) {
            dp[j] = 1;
        }

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'I') {
                int sum = 0;
                for (int j = 0; j < n - i; j++) {
                    sum = (sum + dp[j]) % MOD;
                    ndp[j] = sum;
                }
            } else {
                int sum = 0;
                for (int j = n - i - 1; j >= 0; j--) {
                    sum = (sum + dp[j + 1]) % MOD;
                    ndp[j] = sum;
                }
            }

            int[] temp = dp;
            dp = ndp;
            ndp = temp;
        }

        return dp[0];
    }
}