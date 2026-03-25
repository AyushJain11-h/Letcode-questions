class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] count = new int[26];

        // Count frequency of each character
        for (char ch : text.toCharArray()) {
            count[ch - 'a']++;
        }

        // "balloon" needs:
        // b = 1, a = 1, l = 2, o = 2, n = 1
        return Math.min(
                Math.min(count['b' - 'a'], count['a' - 'a']),
                Math.min(
                        Math.min(count['l' - 'a'] / 2, count['o' - 'a'] / 2),
                        count['n' - 'a']
                )
        );
    }
}