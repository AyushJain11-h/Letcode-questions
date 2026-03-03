class Solution {
    public int countSegments(String s) {
        int count = 0;
        
        for (int i = 0; i < s.length(); i++) {
            // If current char is not space
            // and either it's the first character
            // or previous character is a space
            if (s.charAt(i) != ' ' && 
               (i == 0 || s.charAt(i - 1) == ' ')) {
                count++;
            }
        }
        
        return count;
    }
}