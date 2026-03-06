class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }

        if (sum % k != 0) return false;

        boolean[] visited = new boolean[nums.length];
        return backtrack(nums, visited, k, 0, 0, sum / k, 0);
    }

    private boolean backtrack(int[] nums, boolean[] visited, int k, int start, int currentSum, int target, int count) {
        if (count == k - 1) return true;

        if (currentSum == target) {
            return backtrack(nums, visited, k, 0, 0, target, count + 1);
        }

        for (int i = start; i < nums.length; i++) {
            if (!visited[i] && currentSum + nums[i] <= target) {
                visited[i] = true;

                if (backtrack(nums, visited, k, i + 1, currentSum + nums[i], target, count))
                    return true;

                visited[i] = false;
            }
        }

        return false;
    }
}