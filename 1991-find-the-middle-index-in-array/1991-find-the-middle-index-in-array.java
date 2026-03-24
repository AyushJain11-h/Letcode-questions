class Solution {
    public int findMiddleIndex(int[] nums) {
        int totalSum = 0;
        
        // Step 1: Calculate total sum
        for (int num : nums) {
            totalSum += num;
        }

        int leftSum = 0;

        // Step 2: Traverse and check condition
        for (int i = 0; i < nums.length; i++) {
            int rightSum = totalSum - leftSum - nums[i];

            if (leftSum == rightSum) {
                return i;
            }

            leftSum += nums[i];
        }

        return -1;
    }
}