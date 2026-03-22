class Solution {
    public int countOdds(int low, int high) {
        int total = high - low + 1;
        
        if (low % 2 == 1 || high % 2 == 1) {
            return (total + 1) / 2;
        }
        
        return total / 2;
    }
}