class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s;

        String rev = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + rev;

        int[] lps = buildLPS(combined);

        int palinLength = lps[combined.length() - 1];
        String add = rev.substring(0, s.length() - palinLength);

        return add + s;
    }

    private int[] buildLPS(String str) {
        int n = str.length();
        int[] lps = new int[n];
        int len = 0;

        for (int i = 1; i < n; i++) {
            while (len > 0 && str.charAt(i) != str.charAt(len)) {
                len = lps[len - 1];
            }
            if (str.charAt(i) == str.charAt(len)) {
                len++;
            }
            lps[i] = len;
        }
        return lps;
    }
}