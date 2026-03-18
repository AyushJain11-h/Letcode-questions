import java.util.*;

class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char digit : num.toCharArray()) {
            // remove larger digits from stack
            while (!stack.isEmpty() && k > 0 && stack.peekLast() > digit) {
                stack.pollLast();
                k--;
            }
            stack.offerLast(digit);
        }

        // if k still remains, remove from end
        while (k > 0 && !stack.isEmpty()) {
            stack.pollLast();
            k--;
        }

        // build result and remove leading zeros
        StringBuilder sb = new StringBuilder();
        boolean leadingZero = true;

        for (char digit : stack) {
            if (leadingZero && digit == '0') continue;
            leadingZero = false;
            sb.append(digit);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}