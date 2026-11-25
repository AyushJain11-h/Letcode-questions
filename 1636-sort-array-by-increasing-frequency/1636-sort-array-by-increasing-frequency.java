
import java.util.*;

class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();

        // Count frequency of each number
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Sort by frequency ascending,
        // and by value descending when frequencies are equal
        Integer[] arr = Arrays.stream(nums)
                              .boxed()
                              .toArray(Integer[]::new);

        Arrays.sort(arr, (a, b) -> {
            if (freq.get(a).equals(freq.get(b))) {
                return b - a;
            }
            return freq.get(a) - freq.get(b);
        });

        // Convert Integer[] to int[]
        for (int i = 0; i < nums.length; i++) {
            nums[i] = arr[i];
        }

        return nums;
    }
}
