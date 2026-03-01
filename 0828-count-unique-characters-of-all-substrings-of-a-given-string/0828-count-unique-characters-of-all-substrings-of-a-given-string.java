class Solution {
    public int uniqueLetterString(String s) {
        int n = s.length();
        int[][] pos = new int[26][2];
        
        // Initialize last positions to -1
        for (int i = 0; i < 26; i++) {
            pos[i][0] = -1;
            pos[i][1] = -1;
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'A';

            int prevPrev = pos[c][0];
            int prev = pos[c][1];

            // Contribution of previous occurrence
            result += (i - prev) * (prev - prevPrev);

            // Update positions
            pos[c][0] = prev;
            pos[c][1] = i;
        }

        // Add contribution for last occurrence of each character
        for (int c = 0; c < 26; c++) {
            int prevPrev = pos[c][0];
            int prev = pos[c][1];
            result += (n - prev) * (prev - prevPrev);
        }

        return result;
    }
}