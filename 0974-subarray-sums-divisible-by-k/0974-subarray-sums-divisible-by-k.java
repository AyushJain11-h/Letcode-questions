import java.util.HashMap;
import java.util.Map;

class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // remainder 0 seen once initially
        
        int sum = 0;
        int count = 0;
        
        for (int num : nums) {
            sum += num;
            
            // Handle negative remainders
            int rem = ((sum % k) + k) % k;
            
            // If this remainder appeared before, add its frequency
            count += map.getOrDefault(rem, 0);
            
            // Store/update frequency of current remainder
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        
        return count;
    }
}