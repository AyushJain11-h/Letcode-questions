import java.util.*;

class Solution {
    public int shortestSubarray(int[] nums, int k) {

        int n = nums.length;

        // Prefix sum
        long[] prefix = new long[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        // Monotonic increasing deque of indices
        Deque<Integer> deque = new ArrayDeque<>();

        int ans = n + 1;

        for (int i = 0; i <= n; i++) {

            // Check if current prefix sum - oldest prefix sum >= k
            while (!deque.isEmpty()
                    && prefix[i] - prefix[deque.peekFirst()] >= k) {

                ans = Math.min(ans, i - deque.pollFirst());
            }

            // Maintain increasing prefix sums
            while (!deque.isEmpty()
                    && prefix[i] <= prefix[deque.peekLast()]) {

                deque.pollLast();
            }

            deque.offerLast(i);
        }

        return ans == n + 1 ? -1 : ans;
    }
}