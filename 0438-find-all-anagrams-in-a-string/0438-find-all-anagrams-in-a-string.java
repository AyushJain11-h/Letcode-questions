import java.util.*;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        
        if (s.length() < p.length()) return result;

        int[] count = new int[26];

        // Store frequency of p
        for (char c : p.toCharArray()) {
            count[c - 'a']++;
        }

        int left = 0, right = 0, required = p.length();

        while (right < s.length()) {
            // If char is needed, decrease required
            if (count[s.charAt(right) - 'a'] > 0) {
                required--;
            }

            // Decrease frequency
            count[s.charAt(right) - 'a']--;
            right++;

            // When window size matches p
            if (required == 0) {
                result.add(left);
            }

            // Maintain window size
            if (right - left == p.length()) {
                // If char leaving window was useful
                if (count[s.charAt(left) - 'a'] >= 0) {
                    required++;
                }

                // Restore frequency
                count[s.charAt(left) - 'a']++;
                left++;
            }
        }

        return result;
    }
}