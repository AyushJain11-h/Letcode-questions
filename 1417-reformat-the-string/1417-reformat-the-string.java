class Solution {
    public String reformat(String s) {
        StringBuilder letters = new StringBuilder();
        StringBuilder digits = new StringBuilder();
        
        // Separate letters and digits
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                digits.append(c);
            } else {
                letters.append(c);
            }
        }
        
        // If difference is more than 1 → not possible
        if (Math.abs(letters.length() - digits.length()) > 1) {
            return "";
        }
        
        StringBuilder result = new StringBuilder();
        
        // Decide which to start with
        boolean letterFirst = letters.length() > digits.length();
        
        int i = 0, j = 0;
        
        while (i < letters.length() || j < digits.length()) {
            if (letterFirst && i < letters.length()) {
                result.append(letters.charAt(i++));
            }
            if (j < digits.length()) {
                result.append(digits.charAt(j++));
            }
            if (!letterFirst && i < letters.length()) {
                result.append(letters.charAt(i++));
            }
        }
        
        return result.toString();
    }
}