class Solution {
    public boolean isPrefixString(String s, String[] words) {
        StringBuilder sb = new StringBuilder();
        
        for (String word : words) {
            sb.append(word);
            
            // If length exceeds s, stop early
            if (sb.length() > s.length()) {
                return false;
            }
            
            // Check if matches so far
            if (sb.toString().equals(s)) {
                return true;
            }
        }
        
        return false;
    }
}