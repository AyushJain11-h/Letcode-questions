class Solution {
    public boolean checkValidString(String s) {
        int low = 0, high = 0;
        
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                low++;
                high++;
            } else if (ch == ')') {
                low--;
                high--;
            } else { // ch == '*'
                low--;   // treat '*' as ')'
                high++;  // or treat '*' as '('
            }
            
            if (high < 0) return false; // too many ')'
            
            if (low < 0) low = 0; // low can't be negative
        }
        
        return low == 0;
    }
}