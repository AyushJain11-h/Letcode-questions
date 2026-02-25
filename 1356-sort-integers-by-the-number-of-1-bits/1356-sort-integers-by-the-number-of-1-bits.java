import java.util.*;

class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] nums = new Integer[arr.length];
        
        // Convert int[] to Integer[]
        for (int i = 0; i < arr.length; i++) {
            nums[i] = arr[i];
        }

        // Custom sorting
        Arrays.sort(nums, (a, b) -> {
            int countA = Integer.bitCount(a);
            int countB = Integer.bitCount(b);
            
            if (countA == countB) {
                return a - b;   // sort by value if bit count is same
            }
            return countA - countB; // sort by number of 1 bits
        });

        // Convert back to int[]
        for (int i = 0; i < arr.length; i++) {
            arr[i] = nums[i];
        }

        return arr;
    }
}