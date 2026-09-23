class Solution {
    public String toHex(int num) {
        
        if (num == 0) {
            return "0";
        }

        char[] hex = "0123456789abcdef".toCharArray();
        StringBuilder result = new StringBuilder();

        // Use unsigned right shift
        while (num != 0) {
            int digit = num & 15;  // Get last 4 bits
            result.append(hex[digit]);
            num >>>= 4;
        }

        return result.reverse().toString();
    }
}