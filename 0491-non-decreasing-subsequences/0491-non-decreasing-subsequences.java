import java.util.*;

class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(nums, 0, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, int start, List<Integer> path, List<List<Integer>> result) {
        if (path.size() >= 2) {
            result.add(new ArrayList<>(path));
        }

        Set<Integer> used = new HashSet<>();

        for (int i = start; i < nums.length; i++) {
            // skip duplicates at current level
            if (used.contains(nums[i])) continue;

            // ensure non-decreasing order
            if (path.isEmpty() || nums[i] >= path.get(path.size() - 1)) {
                used.add(nums[i]);
                path.add(nums[i]);

                backtrack(nums, i + 1, path, result);

                path.remove(path.size() - 1); // backtrack
            }
        }
    }
}