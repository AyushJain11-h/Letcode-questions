import java.util.*;

class Solution {
    public List<String> commonChars(String[] words) {

        List<String> result = new ArrayList<>();

        // Frequency of characters in the first word
        int[] minFreq = new int[26];

        for (char c : words[0].toCharArray()) {
            minFreq[c - 'a']++;
        }

        // Compare with every other word
        for (int i = 1; i < words.length; i++) {

            int[] currentFreq = new int[26];

            for (char c : words[i].toCharArray()) {
                currentFreq[c - 'a']++;
            }

            // Keep the minimum frequency
            for (int j = 0; j < 26; j++) {
                minFreq[j] = Math.min(minFreq[j], currentFreq[j]);
            }
        }

        // Build the result
        for (int i = 0; i < 26; i++) {

            while (minFreq[i] > 0) {
                result.add(String.valueOf((char) ('a' + i)));
                minFreq[i]--;
            }
        }

        return result;
    }
}