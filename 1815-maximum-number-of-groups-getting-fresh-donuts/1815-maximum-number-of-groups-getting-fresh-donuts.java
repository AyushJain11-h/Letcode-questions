import java.util.*;

class Solution {
    private int batchSize;
    private Map<Long, Integer> memo = new HashMap<>();

    public int maxHappyGroups(int batchSize, int[] groups) {
        this.batchSize = batchSize;
        int[] count = new int[batchSize];
        int happy = 0;

        // Count remainders
        for (int g : groups) {
            int r = g % batchSize;
            if (r == 0) happy++;
            else count[r]++;
        }

        // Pair complementary remainders
        for (int i = 1; i <= batchSize / 2; i++) {
            if (i == batchSize - i) {
                happy += count[i] / 2;
                count[i] %= 2;
            } else {
                int pairs = Math.min(count[i], count[batchSize - i]);
                happy += pairs;
                count[i] -= pairs;
                count[batchSize - i] -= pairs;
            }
        }

        return happy + dfs(encode(count), 0);
    }

    private int dfs(long state, int curr) {
        if (state == 0) return 0;
        if (memo.containsKey((state << 5) | curr))
            return memo.get((state << 5) | curr);

        int best = 0;
        for (int r = 1; r < batchSize; r++) {
            int cnt = (int)((state >> (r * 5)) & 31);
            if (cnt > 0) {
                long next = state - (1L << (r * 5));
                int nextCurr = (curr + r) % batchSize;
                int gain = (curr == 0 ? 1 : 0);
                best = Math.max(best, gain + dfs(next, nextCurr));
            }
        }

        memo.put((state << 5) | curr, best);
        return best;
    }

    private long encode(int[] count) {
        long state = 0;
        for (int i = 1; i < count.length; i++) {
            state |= (long) count[i] << (i * 5);
        }
        return state;
    }
}