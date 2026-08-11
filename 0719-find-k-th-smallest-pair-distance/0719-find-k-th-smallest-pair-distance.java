import java.util.*;

class Solution {
    public int smallestDistancePair(int[] nums, int k) {

        Arrays.sort(nums);

        int left = 0;
        int right = nums[nums.length - 1] - nums[0];

        while (left < right) {

            int mid = left + (right - left) / 2;

            // Count pairs having distance <= mid
            int count = 0;
            int j = 0;

            for (int i = 0; i < nums.length; i++) {

                while (j < nums.length &&
                       nums[j] - nums[i] <= mid) {
                    j++;
                }

                count += j - i - 1;
            }

            if (count >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}