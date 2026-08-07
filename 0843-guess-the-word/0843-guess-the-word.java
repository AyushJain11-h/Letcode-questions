import java.util.*;

class Solution {
    public void findSecretWord(String[] words, Master master) {

        List<String> candidates = new ArrayList<>(Arrays.asList(words));

        // This testcase allows 30 guesses.
        for (int attempt = 0; attempt < 30 && !candidates.isEmpty(); attempt++) {

            String bestWord = candidates.get(0);
            int bestScore = Integer.MAX_VALUE;

            // Find the guess that minimizes the largest
            // possible remaining group.
            for (String word : candidates) {

                int[] groups = new int[7];

                for (String other : candidates) {
                    int matches = getMatches(word, other);
                    groups[matches]++;
                }

                int maxGroup = 0;

                for (int count : groups) {
                    maxGroup = Math.max(maxGroup, count);
                }

                if (maxGroup < bestScore) {
                    bestScore = maxGroup;
                    bestWord = word;
                }
            }

            int matches = master.guess(bestWord);

            if (matches == 6) {
                return;
            }

            // Keep only words that would produce the same
            // number of matches with bestWord.
            List<String> next = new ArrayList<>();

            for (String word : candidates) {
                if (getMatches(bestWord, word) == matches) {
                    next.add(word);
                }
            }

            candidates = next;
        }
    }

    private int getMatches(String a, String b) {
        int count = 0;

        for (int i = 0; i < 6; i++) {
            if (a.charAt(i) == b.charAt(i)) {
                count++;
            }
        }

        return count;
    }
}