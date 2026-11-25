
class Solution {
    public boolean containsPattern(int[] arr, int m, int k) {
        int n = arr.length;

        for (int i = 0; i <= n - m * k; i++) {
            boolean found = true;

            for (int j = 0; j < m * k; j++) {
                if (arr[i + j] != arr[i + j % m]) {
                    found = false;
                    break;
                }
            }

            if (found) {
                return true;
            }
        }

        return false;
    }
}
