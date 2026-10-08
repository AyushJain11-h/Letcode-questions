class Solution {
    public void duplicateZeros(int[] arr) {
        int possibleDups = 0;
        int length = arr.length;

        // Count zeros that can be duplicated
        for (int i = 0; i < length - possibleDups; i++) {
            if (arr[i] == 0) {
                if (i == length - possibleDups - 1) {
                    // Special case: zero at the last available position
                    arr[length - 1] = 0;
                    length--;
                    break;
                }
                possibleDups++;
            }
        }

        // Shift elements from right to left
        int last = length - possibleDups - 1;

        for (int i = last; i >= 0; i--) {
            if (arr[i] == 0) {
                arr[i + possibleDups] = 0;
                possibleDups--;
                arr[i + possibleDups] = 0;
            } else {
                arr[i + possibleDups] = arr[i];
            }
        }
    }
}