class Solution {
    public boolean hasAlternatingBits(int n) {
        
        // Get the last bit
        int previousBit = n & 1;
        
        n >>= 1;

        while (n > 0) {
            int currentBit = n & 1;

            // If two consecutive bits are same
            if (currentBit == previousBit) {
                return false;
            }

            previousBit = currentBit;
            n >>= 1;
        }

        return true;
    }
}