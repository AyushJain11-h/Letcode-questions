class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] target = new int[26];
        
        // Count required letters from licensePlate
        for (char c : licensePlate.toCharArray()) {
            if (Character.isLetter(c)) {
                target[Character.toLowerCase(c) - 'a']++;
            }
        }
        
        String result = null;
        
        // Check each word
        for (String word : words) {
            int[] freq = new int[26];
            
            for (char c : word.toCharArray()) {
                freq[c - 'a']++;
            }
            
            if (isValid(target, freq)) {
                if (result == null || word.length() < result.length()) {
                    result = word;
                }
            }
        }
        
        return result;
    }
    
    private boolean isValid(int[] target, int[] freq) {
        for (int i = 0; i < 26; i++) {
            if (freq[i] < target[i]) {
                return false;
            }
        }
        return true;
    }
}