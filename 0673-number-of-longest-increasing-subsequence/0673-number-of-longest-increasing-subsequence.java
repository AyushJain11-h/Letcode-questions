class Solution {
    public int findNumberOfLIS(int[] nums) {
        int n = nums.length;

        int[] length = new int[n];
        int[] count = new int[n];

        for (int i = 0; i < n; i++) {
            length[i] = 1;
            count[i] = 1;
        }

        int maxLen = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {

                if (nums[i] > nums[j]) {

                    if (length[j] + 1 > length[i]) {
                        length[i] = length[j] + 1;
                        count[i] = count[j];
                    } 
                    else if (length[j] + 1 == length[i]) {
                        count[i] += count[j];
                    }
                }
            }

            maxLen = Math.max(maxLen, length[i]);
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            if (length[i] == maxLen) {
                result += count[i];
            }
        }

        return result;
    }
}