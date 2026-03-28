class Solution {
    static final int MOD = 1_000_000_007;
    String s1, s2, evil;
    int n, m;
    int[] lps;
    Integer[][][][] dp;

    public int findGoodStrings(int n, String s1, String s2, String evil) {
        this.n = n;
        this.s1 = s1;
        this.s2 = s2;
        this.evil = evil;
        this.m = evil.length();

        buildLPS();
        dp = new Integer[n + 1][m + 1][2][2];

        return dfs(0, 0, 1, 1);
    }

    private int dfs(int idx, int matched, int tightLow, int tightHigh) {
        if (matched == m) return 0; // evil found -> invalid
        if (idx == n) return 1;     // valid good string found

        if (dp[idx][matched][tightLow][tightHigh] != null) {
            return dp[idx][matched][tightLow][tightHigh];
        }

        char from = tightLow == 1 ? s1.charAt(idx) : 'a';
        char to = tightHigh == 1 ? s2.charAt(idx) : 'z';

        long ans = 0;

        for (char ch = from; ch <= to; ch++) {
            int newMatched = matched;

            while (newMatched > 0 && evil.charAt(newMatched) != ch) {
                newMatched = lps[newMatched - 1];
            }

            if (evil.charAt(newMatched) == ch) {
                newMatched++;
            }

            int newTightLow = (tightLow == 1 && ch == from) ? 1 : 0;
            int newTightHigh = (tightHigh == 1 && ch == to) ? 1 : 0;

            ans += dfs(idx + 1, newMatched, newTightLow, newTightHigh);
            ans %= MOD;
        }

        return dp[idx][matched][tightLow][tightHigh] = (int) ans;
    }

    private void buildLPS() {
        lps = new int[m];
        for (int i = 1, len = 0; i < m; ) {
            if (evil.charAt(i) == evil.charAt(len)) {
                lps[i++] = ++len;
            } else if (len > 0) {
                len = lps[len - 1];
            } else {
                lps[i++] = 0;
            }
        }
    }
}