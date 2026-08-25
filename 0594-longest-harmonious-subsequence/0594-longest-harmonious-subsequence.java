import java.util.HashMap;

class Solution {
    public int findLHS(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequency of each number
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int maxLength = 0;

        // Check pairs: num and num + 1
        for (int num : map.keySet()) {
            if (map.containsKey(num + 1)) {
                int length = map.get(num) + map.get(num + 1);
                maxLength = Math.max(maxLength, length);
            }
        }

        return maxLength;
    }
}