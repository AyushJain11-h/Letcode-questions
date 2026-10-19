
import java.util.*;

class Solution {
    public List<Integer> minSubsequence(int[] nums) {
        Arrays.sort(nums);

        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        List<Integer> result = new ArrayList<>();
        int selectedSum = 0;

        for (int i = nums.length - 1; i >= 0; i--) {
            selectedSum += nums[i];
            result.add(nums[i]);

            if (selectedSum > totalSum - selectedSum) {
                break;
            }
        }

        return result;
    }
}
