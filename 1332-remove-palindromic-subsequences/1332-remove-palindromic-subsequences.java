class Solution {
    public int removePalindromeSub(String s) {
        // Check if string is palindrome
        int left = 0, right = s.length() - 1;
        
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return 2; // not a palindrome
            }
            left++;
            right--;
        }
        
        return 1; // palindrome
    }
}