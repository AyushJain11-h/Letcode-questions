class Solution {
    public boolean validMountainArray(int[] arr) {
        int n = arr.length;

        // A mountain needs at least 3 elements
        if (n < 3) {
            return false;
        }

        int i = 0;

        // Go up
        while (i + 1 < n && arr[i] < arr[i + 1]) {
            i++;
        }

        // Peak cannot be the first or last element
        if (i == 0 || i == n - 1) {
            return false;
        }

        // Go down
        while (i + 1 < n && arr[i] > arr[i + 1]) {
            i++;
        }

        // We should reach the end
        return i == n - 1;
    }
}