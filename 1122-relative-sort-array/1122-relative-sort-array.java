class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] count = new int[1001]; // constraints: 0 <= value <= 1000
        
        // Count frequencies
        for (int num : arr1) {
            count[num]++;
        }
        
        int i = 0;
        
        // Place elements according to arr2
        for (int num : arr2) {
            while (count[num] > 0) {
                arr1[i++] = num;
                count[num]--;
            }
        }
        
        // Place remaining elements in ascending order
        for (int num = 0; num < count.length; num++) {
            while (count[num] > 0) {
                arr1[i++] = num;
                count[num]--;
            }
        }
        
        return arr1;
    }
}