class Solution {
    public int minSwaps(int[][] grid) {
        int n = grid.length;
        int[] zeros = new int[n];

        // Count trailing zeros for each row
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = n - 1; j >= 0 && grid[i][j] == 0; j--) {
                count++;
            }
            zeros[i] = count;
        }

        int swaps = 0;

        // Greedy row fixing
        for (int i = 0; i < n; i++) {
            int required = n - 1 - i;
            int j = i;

            // Find a row with enough trailing zeros
            while (j < n && zeros[j] < required) {
                j++;
            }

            // If not found, impossible
            if (j == n) {
                return -1;
            }

            // Bubble the row up
            while (j > i) {
                int temp = zeros[j];
                zeros[j] = zeros[j - 1];
                zeros[j - 1] = temp;
                j--;
                swaps++;
            }
        }

        return swaps;
    }
}