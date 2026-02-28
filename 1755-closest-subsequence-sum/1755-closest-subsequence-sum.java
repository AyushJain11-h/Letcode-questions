import java.util.*;

class Solution {
    public int minAbsDifference(int[] nums, int goal) {
        int n = nums.length;
        int mid = n / 2;

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        // Subset sums of left half
        generate(nums, 0, mid, 0, left);
        // Subset sums of right half
        generate(nums, mid, n, 0, right);

        Collections.sort(right);

        int ans = Math.abs(goal);

        for (int s : left) {
            int target = goal - s;
            int idx = Collections.binarySearch(right, target);

            if (idx >= 0) return 0;

            idx = -idx - 1;

            if (idx < right.size())
                ans = Math.min(ans, Math.abs(s + right.get(idx) - goal));
            if (idx > 0)
                ans = Math.min(ans, Math.abs(s + right.get(idx - 1) - goal));
        }

        return ans;
    }

    private void generate(int[] nums, int start, int end, int sum, List<Integer> res) {
        if (start == end) {
            res.add(sum);
            return;
        }
        generate(nums, start + 1, end, sum, res);
        generate(nums, start + 1, end, sum + nums[start], res);
    }
}