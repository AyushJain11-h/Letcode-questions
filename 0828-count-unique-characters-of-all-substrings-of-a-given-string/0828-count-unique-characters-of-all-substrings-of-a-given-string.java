class Solution {
    public int uniqueLetterString(String s) {
        int n = s.length();
        int[][] index = new int[26][2];

        for (int i = 0; i < 26; i++) {
            index[i][0] = -1;
            index[i][1] = -1;
        }

        long ans = 0;

        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'A';
            ans += (long) (i - index[c][1]) * (index[c][1] - index[c][0]);
            index[c][0] = index[c][1];
            index[c][1] = i;
        }

        for (int c = 0; c < 26; c++) {
            ans += (long) (n - index[c][1]) * (index[c][1] - index[c][0]);
        }

        return (int) ans;
    }
}