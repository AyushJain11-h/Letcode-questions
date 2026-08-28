class Solution {
    public int[] shortestToChar(String s, char c) {
        int n = s.length();
        int[] ans = new int[n];

        // Left to right
        int distance = n;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == c) {
                distance = 0;
            } else {
                distance++;
            }

            ans[i] = distance;
        }

        // Right to left
        distance = n;

        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == c) {
                distance = 0;
            } else {
                distance++;
            }

            ans[i] = Math.min(ans[i], distance);
        }

        return ans;
    }
}