class Solution {
    public int atMostNGivenDigitSet(String[] digits, int n) {
        String s = String.valueOf(n);
        int len = s.length();
        int k = digits.length;
        int result = 0;

        // 1. Count numbers with length less than len
        for (int i = 1; i < len; i++) {
            result += Math.pow(k, i);
        }

        // 2. Count numbers with same length
        for (int i = 0; i < len; i++) {
            boolean hasSameDigit = false;
            char curr = s.charAt(i);

            for (String d : digits) {
                char digit = d.charAt(0);
                if (digit < curr) {
                    result += Math.pow(k, len - i - 1);
                } else if (digit == curr) {
                    hasSameDigit = true;
                    break;
                }
            }

            if (!hasSameDigit) {
                return result;
            }
        }

        // Include N itself
        return result + 1;
    }
}