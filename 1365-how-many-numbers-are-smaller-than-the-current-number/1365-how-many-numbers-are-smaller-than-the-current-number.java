class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] count = new int[101]; // range: 0 to 100
        
        // Count frequency
        for (int num : nums) {
            count[num]++;
        }
        
        // Prefix sum: count[i] = how many numbers <= i
        for (int i = 1; i < 101; i++) {
            count[i] += count[i - 1];
        }
        
        int[] result = new int[nums.length];
        
        // Fill result
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                result[i] = 0;
            } else {
                result[i] = count[nums[i] - 1];
            }
        }
        
        return result;
    }
}