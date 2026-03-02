import java.util.*;

class Solution {
    public int[] recoverArray(int n, int[] sums) {
        List<Integer> result = new ArrayList<>();
        Arrays.sort(sums);

        List<Integer> current = new ArrayList<>();
        for (int x : sums) current.add(x);

        helper(n, current, result);

        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }
        return ans;
    }

    private void helper(int n, List<Integer> sums, List<Integer> result) {
        if (n == 0) return;

        int x = sums.get(1) - sums.get(0);

        Map<Integer, Integer> count = new HashMap<>();
        for (int s : sums) {
            count.put(s, count.getOrDefault(s, 0) + 1);
        }

        List<Integer> withoutX = new ArrayList<>();
        List<Integer> withX = new ArrayList<>();

        for (int s : sums) {
            if (count.get(s) == 0) continue;

            count.put(s, count.get(s) - 1);
            int sx = s + x;
            count.put(sx, count.get(sx) - 1);

            withoutX.add(s);
            withX.add(sx);
        }

        // If 0 is in withoutX, x is positive
        if (withoutX.contains(0)) {
            result.add(x);
            helper(n - 1, withoutX, result);
        } else {
            // x is negative
            result.add(-x);
            helper(n - 1, withX, result);
        }
    }
}