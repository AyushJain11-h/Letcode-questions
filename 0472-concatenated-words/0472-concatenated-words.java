import java.util.*;

class Solution {

    public List<String> findAllConcatenatedWordsInADict(String[] words) {

        Set<String> set = new HashSet<>();

        // Add all words to the set
        for (String word : words) {
            if (!word.isEmpty()) {
                set.add(word);
            }
        }

        List<String> result = new ArrayList<>();

        for (String word : words) {
            // Temporarily remove the word itself
            set.remove(word);

            if (canForm(word, set)) {
                result.add(word);
            }

            // Add it back
            set.add(word);
        }

        return result;
    }

    private boolean canForm(String word, Set<String> set) {

        int n = word.length();

        // dp[i] = true if word[0...i-1] can be formed
        // using words from the dictionary
        boolean[] dp = new boolean[n + 1];

        dp[0] = true;

        for (int i = 0; i < n; i++) {

            if (!dp[i]) {
                continue;
            }

            for (int j = i + 1; j <= n; j++) {

                if (set.contains(word.substring(i, j))) {
                    dp[j] = true;
                }
            }
        }

        return dp[n];
    }
}