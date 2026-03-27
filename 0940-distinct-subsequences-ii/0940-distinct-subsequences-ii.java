class Solution {
    public int distinctSubseqII(String s) {
        int mod = 1_000_000_007;
        long[] dp = new long[26];
        long total = 0;

        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            long newCount = (total + 1) % mod;

            total = (total + newCount - dp[idx] + mod) % mod;
            dp[idx] = newCount;
        }

        return (int) total;
    }
}