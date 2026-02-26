import java.util.*;

class Solution {
    public int longestAwesome(String s) {

        // mask -> earliest index
        Map<Integer, Integer> firstSeen = new HashMap<>();
        firstSeen.put(0, -1);

        int mask = 0;
        int ans = 0;

        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - '0';

            // toggle bit for current digit
            mask ^= (1 << digit);

            // Case 1: exact same mask
            ans = Math.max(ans, i - firstSeen.getOrDefault(mask, i));

            // Case 2: differ by exactly one bit
            for (int d = 0; d < 10; d++) {
                int candidate = mask ^ (1 << d);
                if (firstSeen.containsKey(candidate)) {
                    ans = Math.max(ans, i - firstSeen.get(candidate));
                }
            }

            // store earliest occurrence
            firstSeen.putIfAbsent(mask, i);
        }

        return ans;
    }
}