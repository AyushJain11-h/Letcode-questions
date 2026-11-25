
import java.util.Arrays;

class Solution {
    public int maxProductDifference(int[] nums) {
        Arrays.sort(nums);

        int n = nums.length;

        int largest1 = nums[n - 1];
        int largest2 = nums[n - 2];

        int smallest1 = nums[0];
        int smallest2 = nums[1];

        return (largest1 * largest2) - (smallest1 * smallest2);
    }
}
