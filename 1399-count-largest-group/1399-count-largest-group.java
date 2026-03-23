import java.util.*;

class Solution {
    public int countLargestGroup(int n) {
        Map<Integer, Integer> map = new HashMap<>();
        
        // Step 1: Count frequency of each digit sum
        for (int i = 1; i <= n; i++) {
            int sum = digitSum(i);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        // Step 2: Find max group size
        int maxSize = 0;
        for (int count : map.values()) {
            maxSize = Math.max(maxSize, count);
        }
        
        // Step 3: Count how many groups have max size
        int result = 0;
        for (int count : map.values()) {
            if (count == maxSize) {
                result++;
            }
        }
        
        return result;
    }
    
    // Helper function to calculate digit sum
    private int digitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}