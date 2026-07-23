class Solution {
    private static final int MOD = 1_000_000_007;

    public int distinctSubseqII(String s) {
        long[] last = new long[26];
        long total = 0;

        for (char c : s.toCharArray()) {
            long newTotal = (total * 2 + 1 - last[c - 'a'] + MOD) % MOD;
            last[c - 'a'] = (total + 1) % MOD;
            total = newTotal;
        }

        return (int) total;
    }
}