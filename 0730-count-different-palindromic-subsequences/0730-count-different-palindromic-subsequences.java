class Solution {

    public int countPalindromicSubsequences(String s) {

        int n = s.length();
        int MOD = 1_000_000_007;

        long[][] dp = new long[n][n];

        // Every single character is a palindrome
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        for (int len = 2; len <= n; len++) {

            for (int i = 0; i + len - 1 < n; i++) {

                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j)) {

                    int left = i + 1;
                    int right = j - 1;

                    // Find first occurrence of s[i]
                    // from left side
                    while (left <= right &&
                           s.charAt(left) != s.charAt(i)) {
                        left++;
                    }

                    // Find last occurrence of s[j]
                    // from right side
                    while (left <= right &&
                           s.charAt(right) != s.charAt(j)) {
                        right--;
                    }

                    if (left > right) {
                        // No same character inside
                        dp[i][j] = (2 * dp[i + 1][j - 1] + 2) % MOD;
                    }
                    else if (left == right) {
                        // One same character inside
                        dp[i][j] = (2 * dp[i + 1][j - 1] + 1) % MOD;
                    }
                    else {
                        // Duplicate palindromes exist
                        dp[i][j] = (2 * dp[i + 1][j - 1]
                                - dp[left + 1][right - 1]) % MOD;

                        if (dp[i][j] < 0) {
                            dp[i][j] += MOD;
                        }
                    }

                } else {

                    // First and last characters are different
                    dp[i][j] = dp[i + 1][j]
                              + dp[i][j - 1]
                              - dp[i + 1][j - 1];

                    dp[i][j] %= MOD;

                    if (dp[i][j] < 0) {
                        dp[i][j] += MOD;
                    }
                }
            }
        }

        return (int) dp[0][n - 1];
    }
}