import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int constrainedSubsetSum(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        Deque<Integer> deque = new LinkedList<>();
        
        int result = nums[0];
        
        for (int i = 0; i < n; i++) {
            // Best previous dp within range k
            dp[i] = nums[i];
            if (!deque.isEmpty()) {
                dp[i] = Math.max(dp[i], nums[i] + dp[deque.peekFirst()]);
            }
            
            result = Math.max(result, dp[i]);
            
            // Maintain decreasing deque
            while (!deque.isEmpty() && dp[deque.peekLast()] <= dp[i]) {
                deque.pollLast();
            }
            
            // Only useful positive sums
            if (dp[i] > 0) {
                deque.offerLast(i);
            }
            
            // Remove out of window indices
            if (!deque.isEmpty() && deque.peekFirst() <= i - k) {
                deque.pollFirst();
            }
        }
        
        return result;
    }
}