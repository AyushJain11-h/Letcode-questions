
class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] freq = new int[26];

        for (char c : chars.toCharArray()) {
            freq[c - 'a']++;
        }

        int result = 0;

        for (String word : words) {
            int[] count = new int[26];
            boolean canForm = true;

            for (char c : word.toCharArray()) {
                count[c - 'a']++;

                if (count[c - 'a'] > freq[c - 'a']) {
                    canForm = false;
                    break;
                }
            }

            if (canForm) {
                result += word.length();
            }
        }

        return result;
    }
}
