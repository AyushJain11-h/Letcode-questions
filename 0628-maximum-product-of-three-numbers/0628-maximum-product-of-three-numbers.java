class Solution {
    public int maximumProduct(int[] nums) {

        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for (int num : nums) {

            // Find 3 largest numbers
            if (num >= max1) {
                max3 = max2;
                max2 = max1;
                max1 = num;
            } 
            else if (num >= max2) {
                max3 = max2;
                max2 = num;
            } 
            else if (num > max3) {
                max3 = num;
            }

            // Find 2 smallest numbers
            if (num <= min1) {
                min2 = min1;
                min1 = num;
            } 
            else if (num < min2) {
                min2 = num;
            }
        }

        // Option 1: Three largest
        int product1 = max1 * max2 * max3;

        // Option 2: Two smallest × largest
        int product2 = min1 * min2 * max1;

        return Math.max(product1, product2);
    }
}