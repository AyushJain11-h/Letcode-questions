class Solution {
    public int maxScore(String s) {
        int totalOnes = 0;
        
        // Count total 1s
        for (char c : s.toCharArray()) {
            if (c == '1') totalOnes++;
        }
        
        int maxScore = 0;
        int leftZeros = 0;
        int rightOnes = totalOnes;
        
        // Traverse (leave last char to keep right non-empty)
        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == '0') {
                leftZeros++;
            } else {
                rightOnes--;
            }
            
            maxScore = Math.max(maxScore, leftZeros + rightOnes);
        }
        
        return maxScore;
    }
}