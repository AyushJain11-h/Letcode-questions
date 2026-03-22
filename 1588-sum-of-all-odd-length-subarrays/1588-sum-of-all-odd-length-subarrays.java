class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int totalSum = 0;

        for (int i = 0; i < n; i++) {
            // Total subarrays including arr[i]
            int totalSubarrays = (i + 1) * (n - i);

            // Only odd length subarrays
            int oddCount = (totalSubarrays + 1) / 2;

            totalSum += arr[i] * oddCount;
        }

        return totalSum;
    }
}