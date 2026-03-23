class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        boolean[] isAllowed = new boolean[26];
        
        // Mark allowed characters
        for (char c : allowed.toCharArray()) {
            isAllowed[c - 'a'] = true;
        }
        
        int count = 0;
        
        // Check each word
        for (String word : words) {
            boolean isConsistent = true;
            
            for (char c : word.toCharArray()) {
                if (!isAllowed[c - 'a']) {
                    isConsistent = false;
                    break;
                }
            }
            
            if (isConsistent) {
                count++;
            }
        }
        
        return count;
    }
}