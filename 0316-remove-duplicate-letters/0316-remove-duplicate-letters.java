import java.util.*;

class Solution {
    public String removeDuplicateLetters(String s) {
        int[] lastIndex = new int[26];
        boolean[] used = new boolean[26];
        Stack<Character> stack = new Stack<>();
        
        // Store last occurrence of each character
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - 'a'] = i;
        }
        
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            
            // If already used, skip
            if (used[current - 'a']) continue;
            
            // Maintain lexicographical order
            while (!stack.isEmpty() 
                    && stack.peek() > current 
                    && lastIndex[stack.peek() - 'a'] > i) {
                
                char removed = stack.pop();
                used[removed - 'a'] = false;
            }
            
            stack.push(current);
            used[current - 'a'] = true;
        }
        
        // Build result
        StringBuilder result = new StringBuilder();
        for (char c : stack) {
            result.append(c);
        }
        
        return result.toString();
    }
}