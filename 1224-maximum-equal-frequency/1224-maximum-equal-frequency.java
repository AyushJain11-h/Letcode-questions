import java.util.*;

class Solution {
    public int maxEqualFreq(int[] nums) {
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> freq = new HashMap<>();
        
        int res = 0, maxFreq = 0;
        
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int oldCount = count.getOrDefault(num, 0);
            
            if (oldCount > 0) {
                freq.put(oldCount, freq.get(oldCount) - 1);
                if (freq.get(oldCount) == 0) freq.remove(oldCount);
            }
            
            int newCount = oldCount + 1;
            count.put(num, newCount);
            freq.put(newCount, freq.getOrDefault(newCount, 0) + 1);
            
            maxFreq = Math.max(maxFreq, newCount);
            int n = i + 1;
            
            // Case 1: all numbers appear once
            if (maxFreq == 1) {
                res = n;
            }
            // Case 2: one number has freq 1, all others have maxFreq
            else if (freq.getOrDefault(1, 0) == 1 &&
                     freq.getOrDefault(maxFreq, 0) * maxFreq + 1 == n) {
                res = n;
            }
            // Case 3: one number has maxFreq, others have maxFreq-1
            else if (freq.getOrDefault(maxFreq, 0) == 1 &&
                     freq.getOrDefault(maxFreq - 1, 0) * (maxFreq - 1) + maxFreq == n) {
                res = n;
            }
        }
        
        return res;
    }
}