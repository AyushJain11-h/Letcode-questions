class Solution {
    public int minSwap(int[] nums1, int[] nums2) {
        int n = nums1.length;

        int keep = 0;   // no swap at current index
        int swap = 1;   // swap at current index

        for (int i = 1; i < n; i++) {
            int newKeep = Integer.MAX_VALUE;
            int newSwap = Integer.MAX_VALUE;

            // Case 1: sequences already increasing without swap
            if (nums1[i] > nums1[i - 1] && nums2[i] > nums2[i - 1]) {
                newKeep = Math.min(newKeep, keep);
                newSwap = Math.min(newSwap, swap + 1);
            }

            // Case 2: sequences increasing if swapped
            if (nums1[i] > nums2[i - 1] && nums2[i] > nums1[i - 1]) {
                newKeep = Math.min(newKeep, swap);
                newSwap = Math.min(newSwap, keep + 1);
            }

            keep = newKeep;
            swap = newSwap;
        }

        return Math.min(keep, swap);
    }
}