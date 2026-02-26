class Solution {
    public long countSubstrings(String s) {

        // dp[d][r] = number of substrings ending here
        // with remainder r modulo d
        long[][] dp = new long[10][10];
        long ans = 0;

        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - '0';

            // Update DP for all divisors 1..9
            for (int d = 1; d <= 9; d++) {
                long[] newDp = new long[d];

                // Extend previous substrings
                for (int r = 0; r < d; r++) {
                    if (dp[d][r] > 0) {
                        int newR = (r * 10 + digit) % d;
                        newDp[newR] += dp[d][r];
                    }
                }

                // Single-character substring
                newDp[digit % d]++;

                dp[d] = newDp;
            }

            // Count valid substrings ending here
            if (digit != 0) {
                ans += dp[digit][0];
            }
        }

        return ans;
    }
}