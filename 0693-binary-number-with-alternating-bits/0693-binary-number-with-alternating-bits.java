public class Solution {
    public boolean hasAlternatingBits(int n) {
        // XOR n with n shifted right by 1
        int xor = n ^ (n >> 1);

        // Check if xor is all 1's in binary
        return (xor & (xor + 1)) == 0;
    }
}
