class Solution {
    public int numSteps(String s) {
        int steps = 0;
        int carry = 0;

        // Traverse from right to left (excluding the first bit)
        for (int i = s.length() - 1; i > 0; i--) {
            int bit = (s.charAt(i) - '0') + carry;

            if (bit % 2 == 0) {
                // Even → divide by 2
                steps += 1;
            } else {
                // Odd → add 1 (causes carry), then divide by 2
                steps += 2;
                carry = 1;
            }
        }

        // If carry remains, one extra step is needed
        return steps + carry;
    }
}