public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;

        for (int i = 0; i < 32; i++) {
            result <<= 1;          // shift result left
            result |= (n & 1);     // add last bit of n
            n >>= 1;               // shift n right
        }
        return result;
    }
}
