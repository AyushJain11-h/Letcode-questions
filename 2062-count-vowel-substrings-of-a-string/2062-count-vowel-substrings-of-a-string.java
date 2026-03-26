class Solution {
    public int countVowelSubstrings(String word) {
        int count = 0;
        
        for (int i = 0; i < word.length(); i++) {
            int[] freq = new int[5]; // a, e, i, o, u
            int unique = 0;
            
            for (int j = i; j < word.length(); j++) {
                char ch = word.charAt(j);
                
                int idx = getVowelIndex(ch);
                if (idx == -1) break; // stop if consonant
                
                if (freq[idx] == 0) unique++;
                freq[idx]++;
                
                if (unique == 5) count++;
            }
        }
        
        return count;
    }

    private int getVowelIndex(char ch) {
        if (ch == 'a') return 0;
        if (ch == 'e') return 1;
        if (ch == 'i') return 2;
        if (ch == 'o') return 3;
        if (ch == 'u') return 4;
        return -1;
    }
}