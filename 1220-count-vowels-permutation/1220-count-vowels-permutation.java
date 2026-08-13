class Solution {
    public int countVowelPermutation(int n) {
        final int MOD = 1000000007;
        
        // dp[i][j] = number of strings of length i ending with vowel j
        // 0:a, 1:e, 2:i, 3:o, 4:u
        long[][] dp = new long[n + 1][5];
        
        // Base case: strings of length 1
        for (int j = 0; j < 5; j++) {
            dp[1][j] = 1;
        }
        
        // Fill dp table for lengths 2 to n
        for (int i = 2; i <= n; i++) {
            // Each vowel can be followed by certain vowels
            // 'a' can be followed by: 'e' only
            dp[i][0] = dp[i-1][1] % MOD;
            
            // 'e' can be followed by: 'a', 'i'
            dp[i][1] = (dp[i-1][0] + dp[i-1][2]) % MOD;
            
            // 'i' can be followed by: 'a', 'e', 'o', 'u'
            dp[i][2] = (dp[i-1][0] + dp[i-1][1] + dp[i-1][3] + dp[i-1][4]) % MOD;
            
            // 'o' can be followed by: 'i', 'u'
            dp[i][3] = (dp[i-1][2] + dp[i-1][4]) % MOD;
            
            // 'u' can be followed by: 'a' only
            dp[i][4] = dp[i-1][0] % MOD;
        }
        
        // Sum all strings of length n ending with each vowel
        long result = 0;
        for (int j = 0; j < 5; j++) {
            result = (result + dp[n][j]) % MOD;
        }
        
        return (int) result;
    }
}