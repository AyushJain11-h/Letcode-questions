class Solution {
    public int findIntegers(int n) {
        // dp[i] = number of binary strings of length i without consecutive 1s
        int[] dp = new int[32];
        dp[0] = 1;
        dp[1] = 2;

        for (int i = 2; i < 32; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        int result = 0;
        int prevBit = 0;

        for (int i = 30; i >= 0; i--) {
            if ((n & (1 << i)) != 0) {
                result += dp[i];
                if (prevBit == 1) {
                    return result;
                }
                prevBit = 1;
            } else {
                prevBit = 0;
            }
        }

        return result + 1;
    }
}