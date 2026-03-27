import java.util.*;

class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        Map<Integer, Integer> indexMap = new HashMap<>();
        
        for (int i = 0; i < n; i++) {
            indexMap.put(arr[i], i);
        }

        int[][] dp = new int[n][n];
        int maxLen = 0;

        for (int j = 0; j < n; j++) {
            for (int i = 0; i < j; i++) {
                int prev = arr[j] - arr[i];

                if (prev < arr[i] && indexMap.containsKey(prev)) {
                    int k = indexMap.get(prev);
                    dp[i][j] = dp[k][i] + 1;
                } else {
                    dp[i][j] = 2;
                }

                maxLen = Math.max(maxLen, dp[i][j]);
            }
        }

        return maxLen > 2 ? maxLen : 0;
    }
}