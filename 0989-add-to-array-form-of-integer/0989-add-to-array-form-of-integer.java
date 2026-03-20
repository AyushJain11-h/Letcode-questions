import java.util.*;

class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new ArrayList<>();
        
        int i = num.length - 1;
        int carry = k;

        // Process from right to left
        while (i >= 0 || carry > 0) {
            if (i >= 0) {
                carry += num[i];
                i--;
            }

            result.add(carry % 10); // current digit
            carry /= 10;            // update carry
        }

        // Reverse result since we built it backwards
        Collections.reverse(result);
        return result;
    }
}