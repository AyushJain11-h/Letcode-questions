class Solution {
    public int findSubstringInWraproundString(String s) {
        int[] maxLen = new int[26];
        int currLen = 0;

        for (int i = 0; i < s.length(); i++) {
            if (i > 0 && (s.charAt(i) - s.charAt(i - 1) + 26) % 26 == 1) {
                currLen++;
            } else {
                currLen = 1;
            }

            int index = s.charAt(i) - 'a';
            maxLen[index] = Math.max(maxLen[index], currLen);
        }

        int result = 0;
        for (int len : maxLen) {
            result += len;
        }

        return result;
    }
}