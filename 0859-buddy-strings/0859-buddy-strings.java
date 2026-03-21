class Solution {
    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        // Case 1: strings are already equal
        if (s.equals(goal)) {
            int[] freq = new int[26];
            for (char c : s.toCharArray()) {
                freq[c - 'a']++;
                if (freq[c - 'a'] > 1) {
                    return true; // duplicate found
                }
            }
            return false;
        }

        // Case 2: strings are not equal
        int first = -1, second = -1;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != goal.charAt(i)) {
                if (first == -1) {
                    first = i;
                } else if (second == -1) {
                    second = i;
                } else {
                    return false; // more than 2 mismatches
                }
            }
        }

        return second != -1 &&
               s.charAt(first) == goal.charAt(second) &&
               s.charAt(second) == goal.charAt(first);
    }
}